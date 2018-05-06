package sa45.t6.sims.repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import sa45.t6.sims.model.Product;

public interface ProductRepository extends JpaRepository<Product, Integer>{
    @Query("SELECT DISTINCT parttype FROM Product")
    ArrayList<String> findAllProductType();
    @Query("SELECT DISTINCT status FROM Product")
    ArrayList<String> findAllProductStatus();
    @Query("SELECT d FROM Product d where d.quantity <d.reorderpoint" )
    ArrayList<Product> FindReorderProduct();
    @Query("SELECT d.quantity FROM Product d where d.partnumber =:epartnumber ")
    int GetCurrentQ(@Param("epartnumber") int epartnumber);
    
   // @Query("Update Product d set d.quantity=(select count(*)from PartInfo b where b.status='new'and b.partnumber=:epartnumber) where d.partnumber=:epartnumber ")
  //  void UpdateQuantity(@Param("epartnumber") int epartnumber);
	
    
    @Query("SELECT d.minreorderquantity FROM Product d where d.partnumber =:epartnumber ")
    int getMinOder(@Param("epartnumber") int epartnumber);
    
    
    @Query("SELECT d.reorderpoint FROM Product d where d.partnumber =:epartnumber ")
	int getReorderQ(@Param("epartnumber") int epartnumber);
    
    @Query("FROM Product WHERE partnumber LIKE CONCAT('%',:qpartnumber,'%')")
	ArrayList<Product> findByPartnumber(@Param("qpartnumber") int qpartnumber);
	
	@Query("FROM Product WHERE name LIKE CONCAT('%',:qpartname,'%')")
	ArrayList<Product> findByPartname(@Param("qpartname") String qpartname);
	
	@Query("FROM Product WHERE manufacturer LIKE CONCAT('%',:qpartmanufacturer,'%')")
	ArrayList<Product> findByPartmanufacturer(@Param("qpartmanufacturer") String qpartmanufacturer);
	
	@Query("FROM Product WHERE status LIKE CONCAT('%',:qpartstatus,'%')")
	ArrayList<Product> findByPartstatus(@Param("qpartstatus") String qpartstatus);

}


