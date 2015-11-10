package net.todo.business.pojos;

import org.springframework.beans.factory.annotation.Autowired;

import net.todo.backend.pojos.UserAccess;
import net.todo.hibernate.pojos.User;
import net.todo.springmvc.forms.LoginForm;

public class LoginSecurity {
	
	@Autowired
	private UserAccess userAccess;
	
	/*
	 * Checks if there is a user with that email
	 * if there is a user, check username and password match
	 * return true if can login, false if mismatch
	 */
	public boolean canLogIn(LoginForm form) {
		User user = userAccess.getUserByEmail(form);
		if (user == null) {
			return false;
		} else {
			if (user.getUserEmail().equals(form.getUsername()) && 
					user.getUserPassword().equals(form.getPassword())) {
				return true;
			} else {
				return false;
			}
		}
	}
	
	
	/*
	 * Get User based on loginForm
	 */
	
	public User getUser(LoginForm form) {
		return userAccess.getUserByEmail(form);
	}
}
