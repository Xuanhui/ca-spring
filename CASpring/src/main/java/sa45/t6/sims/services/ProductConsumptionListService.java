package sa45.t6.sims.services;

import java.util.ArrayList;

import org.springframework.transaction.annotation.Transactional;

import sa45.t6.sims.model.ProductConsumption;
import sa45.t6.sims.model.ProductConsumptionList;

public interface ProductConsumptionListService {

	ArrayList<ProductConsumptionList> findAllproductConsumptionList();

	ProductConsumptionList findProductConsumptionList(int id);

	ProductConsumptionList createProductConsumptionList(ProductConsumptionList productConsumptionList);

	ProductConsumptionList changeProductConsumptionList(ProductConsumptionList productConsumptionList);

	void removeProductConsumptionList(ProductConsumptionList productConsumptionList);

	void insertnew(ProductConsumptionList c);
	
	int findlastTLid();
	
}

