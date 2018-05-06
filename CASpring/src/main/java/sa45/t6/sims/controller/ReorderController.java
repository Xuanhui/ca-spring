package sa45.t6.sims.controller;

import java.util.ArrayList;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.hibernate.validator.constraints.Email;
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
import sa45.t6.sims.repository.PartInfoRepository;
import sa45.t6.sims.services.EmailService;
import sa45.t6.sims.services.PartInfoService;
import sa45.t6.sims.services.ProductService;

@RequestMapping(value = "/reorder")
@Controller


public class ReorderController {
	@Autowired
    ProductService pservice;
	@Autowired
	PartInfoService piservice;
	@Autowired
	EmailService emailservice;
	@RequestMapping(value = "/list", method = RequestMethod.GET)
    public ModelAndView productListPage(HttpSession session) {
        ModelAndView mav = new ModelAndView("Reorder-list");
        ArrayList<Product> productList = (ArrayList<Product>) pservice.findproductreorder();
        mav.addObject("productList", productList);
        mav.addObject("bodyTitle", "ProductView");
        session.setAttribute("currentpagename", "ReorderList");
        return mav;
    }
	@RequestMapping(value = "/order/{id}", method = RequestMethod.GET)
    public ModelAndView reorderFindProduct(@PathVariable String id, final RedirectAttributes redirectAttributes) throws Exception
    {        
		//String message = "You make an order and send e-mail successfully.";
		int iid = Integer.parseInt(id);
        Product product = pservice.findProduct(iid);
       int ordernum = pservice.getordernumber(iid);
        //email send email to vandor 
        
       String ordernu=Integer.toString(ordernum);
       emailservice.sendSimpleMail(id,ordernu);
        
        
        //insert data 
         
         ModelAndView mav = new ModelAndView("reorder-orderview");
      mav.addObject("product",product);
     // mav.addObject("ordernum",ordernum);
      mav.addObject("id",iid);
   
     
	
    //  redirectAttributes.addFlashAttribute("message", message);
      return mav;
       
        

       
       
    }
	/* @RequestMapping(value = "/order/{id}", method = RequestMethod.POST)
	    public ModelAndView reorderFindProduct( @PathVariable String id, BindingResult result,final RedirectAttributes redirectAttributes)
	 {   
		 int iid = Integer.parseInt(id);
		 int ordernum = pservice.getordernumber(iid);
		 PartInfo pa = piservice.findpartInfo(iid);
		 piservice.addStock(pa,ordernum);
	     pservice.UpdateQantity(iid,ordernum);
	        ModelAndView mav = new ModelAndView();
	        return mav;
	    } */

}


