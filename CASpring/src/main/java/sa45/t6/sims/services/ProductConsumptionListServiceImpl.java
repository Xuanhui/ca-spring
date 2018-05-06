package sa45.t6.sims.services;


import java.util.ArrayList;
import java.util.Collections;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import sa45.t6.sims.model.ProductConsumption;
import sa45.t6.sims.model.ProductConsumptionList;
import sa45.t6.sims.repository.ProductConsumptionListRepository;

@Service
public class ProductConsumptionListServiceImpl implements ProductConsumptionListService{

	@Resource
	private ProductConsumptionListRepository productConsumptionListRepository;
	
	/* (non-Javadoc)
	 * @see sa45.t6.sims.service.ProductConsumptionListService#findAllproductConsumptionList()
	 */
	public ArrayList<ProductConsumptionList> findAllproductConsumptionList() {
		ArrayList<ProductConsumptionList> l = (ArrayList<ProductConsumptionList>) productConsumptionListRepository.findAll();		
		
		return l;
	}
	
	/* (non-Javadoc)
	 * @see sa45.t6.sims.service.ProductConsumptionListService#findProductConsumptionList(int)
	 */
	@Transactional
	public ProductConsumptionList findProductConsumptionList(int id)
	{
		return productConsumptionListRepository.findOne(id);
	}

	/* (non-Javadoc)
	 * @see sa45.t6.sims.service.ProductConsumptionListService#createProductConsumptionList(sa45.t6.sims.model.ProductConsumptionList)
	 */
	@Transactional
	public ProductConsumptionList createProductConsumptionList(ProductConsumptionList productConsumptionList) {
		return productConsumptionListRepository.saveAndFlush(productConsumptionList);
	}
	
	/* (non-Javadoc)
	 * @see sa45.t6.sims.service.ProductConsumptionListService#changeProductConsumptionList(sa45.t6.sims.model.ProductConsumptionList)
	 */
	@Transactional
	public ProductConsumptionList changeProductConsumptionList(ProductConsumptionList productConsumptionList)
	{
		return productConsumptionListRepository.saveAndFlush(productConsumptionList);
	}
	
	/* (non-Javadoc)
	 * @see sa45.t6.sims.service.ProductConsumptionListService#removeProductConsumptionList(sa45.t6.sims.model.ProductConsumptionList)
	 */
	@Transactional
	public void removeProductConsumptionList(ProductConsumptionList productConsumptionList)
	{
		productConsumptionListRepository.delete(productConsumptionList);
	}

	@Override
	public void insertnew(ProductConsumptionList c) {
		productConsumptionListRepository.saveAndFlush(c);
		
	}
	
	@Override
	public int findlastTLid() {
		ArrayList<Integer> pid = productConsumptionListRepository.FindLastID();
		int iid = Collections.max(pid);
		return iid;
	}
	
	

}









