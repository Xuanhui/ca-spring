package sa45.t6.sims.services;

import java.util.ArrayList;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import sa45.t6.sims.model.Partinfo;
import sa45.t6.sims.model.ProductConsumption;
@Service
public interface ProductConsumptionService {

	ArrayList<ProductConsumption> findAllProductConsumption();

	ProductConsumption findProductConsumption(int id);

	ProductConsumption createProductConsumption(ProductConsumption productConsumption);

	ProductConsumption changeProductConsumption(ProductConsumption productConsumption);

	void removeProductConsumption(ProductConsumption productConsumption);
	
	void CarttoTran(int iid,ArrayList<Partinfo> plist);

}