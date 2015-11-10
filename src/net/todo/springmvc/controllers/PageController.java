package net.todo.springmvc.controllers;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.todo.business.pojos.ListSecurity;
import net.todo.json.stuff.JsonWriter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.google.gson.Gson;

@Controller
public class PageController {
	
	@Autowired
	private JsonWriter jsonWriter;
	
	@Autowired
	private ListSecurity listSecurity;
	
	@RequestMapping(value="/feed", method=RequestMethod.GET)
	public String redirectToFeed(HttpServletRequest req) {
		HttpSession session = req.getSession();
		if (session.getAttribute("user") == null) {
			return "redirect:/";
		} else {
			return "feed";
		}
	}
	
	@RequestMapping(value="/notification", method=RequestMethod.GET)
	public String redirectToNotification(HttpServletRequest req) {
		HttpSession session = req.getSession();
		if (session.getAttribute("user") == null) {
			return "redirect:/";
		} else {
			return "notification";
		}
	}
	
	
	@RequestMapping(value="/randomTodo", method=RequestMethod.GET)
	public String redirectToRandomTodo(HttpServletRequest req) {
		HttpSession session = req.getSession();
		if (session.getAttribute("user") == null) {
			return "redirect:/";
		} else {
			return "randomtodo";
		}
	}
	
	@RequestMapping(value="/account", method=RequestMethod.GET)
	public String redirectToAccount(HttpServletRequest req) {
		HttpSession session = req.getSession();
		if (session.getAttribute("user") == null) {
			return "redirect:/";
		} else {
			return "account";
		}
	}

}
