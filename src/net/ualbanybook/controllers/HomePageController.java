package net.ualbanybook.controllers;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.ContextLoaderListener;

@Controller
public class HomePageController {
	@RequestMapping("/wall")
	public ModelAndView wall(){
		String array = "Test";
		return new ModelAndView("home_wall", "array",array);
	}

}
