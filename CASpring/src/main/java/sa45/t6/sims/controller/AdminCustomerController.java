package sa45.t6.sims.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import sa45.t6.sims.model.Customer;

import sa45.t6.sims.services.CustomerService;

@RequestMapping(value = "/admin/customer")
@Controller
public class AdminCustomerController {
	@Autowired
	CustomerService cservice;
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ModelAndView ViewCustomer(HttpSession session) {
		ModelAndView mav = new ModelAndView("customer-list-manage");
		ArrayList<Customer> customerList = (ArrayList<Customer>) cservice.findAllCustomer();
		mav.addObject("customerList", customerList);
		session.setAttribute("currentpagetitle", "Manage Customer");
		session.setAttribute("currentpagename", "ViewAccount");
		return mav;
	}
	
	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public ModelAndView newCustomerPage(HttpSession session) {
		Customer c = new Customer();
		ModelAndView mav = new ModelAndView("customer-new", "customer",c);		
		session.setAttribute("currentpagetitle", "Manage Customer");
		session.setAttribute("currentpagename", "Add New Customer");
		return mav;
	}

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public ModelAndView createNewCustomer(@ModelAttribute @Valid Customer customer, BindingResult result,
			final RedirectAttributes redirectAttributes,HttpSession session) {
		// validator
		if (result.hasErrors())
			return new ModelAndView("customer-new");

		ModelAndView mav = new ModelAndView();
		String message = "New customer " + customer.getId() + " was successfully created.";
		cservice.changeCustomer(customer);
		mav.setViewName("redirect:/admin/customer/list");

		redirectAttributes.addFlashAttribute("message", message);
		return mav;
	}

	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	public ModelAndView editCustomerPage(@PathVariable String id,HttpSession session) {
		ModelAndView mav = new ModelAndView("customer-edit");
		int iid = Integer.parseInt(id);
		Customer customer = cservice.findCustomer(iid);
		mav.addObject("customer", customer);
		session.setAttribute("currentpagetitle", "Manage Customer");
		session.setAttribute("currentpagename", "Edit Customer");
		return mav;
	}
	
	@RequestMapping(value = "/edit/{id}", method = RequestMethod.POST)
	public ModelAndView editCustomerPage(@ModelAttribute @Valid Customer customer, BindingResult result,
			@PathVariable String id, final RedirectAttributes redirectAttributes,HttpSession session) {

		if (result.hasErrors())
			return new ModelAndView("customer-edit");

		ModelAndView mav = new ModelAndView("redirect:/admin/customer/list");		

		cservice.changeCustomer(customer);
		String message = "Custoemr was successfully updated.";
		redirectAttributes.addFlashAttribute("message", message);
		
		return mav;
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public ModelAndView deleteCustomer(@PathVariable int id, final RedirectAttributes redirectAttributes,HttpSession session)
	{		
		ModelAndView mav = new ModelAndView("redirect:/admin/customer/list");
		
		Customer customer = cservice.findCustomer(id);
		cservice.removeCustomer(customer);
		String message = "The Customer " + customer.getId() + " was successfully deleted.";

		redirectAttributes.addFlashAttribute("message", message);
		
		return mav;
	}

}


