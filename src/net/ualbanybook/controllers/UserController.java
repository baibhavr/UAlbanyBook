package net.ualbanybook.controllers;

import java.sql.SQLException;

import net.ualbanybook.model.UserModel;

import org.apache.jasper.tagplugins.jstl.core.Redirect;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.ContextLoaderListener;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.*;

@Controller
public class UserController extends BaseController{
	private String username, firstname, lastname, email, email_confirmation, password, sex, dob, affiliation,interests, wish_list;
	public UserModel m;
	
	public UserController() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException{
		m = new UserModel("account");
	}
	@RequestMapping("/home")
	public ModelAndView login_authentication(HttpServletRequest req, HttpServletResponse resp) throws SQLException{
		this.username = req.getParameter("username");
		this.password = req.getParameter("pass");
		
		if (m.is_User(username, password))
			return new ModelAndView("home", "message", username);
		else
			return new ModelAndView("relogin", "message", username);
			
	}
	
	@RequestMapping("/register")
//	public ModelAndView registration(HttpServletRequest req, HttpServletResponse resp){
//		username = req.getParameter("username");
//		firstname = req.getParameter("firstname");
//		lastname = req.getParameter("lastname");
//		password = req.getParameter("pass");
//		email = req.getParameter("email");
//		sex = req.getParameter("sex");
//		dob = req.getParameter("dob");
//			
//	}
	
	public void set_session(){
		
	}
	
}
