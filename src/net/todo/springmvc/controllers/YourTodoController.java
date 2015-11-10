package net.todo.springmvc.controllers;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.todo.business.pojos.ListSecurity;
import net.todo.hibernate.pojos.User;
import net.todo.json.stuff.JsonWriter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class YourTodoController {
	
	@Autowired
	private JsonWriter jsonWriter;
	
	@Autowired
	private ListSecurity listSecurity;
	
	
	// when you go to yourTodo
	@RequestMapping(value="/yourTodo", method=RequestMethod.GET)
	public String redirectToYourTodo(HttpServletRequest req, HttpServletResponse resp) {
		HttpSession session = req.getSession();
		if (session.getAttribute("user") == null) {
			return "redirect:/";
		} else {
			return "yourtodo";
		}
	}
	
	
	//new list is clicked
	@RequestMapping(value = "/newList", method=RequestMethod.POST) 
	public String newList(HttpServletRequest req, HttpServletResponse resp){
		HttpSession session = req.getSession();
		session.setAttribute("newlist", true);
		session.setAttribute("newListTodos", new ArrayList<String>());
		return "redirect:/yourTodo";
	}
	
	
	// add todo from Form
	@RequestMapping(value = "/addTodo", method=RequestMethod.POST)
	public String addTodo(@RequestParam("todoAdd") String todo, HttpServletRequest req, HttpServletResponse resp) {
		HttpSession session = req.getSession();
		ArrayList<String> todos = (ArrayList<String>) session.getAttribute("newListTodos");
		
		if (todo.length() > 0 && todo != null) {
			todos.add(todo);
		}

		return "redirect:/yourTodo";
	}
	
	
	// when you post yourTodo
	@RequestMapping(value="/post", method=RequestMethod.POST)
	public String postList(HttpServletRequest req, HttpServletResponse resp) {
		HttpSession session = req.getSession();
		ArrayList<String> todos = (ArrayList<String>)session.getAttribute("newListTodos");
		User user = (User) session.getAttribute("user");
		listSecurity.createNewList(todos, user.getUserEmail());
		
		session.setAttribute("user", listSecurity.getUser(user.getUserEmail()));
		session.setAttribute("newlist", false);
		
		return "redirect:/yourTodo";
	}
	
	
	@RequestMapping(value="/delete", method=RequestMethod.POST)
	public void delete(HttpServletRequest req, HttpServletResponse resp) {
		System.out.println(req.getParameter("data"));
	}
}
