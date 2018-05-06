package sa45.t6.sims.services;

import java.util.ArrayList;

import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import sa45.t6.sims.model.Customer;

@Service
public interface CustomerService {

	/* (non-Javadoc)
	 * @see sa45.t6.sims.service.CustomerService#findAllCustomer()
	 */
	ArrayList<Customer> findAllCustomer();

	/* (non-Javadoc)
	 * @see sa45.t6.sims.service.CustomerService#findCustomer(int)
	 */
	Customer findCustomer(int id);

	/* (non-Javadoc)
	 * @see sa45.t6.sims.service.CustomerService#createCustomer(sa45.t6.sims.model.Customer)
	 */
	Customer createCustomer(Customer customer);

	/* (non-Javadoc)
	 * @see sa45.t6.sims.service.CustomerService#changeCustomer(sa45.t6.sims.model.Customer)
	 */
	Customer changeCustomer(Customer customer);

	/* (non-Javadoc)
	 * @see sa45.t6.sims.service.CustomerService#removeCustomer(sa45.t6.sims.model.Customer)
	 */
	void removeCustomer(Customer customer);
	
	boolean FindUserExist(@Param("eusername") String eusername);
	
	public boolean IsChecked(String username,String password);
	
	Customer findCustomerSession(String username);

}