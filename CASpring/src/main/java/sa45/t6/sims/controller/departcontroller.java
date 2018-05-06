package sa45.t6.sims.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;



@RequestMapping(value="/admin/department")
@Controller
public class departcontroller {
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ModelAndView employeeListPage() {
		ModelAndView mav = new ModelAndView("department-list");
		
		return mav;
	}
}
