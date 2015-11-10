package net.todo.business.pojos;

import java.util.ArrayList;

import net.todo.backend.pojos.TodoAccess;
import net.todo.backend.pojos.UserAccess;
import net.todo.hibernate.pojos.User;

import org.springframework.beans.factory.annotation.Autowired;

public class ListSecurity {
	
	@Autowired
	private TodoAccess todoAccess;
	
	@Autowired
	private UserAccess userAccess;
	
	public void createNewList(ArrayList<String> todos, String email) {
		if (todos.size() > 0) {
			User user = userAccess.getUserByEmail(email);
			todoAccess.insertNewList(todos, user);
		}
	}
	
	public User getUser(String email) {
		return userAccess.getUserByEmail(email);
	}
	
	
	
}
