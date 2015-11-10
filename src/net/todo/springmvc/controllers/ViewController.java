package net.todo.springmvc.controllers;

import net.todo.backend.pojos.UserAccess;
import net.todo.hibernate.pojos.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ViewController {
	
	@Autowired
	private UserAccess userAccess;
	
//	@RequestMapping(value = "/test", method = RequestMethod.POST)
//	public String addFriends() {
//		User user1 = userAccess.getUserByEmail("test2@gmail.com");
//		User user2 = userAccess.getUserByEmail("testing@gmail.com");
//		
////		userAccess.addFriends(user1, user2);
//		
//		return "feed";
//	}
}
