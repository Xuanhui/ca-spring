package sa45.t6.sims.services;

import static org.mockito.Matchers.intThat;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import sa45.t6.sims.model.Product;
import sa45.t6.sims.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {

	
	 @Resource
	    private ProductRepository productRepository;
	 
	public ArrayList<Product> findByPartnumber(int partNumber) {		
		ArrayList<Product> l = (ArrayList<Product>) productRepository.findByPartnumber(partNumber);		
		return l;
	}
	
	public ArrayList<Product> findByPartname(String name) {		
		ArrayList<Product> l = (ArrayList<Product>) productRepository.findByPartname(name);		
		return l;
	}
	
	public ArrayList<Product> findByPartmanufacturer(String manufacturer) {		
		ArrayList<Product> l = (ArrayList<Product>) productRepository.findByPartmanufacturer(manufacturer);		
		return l;
	}
	
	public ArrayList<Product> findByPartstatus(String status) {		
		ArrayList<Product> l = (ArrayList<Product>) productRepository.findByPartstatus(status);		
		return l;
	}

   
    
    public ArrayList<String> findAllProductType() {        
        ArrayList<String> l = (ArrayList<String>) productRepository.findAllProductType();        
        return l;
    }
    
    public ArrayList<String> findAllProductStatus()
    {
        ArrayList<String> l = (ArrayList<String>) productRepository.findAllProductStatus();
        return l;
    }
    
    /* (non-Javadoc)
     * @see sa45.t6.sims.service.ProductService#findAllProduct()
     */
    @Override
    public ArrayList<Product> findAllProduct() {
        ArrayList<Product> l = (ArrayList<Product>) productRepository.findAll();        
        return l;
    }
    

    /* (non-Javadoc)
     * @see sa45.t6.sims.service.ProductService#findProduct(int)
     */
    @Override
    @Transactional
    public Product findProduct(int id)
    {
        return productRepository.findOne(id);
    }


    /* (non-Javadoc)
     * @see sa45.t6.sims.service.ProductService#createProduct(sa45.t6.sims.model.Product)
     */
    @Override
    @Transactional
    public Product createProduct(Product product) {
        return productRepository.saveAndFlush(product);
    }
    

    /* (non-Javadoc)
     * @see sa45.t6.sims.service.ProductService#changeProduct(sa45.t6.sims.model.Product)
     */
    @Override
    @Transactional
    public Product changeProduct(Product product)
    {
        return productRepository.saveAndFlush(product);
    }
    
    /* (non-Javadoc)
     * @see sa45.t6.sims.service.ProductService#removeProduct(sa45.t6.sims.model.Product)
     */
    @Override
    @Transactional
    public void removeProduct(Product product)
    {
        productRepository.delete(product);
    }

	@Override
	public ArrayList<Product> findproductreorder() {
		ArrayList<Product> reorderlist = productRepository.FindReorderProduct();
		return reorderlist;
	}

	@Override
    public int getordernumber(int n) {
    int crrentq = productRepository.GetCurrentQ(n);
	int minorderq=productRepository.getMinOder(n);
	int reorderq=productRepository.getReorderQ(n);
	int ordernumber = minorderq;
	
	while (crrentq+ordernumber<reorderq) { ordernumber += minorderq;} 		
		return ordernumber;
	}
//
//	@Override
//	  @Transactional
//	public void UpdateQantity(int partnumber,int addnum) {
//		Product product = productRepository.findOne(partnumber);
//		product.setQuantity(product.getQuantity()+addnum);
//		productRepository.saveAndFlush(product);
		
	//}

	
	


}


