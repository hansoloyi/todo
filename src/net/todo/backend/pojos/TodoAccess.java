package net.todo.backend.pojos;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import net.todo.hibernate.pojos.Todo;
import net.todo.hibernate.pojos.TodoList;
import net.todo.hibernate.pojos.User;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

public class TodoAccess {
	
	@Autowired
	private SessionFactory mysf;
	
	@Transactional(propagation=Propagation.REQUIRED, rollbackFor=Exception.class, isolation=Isolation.READ_COMMITTED)
	public void insertTodo(String desc) {
		Session session = mysf.openSession();
		Todo todo = new Todo();
		todo.setDescription(desc);
		session.save(todo);
		session.close();
	}
	
	@Transactional(propagation=Propagation.REQUIRED, rollbackFor=Exception.class, isolation=Isolation.READ_COMMITTED)
	public ArrayList<Todo> getTodos() {
		Session session = mysf.openSession();
		ArrayList<Todo> result = new ArrayList<Todo>();
		Criteria crit = session.createCriteria(Todo.class);
		result.addAll(crit.list());
		session.close();
		return result;
	}
	
	@Transactional(propagation=Propagation.REQUIRED, rollbackFor=Exception.class, isolation=Isolation.READ_COMMITTED)
	public void insertNewList(ArrayList<String> todos, User user) {
		Session session = mysf.openSession();
		ArrayList<Todo> todoList = new ArrayList<Todo>();
		TodoList list = new TodoList();
		for (int i = 0; i < todos.size(); i++) {
			Todo t = new Todo();
			t.setDescription(todos.get(i));
			t.setList(list);
			todoList.add(t);
		}
		SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy");
		Date date = new Date();
		list.setDisplayDate(format.format(date));
		list.setListDate(date);
		list.setTodos(todoList);
		list.setUser(user);
		session.save(list);
		session.close();
	}
	
//	@Transactional(propagation=Propagation.REQUIRED, rollbackFor=Exception.class, isolation=Isolation.READ_COMMITTED)
//	public 
}
