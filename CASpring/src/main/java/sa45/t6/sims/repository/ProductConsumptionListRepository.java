package sa45.t6.sims.repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import sa45.t6.sims.model.ProductConsumptionList;

public interface ProductConsumptionListRepository extends JpaRepository<ProductConsumptionList, Integer> {
	@Query("SELECT id FROM ProductConsumptionList d")
	ArrayList<Integer> FindLastID();

}
