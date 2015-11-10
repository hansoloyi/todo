package net.todo.springmvc.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import net.todo.business.pojos.RegisterSecurity;
import net.todo.springmvc.forms.RegisterForm;
import net.todo.springmvc.validators.RegisterValidator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class RegisterController {
	
	@Autowired
	RegisterValidator regValidator;
	
	@Autowired
	RegisterSecurity regSecurity;
	
	/*
	 * Goes to the register page
	 */
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String requestRegister(HttpServletRequest req, HttpServletResponse resp) {
		HttpSession session = req.getSession();
		session.invalidate();
		return "register";
	}
	
	
	
	/*
	 * When a user registers
	 * User Model Attribute and validator for validation
	 */
	@RequestMapping(value="/registeredUser", method = RequestMethod.POST)
	public ModelAndView registerUser(@Valid @ModelAttribute("registerForm") RegisterForm registerForm,
			BindingResult result) {
		regValidator.validate(registerForm, result);
		if (result.hasErrors()) {
			ModelAndView mv = new ModelAndView("register");
			mv.addObject("error", "*Invalid Field(s)");
			if (result.hasFieldErrors("email")) {
				mv.addObject("emailExists", "*Email is in use already");
			}
			return mv;
		} else {
			regSecurity.addUser(registerForm);
			return new ModelAndView("registerSuccess"); 
		}
	}
}
