package net.todo.springmvc.controllers;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import net.todo.business.pojos.LoginSecurity;
import net.todo.json.stuff.JsonWriter;
import net.todo.springmvc.forms.LoginForm;
import net.todo.springmvc.validators.LoginValidator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.google.gson.Gson;

@Controller
public class LoginController {
	
	@Autowired
	private JsonWriter jsonWriter;
	
	@Autowired
	private LoginSecurity logSecurity;
	
	@Autowired
	private LoginValidator logValidator;
	
	/*
	 * Checks if there is a user in session,
	 * If no user, go to login page
	 * If user, go to the feed
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String requestHome(HttpServletRequest req, HttpServletResponse resp) {
		HttpSession session = req.getSession();
		if (session.getAttribute("user") == null) {
			return "login";
		} else {
			return "redirect:/feed";
		}
	}
	
	
	
	/*
	 * Login method.get
	 */
	@RequestMapping(value = "/login", method = RequestMethod.GET) 
	public String requestLogin(HttpServletRequest req) {
		HttpSession session = req.getSession();
		if (session.getAttribute("user") == null) {
			return "login";
		} else {
			return "feed";
		}
	}
	
	
	@RequestMapping(value = "/login2", method = RequestMethod.POST)
	public String login2(@Valid @ModelAttribute("loginForm") LoginForm loginForm, BindingResult result, HttpServletRequest req) {
		HttpSession session = req.getSession();
		logValidator.validate(loginForm, result);
		if (!result.hasErrors()) {
			session.setAttribute("user", logSecurity.getUser(loginForm));
		}
		return "redirect:/login";
	}
	
	
	/*
	 * Login successful - go to feed
	 * Login unsuccessful - go to loginpage
	 */
	@RequestMapping(value = "/login", method = RequestMethod.POST) 
	public void login (@Valid @ModelAttribute("loginForm") LoginForm loginForm, BindingResult result, 
			HttpServletRequest req, HttpServletResponse resp) {
		
		logValidator.validate(loginForm, result);
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		boolean obj = true;
		
		
		if (result.hasErrors()) {
			map.put("isValid", obj);
			obj = false;
		} else {
			HttpSession session = req.getSession();
			session.setAttribute("user", logSecurity.getUser(loginForm));
		}
		
		
		map.put("isValid", obj);
		jsonWriter.write(resp, map);
//		return "redirect:/";
	}	
}
