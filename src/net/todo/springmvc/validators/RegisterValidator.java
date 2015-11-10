package net.todo.springmvc.validators;

import net.todo.business.pojos.RegisterSecurity;
import net.todo.springmvc.forms.RegisterForm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class RegisterValidator implements Validator{
	
	@Autowired
	RegisterSecurity regSecurity;

	public boolean supports(Class<?> arg0) {
		return RegisterForm.class.isAssignableFrom(arg0);
	}

	public void validate(Object arg0, Errors arg1) {
		RegisterForm registerForm = (RegisterForm) arg0;
		
		if (registerForm.getName() == "" || registerForm.getName().length() == 0) {
			arg1.reject("field.invalid");
		}
		if (registerForm.getEmail() == "" || registerForm.getEmail().length() == 0) {
			arg1.reject("field.invalid");
		} 
		if (registerForm.getPassword() == "" || registerForm.getPassword().length() == 0) {
			arg1.reject("field.invalid");
		} 
		if (registerForm.getConfirm_password() == "" || registerForm.getConfirm_password().length() == 0) {
			arg1.reject("field.invalid");
		} 
		if (registerForm.getState().length() > 0 && !registerForm.getState().matches("[a-zA-Z]{2}")) {
			arg1.reject("field.invalid.format");
		} 
		if (registerForm.getNumber().length() > 0 && !registerForm.getNumber().matches("\\([0-9]{3}\\)\\s?[0-9]{3}\\-[0-9]{4}")) {
			arg1.reject("field.invalid.format");
		} 
		
		//checks if password/confirm password match
		if (!registerForm.getConfirm_password().equals(registerForm.getPassword())) {
			arg1.reject("password.mismatch");
		}
		//check if there is already a user with email
		if (regSecurity.isAlreadyRegisteredWithEmail(registerForm)) {
			arg1.rejectValue("email", "email.exists.already");
		}
	}
}
