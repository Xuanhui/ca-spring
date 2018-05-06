package sa45.t6.sims.repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import sa45.t6.sims.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer>{
	@Query("select d.password from Customer d where d.name = :eusername")
	String FindUserPwd(@Param("eusername") String eusername);
	
	@Query("select d from Customer d where d.name = :eusername")
	ArrayList<Customer> FindUserExist(@Param("eusername") String eusername);
	
}
