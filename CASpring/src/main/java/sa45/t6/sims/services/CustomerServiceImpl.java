package sa45.t6.sims.services;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import sa45.t6.sims.model.Customer;
import sa45.t6.sims.repository.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService {
	
	@Resource
	private CustomerRepository customerRepository;
	
	/* (non-Javadoc)
	 * @see sa45.t6.sims.service.CustomerService#findAllCustomer()
	 */
	/* (non-Javadoc)
	 * @see sa45.t6.sims.services.CustomerService#findAllCustomer()
	 */
	@Override
	public ArrayList<Customer> findAllCustomer() {
		ArrayList<Customer> l = (ArrayList<Customer>) customerRepository.findAll();		
		return l;
	}
	
	/* (non-Javadoc)
	 * @see sa45.t6.sims.service.CustomerService#findCustomer(int)
	 */
	/* (non-Javadoc)
	 * @see sa45.t6.sims.services.CustomerService#findCustomer(int)
	 */
	@Override
	@Transactional
	public Customer findCustomer(int id)
	{
		return customerRepository.findOne(id);
	}

	/* (non-Javadoc)
	 * @see sa45.t6.sims.service.CustomerService#createCustomer(sa45.t6.sims.model.Customer)
	 */
	/* (non-Javadoc)
	 * @see sa45.t6.sims.services.CustomerService#createCustomer(sa45.t6.sims.model.Customer)
	 */
	@Override
	@Transactional
	public Customer createCustomer(Customer customer) {
		return customerRepository.saveAndFlush(customer);
	}
	
	/* (non-Javadoc)
	 * @see sa45.t6.sims.service.CustomerService#changeCustomer(sa45.t6.sims.model.Customer)
	 */
	/* (non-Javadoc)
	 * @see sa45.t6.sims.services.CustomerService#changeCustomer(sa45.t6.sims.model.Customer)
	 */
	@Override
	@Transactional
	public Customer changeCustomer(Customer customer)
	{
		return customerRepository.saveAndFlush(customer);
	}
	
	/* (non-Javadoc)
	 * @see sa45.t6.sims.service.CustomerService#removeCustomer(sa45.t6.sims.model.Customer)
	 */
	/* (non-Javadoc)
	 * @see sa45.t6.sims.services.CustomerService#removeCustomer(sa45.t6.sims.model.Customer)
	 */
	@Override
	@Transactional
	public void removeCustomer(Customer customer)
	{
		customerRepository.delete(customer);
	}

	@Override
	@Transactional
	public boolean FindUserExist(String eusername) {
		ArrayList<Customer> clist = customerRepository.FindUserExist(eusername);
		if (clist.isEmpty()) {return false;}
		else { return true;}
	}
	
	public boolean IsChecked(String username,String password) {
		String pwd = customerRepository.FindUserPwd(username);
		if (password.equals(pwd)) {return true;}
		else {return false;}
	}

	@Override
	public Customer findCustomerSession(String username) {
		Customer c = new Customer();
		ArrayList<Customer> clist = customerRepository.FindUserExist(username);
		c = clist.get(0);
		return c;
	}

}


