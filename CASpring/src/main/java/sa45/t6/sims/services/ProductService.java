package sa45.t6.sims.services;

import java.util.ArrayList;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import sa45.t6.sims.model.Product;

@Service
public interface ProductService {

    ArrayList<String> findAllProductType();
    
    ArrayList<String> findAllProductStatus();
    
    ArrayList<Product> findAllProduct();

    Product findProduct(int id);

    Product createProduct(Product product);

    Product changeProduct(Product product);

    void removeProduct(Product product);
    
    ArrayList<Product> findproductreorder();
    
ArrayList<Product> findByPartnumber(int partNumber);
	
	ArrayList<Product> findByPartname(String name);
	
	ArrayList<Product> findByPartmanufacturer(String manufacturer);
	
	ArrayList<Product> findByPartstatus(String status);

    
    int getordernumber(int n);
    
    //void UpdateQantity(int partnumber,int addnum);

	

}


