package sa45.t6.sims.controller;

import java.util.ArrayList;
import java.util.Map;

import javax.annotation.Resource;
import javax.mail.Session;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.annotation.SessionScope;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import sa45.t6.sims.model.Customer;
import sa45.t6.sims.model.Product;
import sa45.t6.sims.repository.CustomerRepository;
import sa45.t6.sims.services.CustomerService;
import sa45.t6.sims.services.ProductService;
import sa45.t6.sims.validation.CustomerValidator;

@RequestMapping(value = "/")
@Controller
public class CustomerController {
	@Autowired
	private CustomerService crepo;

	@Autowired
	private CustomerValidator customerValidator;

	@InitBinder("user")
	private void initDepartmentBinder(WebDataBinder binder) {
		binder.addValidators(customerValidator);
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView logic(HttpSession session) {
		Customer login_user = new Customer();
		ModelAndView mav = new ModelAndView("login", "user", login_user);
		session.setAttribute("currentpagetitle", "Team6 Stockist");
		session.setAttribute("currentpagename", "login");
		session.setAttribute("usertype", login_user);
		return mav;
	}

	@RequestMapping(value = "/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/login";

	}

	@RequestMapping(value = "/auth", method = RequestMethod.POST)
	public ModelAndView authenticate(@ModelAttribute("user") @Valid Customer customer, BindingResult result,
			HttpSession session, final RedirectAttributes redirectAttributes) {
		Customer login_user = new Customer();
		ModelAndView mavValidator = new ModelAndView("login", "user", customer);
		if (result.hasErrors()) {
			return mavValidator;
		}
		String username = customer.getName();
		String password = customer.getPassword();

		ModelAndView mav = new ModelAndView("login", "user", login_user);
		if (crepo.FindUserExist(username) == false) {
			mav.addObject("errorlogin", "Please type correct User Name!");
			return mav;
		} else if (crepo.IsChecked(username, password) == false) {
			mav.addObject("errorlogin", "Please type correct Password!");
			return mav;
		} else {
			Customer cuser = crepo.findCustomerSession(username);
			session.setAttribute("currentuser", cuser);
			mav = new ModelAndView("redirect:/product/list");
			return mav;
		}

	}

	@RequestMapping(value = "/viewprofile", method = RequestMethod.GET)
	public ModelAndView ViewMyProfile(HttpSession session) {
		Customer login_user = new Customer();
		if (session.getAttribute("currentuser") == null) {
			ModelAndView mav = new ModelAndView("redirect:/login");
			return mav;
		} else {
		ModelAndView mav = new ModelAndView("view-profile", "user", login_user);
		Customer c = (Customer) session.getAttribute("currentuser");
		Customer c1 = crepo.findCustomer(c.getId());
		session.setAttribute("currentuser", c1);
		session.setAttribute("currentpagetitle", "My Profile");
		session.setAttribute("currentpagename", "viewprofile");
		return mav;}
	}

	@RequestMapping(value = "/updateprofile", method = RequestMethod.GET)
	public ModelAndView GoUpdateProfile(HttpSession session) {
		Customer login_user = (Customer) session.getAttribute("currentuser");
		ModelAndView mav = new ModelAndView("update-profile", "user", login_user);
		session.setAttribute("currentpagetitle", "My Profile");
		session.setAttribute("currentpagename", "ViewProfile");
		session.setAttribute("currentuser", login_user);
		return mav;
	}

	@RequestMapping(value = "/updateprofile", method = RequestMethod.POST)
	public ModelAndView UpdateProfile(@ModelAttribute("user") @Valid Customer customer, BindingResult result,
			HttpSession session, final RedirectAttributes redirectAttributes) {
		ModelAndView mavValidator = new ModelAndView("update-profile", "user", customer);
		if (result.hasErrors()) {
			return mavValidator;
		}
		if (session.getAttribute("currentuser") == null) {
			ModelAndView mav = new ModelAndView("redirect:/login");
			return mav;
		} else {
			crepo.changeCustomer(customer);
			Customer login_user = crepo.findCustomer(customer.getId());
			session.setAttribute("currentuser", login_user);
			ModelAndView mav = new ModelAndView("view-profile", "user", login_user);

			session.setAttribute("currentpagename", "ViewProfile");
			return mav;
		}

	}

}
