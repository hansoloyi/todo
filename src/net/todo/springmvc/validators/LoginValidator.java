package net.todo.springmvc.validators;

import net.todo.business.pojos.LoginSecurity;
import net.todo.springmvc.forms.LoginForm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class LoginValidator implements Validator {
	
	@Autowired
	private LoginSecurity logSecurity;

	public boolean supports(Class<?> arg0) {
		return LoginForm.class.isAssignableFrom(arg0);
	}

	public void validate(Object arg0, Errors arg1) {
		LoginForm loginForm = (LoginForm) arg0;
		
		if (loginForm.getUsername().length() == 0 || loginForm.getUsername() == null) {
			arg1.reject("login.field.empty");
		} 
		
		if (loginForm.getPassword().length() == 0 || loginForm.getPassword() == null) {
			arg1.reject("login.field.empty");
		}
		
		//check if there is a username, password match with a user
		if (!logSecurity.canLogIn(loginForm)) {
			arg1.reject("username.password.mismatch");
		}
	}

}
