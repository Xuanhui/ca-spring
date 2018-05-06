package sa45.t6.sims.services;

import java.util.ArrayList;
import java.util.Iterator;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import sa45.t6.sims.model.Partinfo;
import sa45.t6.sims.model.ProductConsumption;
import sa45.t6.sims.repository.ProductConsumptionRepository;

@Service
public class ProductConsumptionServiceImpl implements ProductConsumptionService {

	@Resource
	private ProductConsumptionRepository productConsumptionRepository;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * sa45.t6.sims.service.ProductConsumptionService#findAllProductConsumption()
	 */
	@Override
	public ArrayList<ProductConsumption> findAllProductConsumption() {
		ArrayList<ProductConsumption> l = (ArrayList<ProductConsumption>) productConsumptionRepository.findAll();
		return l;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * sa45.t6.sims.service.ProductConsumptionService#findProductConsumption(int)
	 */
	@Override
	@Transactional
	public ProductConsumption findProductConsumption(int id) {
		return productConsumptionRepository.findOne(id);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * sa45.t6.sims.service.ProductConsumptionService#createProductConsumption(sa45.
	 * t6.sims.model.ProductConsumption)
	 */
	@Override
	@Transactional
	public ProductConsumption createProductConsumption(ProductConsumption productConsumption) {
		return productConsumptionRepository.saveAndFlush(productConsumption);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * sa45.t6.sims.service.ProductConsumptionService#changeProductConsumption(sa45.
	 * t6.sims.model.ProductConsumption)
	 */
	@Override
	@Transactional
	public ProductConsumption changeProductConsumption(ProductConsumption productConsumption) {
		return productConsumptionRepository.saveAndFlush(productConsumption);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * sa45.t6.sims.service.ProductConsumptionService#removeProductConsumption(sa45.
	 * t6.sims.model.ProductConsumption)
	 */
	@Override
	@Transactional
	public void removeProductConsumption(ProductConsumption productConsumption) {
		productConsumptionRepository.delete(productConsumption);
	}

	@Override
	public void CarttoTran(int iid, ArrayList<Partinfo> plist) {

		for (Partinfo num : plist) {
			ProductConsumption pc = new ProductConsumption();
			pc.setPartinfoid(num.getId());
			pc.setProdconsumptionlistid(iid);
			productConsumptionRepository.saveAndFlush(pc);

		}

	}

}