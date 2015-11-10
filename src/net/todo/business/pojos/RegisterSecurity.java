package net.todo.business.pojos;

import net.todo.backend.pojos.UserAccess;
import net.todo.hibernate.pojos.User;
import net.todo.springmvc.forms.RegisterForm;

import org.springframework.beans.factory.annotation.Autowired;

public class RegisterSecurity {
	
	@Autowired
	private UserAccess userAccess;
	
	/*
	 * Checks if user is registered with email
	 * if there is no user in DB(null), then returns false - which means it is allowed
	 * else there is already user - not allowed
	 */
	public boolean isAlreadyRegisteredWithEmail(RegisterForm form) {
		User user = userAccess.getUserByEmail(form);
		if (user == null) {
			return false;
		} else {
			return true;
		}
	}
	
	
	/*
	 * Insert a new User based on RegisterForm
	 */
	public void addUser(RegisterForm form) {
		userAccess.insertNewUser(form);
	}
}
