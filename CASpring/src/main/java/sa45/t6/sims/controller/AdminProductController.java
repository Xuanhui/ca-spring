package sa45.t6.sims.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

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
import sa45.t6.sims.model.Partinfo;
import sa45.t6.sims.model.Product;
import sa45.t6.sims.model.ProductConsumption;
import sa45.t6.sims.model.ProductConsumptionList;
import sa45.t6.sims.services.PartInfoService;
import sa45.t6.sims.services.ProductConsumptionService;
import sa45.t6.sims.services.ProductService;
import sa45.t6.sims.services.ProductConsumptionListService;

@RequestMapping(value = "/product")
@Controller
public class AdminProductController {
	@Autowired
	ProductService pservice;
	@Autowired
	PartInfoService piservice;
	@Autowired
	ProductConsumptionService ptservice;
	@Autowired
	ProductConsumptionListService pcservice;

	// @Autowired
	// PartInfoService piservice;
	//

	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public ModelAndView newProductPage(HttpSession session) {
		Product p = new Product();
		ModelAndView mav = new ModelAndView("product-new", "product", p);
		// mav.addObject("product", pservice.createProduct(p));
		ArrayList<String> productType = (ArrayList<String>) pservice.findAllProductType();
		mav.addObject("productType", productType);
		ArrayList<String> productStatus = (ArrayList<String>) pservice.findAllProductStatus();
		mav.addObject("productStatus", productStatus);
		session.setAttribute("currentpagetitle", "Dashboard");
		session.setAttribute("currentpagename", "Product");
		return mav;
	}

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public ModelAndView createNewProduct(@ModelAttribute @Valid Product product, BindingResult result,
			final RedirectAttributes redirectAttributes, HttpSession session) {
		// validator
		if (result.hasErrors())
			return new ModelAndView("product-new");

		ModelAndView mav = new ModelAndView();
		String message = "New Product " + product.getPartnumber() + " was successfully created.";
		session.setAttribute("currentpagename", "Product");
		pservice.changeProduct(product);
		mav.setViewName("redirect:/product/list");
		session.setAttribute("currentpagename", "Product");
		redirectAttributes.addFlashAttribute("message", message);
		return mav;
	}

	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	public ModelAndView editProductPage(@PathVariable String id, HttpSession session) {
		ModelAndView mav = new ModelAndView("product-edit");
		int iid = Integer.parseInt(id);
		Product product = pservice.findProduct(iid);
		mav.addObject("product", product);
		ArrayList<String> productType = (ArrayList<String>) pservice.findAllProductType();
		mav.addObject("productType", productType);
		ArrayList<String> productStatus = (ArrayList<String>) pservice.findAllProductStatus();
		mav.addObject("productStatus", productStatus);
		session.setAttribute("currentpagetitle", "Dashboard");
		session.setAttribute("currentpagename", "Product");
		return mav;
	}

	@RequestMapping(value = "/edit/{id}", method = RequestMethod.POST)
	public ModelAndView editProductPage(@ModelAttribute @Valid Product product, BindingResult result,
			@PathVariable String id, final RedirectAttributes redirectAttributes, HttpSession session) {

		if (result.hasErrors())
			return new ModelAndView("product-edit");

		ModelAndView mav = new ModelAndView("redirect:/product/list");
		session.setAttribute("currentpagename", "Product");
		pservice.changeProduct(product);
		String message = "Product was successfully updated.";
		redirectAttributes.addFlashAttribute("message", message);

		return mav;
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public ModelAndView deleteDepartment(@PathVariable String id, final RedirectAttributes redirectAttributes,
			HttpSession session) {
		ModelAndView mav = new ModelAndView("redirect:/product/list");

		Product product = pservice.findProduct(Integer.parseInt(id));
		pservice.removeProduct(product);
		String message = "The Product " + product.getPartnumber() + " was successfully deleted.";
		session.setAttribute("currentpagename", "Product");
		redirectAttributes.addFlashAttribute("message", message);
		return mav;
	}

	@RequestMapping(value = "/search", method = RequestMethod.POST)
	public ModelAndView productSearchPage(@ModelAttribute Product product, HttpSession session, BindingResult result,
			final RedirectAttributes redirectAttributes) {

		// if (result.hasErrors())
		// return new ModelAndView("product-search");

		ModelAndView mav = new ModelAndView("product-search", "prod", product);

		String id = product.getName();
		// session.setAttribute("tmess", id);

		try {
			int partid = Integer.parseInt(id);

			ArrayList<Product> searchList = (ArrayList<Product>) pservice.findByPartnumber(partid);
			if (searchList.isEmpty()) {
				mav.addObject("searchList", null);
			} else {
				mav.addObject("searchList", searchList);
			}

		} catch (NumberFormatException e) {

		}

		ArrayList<Product> searchListName = (ArrayList<Product>) pservice.findByPartname(id);
		if (searchListName.isEmpty()) {
			mav.addObject("searchListName", null);
		} else {
			mav.addObject("searchListName", searchListName);
		}

		ArrayList<Product> searchListManufacturer = (ArrayList<Product>) pservice.findByPartmanufacturer(id);
		if (searchListManufacturer.isEmpty()) {
			mav.addObject("searchListManufacturer", null);
		} else {
			mav.addObject("searchListManufacturer", searchListManufacturer);
		}

		ArrayList<Product> searchListStatus = (ArrayList<Product>) pservice.findByPartstatus(id);
		if (searchListStatus.isEmpty()) {
			mav.addObject("searchListStatus", null);
		} else {
			mav.addObject("searchListStatus", searchListStatus);
		}
		mav.addObject("bodyTitle", "ProductView");
		return mav;
	}

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ModelAndView productListPage(HttpSession session) {
		Product product = new Product();

		// product.setName("test");
		ModelAndView mav = new ModelAndView("product-list-manage", "prod", product);
		ArrayList<Product> productList = (ArrayList<Product>) pservice.findAllProduct();
		mav.addObject("productList", productList);
		mav.addObject("bodyTitle", "ProductView");
		session.setAttribute("currentpagetitle", "Dashboard");
		session.setAttribute("currentpagename", "Product");
		return mav;
	}

	@RequestMapping(value = "/transactionlist", method = RequestMethod.GET)
	public ModelAndView studentListPage(HttpSession session) {
		ModelAndView mav = new ModelAndView("transaction-list");
		ArrayList<ProductConsumption> transactionList = (ArrayList<ProductConsumption>) ptservice
				.findAllProductConsumption();
		mav.addObject("transactionList", transactionList);
		session.setAttribute("currentpagetitle", "Dashboard");
		session.setAttribute("currentpagename", "Transaction");
		return mav;
	}

	@RequestMapping(value = "/use/{id}", method = RequestMethod.GET)

	public ModelAndView useProductPage(@PathVariable String id, HttpSession session) {
		ModelAndView mav = new ModelAndView("part-list");
		int iid = Integer.parseInt(id);
		Product product = pservice.findProduct(iid);
		ArrayList<Partinfo> listparts = (ArrayList<Partinfo>) piservice.SearchPartBypnInstock(iid);
		mav.addObject("listparts", listparts);
		Customer c = (Customer) session.getAttribute("currentuser");
		ArrayList<Partinfo> mycart = new ArrayList<Partinfo>();

		/*
		 * ArrayList<Partinfo>
		 * listparts=(ArrayList<Partinfo>)piservice.findAllPartInfo();
		 * mav.addObject("listparts", listparts);
		 */
		return mav;
	}

	@RequestMapping(value = "/order/{id}", method = RequestMethod.GET)

	public ModelAndView addToCartPage(@PathVariable String id, HttpSession session) {
		ModelAndView mav = new ModelAndView("part-list");
		int iid = Integer.parseInt(id);
		Partinfo par = piservice.findpartInfo(iid);
		ArrayList<Partinfo> listparts = (ArrayList<Partinfo>) piservice.SearchPartBypnInstock(par.getPartnumber());
		Customer c = (Customer) session.getAttribute("currentuser");

		if (session.getAttribute("mycart") == null) {
			ArrayList<Partinfo> mycart = new ArrayList<Partinfo>();
			mycart.add(par);
			session.setAttribute("mycart", mycart);

		} else {
			ArrayList<Partinfo> mycart = (ArrayList<Partinfo>) session.getAttribute("mycart");
			mycart.add(par);
			session.setAttribute("mycart", mycart);
		}
		// minus 1 q in product table
		// pservice.UpdatingQuantity(iid);
		Product p = pservice.findProduct(par.getPartnumber());
		int q = p.getQuantity() - 1;
		p.setQuantity(q);

		Partinfo pi = piservice.findpartInfo(iid);
		pi.setStatus("Used");
		piservice.changePartInfo(pi);

		mav.addObject("listparts", listparts);
		return mav;
	}

	@RequestMapping(value = "/cart", method = RequestMethod.GET)
	public ModelAndView viewCartPage(HttpSession session) {
		ModelAndView mav = new ModelAndView("mycart");
		ArrayList<Product> productList = (ArrayList<Product>) session.getAttribute("mycart");
		mav.addObject("listparts", productList);
		mav.addObject("bodyTitle", "ProductView");
		session.setAttribute("currentpagetitle", "Dashboard");
		session.setAttribute("currentpagename", "ViewProduct");
		return mav;
	}

	@RequestMapping(value = "/confirm", method = RequestMethod.GET)
	public ModelAndView confitrmOrdertPage(HttpSession session) {
		ModelAndView mav = new ModelAndView("mycart");
		ArrayList<Product> productList = (ArrayList<Product>) session.getAttribute("mycart");
		mav.addObject("bodyTitle", "ProductView");
		mav.addObject("listparts", productList);
		session.setAttribute("currentpagetitle", "Dashboard");
		session.setAttribute("currentpagename", "ViewProduct");

		// user info
		Customer c = (Customer) session.getAttribute("currentuser");
		ArrayList<Partinfo> plist = (ArrayList<Partinfo>) session.getAttribute("mycart");

		ProductConsumptionList tl = new ProductConsumptionList();
		Calendar cal = Calendar.getInstance();
		Date date = cal.getTime();
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		String formattedDate = dateFormat.format(date);
		tl.setDate(date);
		tl.setUserid(c.getId());
		tl.setCustname("DK");
		int tlid = pcservice.findlastTLid();
		tl.setId(tlid);
		pcservice.insertnew(tl);

		ptservice.CarttoTran(tl.getId(), plist);

		session.setAttribute("mycart", null);
		mav.addObject("listparts", session.getAttribute("mycart"));

		return mav;
	}

	// @RequestMapping(value = "/order/{id}", method = RequestMethod.GET)
	//
	// public ModelAndView addToCartPage(@PathVariable String id,HttpSession
	// session)
	// {
	// ModelAndView mav = new ModelAndView("part-list");
	// int iid = Integer.parseInt(id);
	// Partinfo par = piservice.findpartInfo(iid);
	// ArrayList<Partinfo> listparts =
	// (ArrayList<Partinfo>)piservice.SearchPartBypn(iid);
	// mav.addObject("listparts", listparts);
	// //Customer c = (Customer) session.getAttribute("currentuser");
	// if(session.getAttribute("mycart") == null) {
	// ArrayList<Partinfo> mycart = new ArrayList<Partinfo>();
	// mycart.add(par);
	// session.setAttribute("mycart", mycart);
	//
	// }else {
	// ArrayList<Partinfo> mycart =
	// (ArrayList<Partinfo>)session.getAttribute("mycart");
	// mycart.add(par);
	// session.setAttribute("mycart", mycart);
	// }
	// // minus 1 q in product table
	// //pservice.UpdatingQuantity(iid);
	// Product p = pservice.findProduct(par.getPartnumber());
	// int q = p.getQuantity() -1;
	// p.setQuantity(q);
	//
	// Partinfo pi=piservice.findpartInfo(iid);
	// pi.setStatus("Used");
	// piservice.changePartInfo(pi);
	//
	// pservice.changeProduct(p);
	// return mav;
	// }
	//

}
