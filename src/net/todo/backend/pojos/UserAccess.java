package net.todo.backend.pojos;

import net.todo.hibernate.pojos.User;
import net.todo.springmvc.forms.LoginForm;
import net.todo.springmvc.forms.RegisterForm;

import java.util.*;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

public class UserAccess {
	
	@Autowired
	SessionFactory mysf;
	
	/*
	 * GET USER
	 */
	
	// Get user by Register Form
	@Transactional(propagation=Propagation.REQUIRED, rollbackFor=Exception.class, isolation=Isolation.READ_COMMITTED)
	public User getUserByEmail(RegisterForm form) {
		User user = null;
		Session session = mysf.openSession();
		Criteria crit = session.createCriteria(User.class);
		crit.add(Restrictions.eq("userEmail", form.getEmail()));
		List list = crit.list();
		for (Iterator iter = list.iterator(); iter.hasNext();) {
			user = (User) iter.next();
		}
		session.flush();
		session.close();
		return user;
	}
	
	//Get user by Login Form
	@Transactional(propagation=Propagation.REQUIRED, rollbackFor=Exception.class, isolation=Isolation.READ_COMMITTED)
	public User getUserByEmail(LoginForm form) {
		User user = null;
		Session session = mysf.openSession();
		Criteria crit = session.createCriteria(User.class);
		crit.add(Restrictions.eq("userEmail", form.getUsername()));
		List list = crit.list();
		for (Iterator iter = list.iterator(); iter.hasNext();) {
			user = (User) iter.next();
		}
		session.flush();
		session.close();
		return user;
	}
	
	//Get user by email
	@Transactional(propagation=Propagation.REQUIRED, rollbackFor=Exception.class, isolation=Isolation.READ_COMMITTED)
	public User getUserByEmail(String email) {
		User user = null;
		Session session = mysf.openSession();
		Criteria crit = session.createCriteria(User.class);
		crit.add(Restrictions.eq("userEmail", email));
		List list = crit.list();
		for (Iterator iter = list.iterator(); iter.hasNext();) {
			user = (User) iter.next();
		}
		session.flush();
		session.close();
		return user;
	}
	
	
	
	/*
	 * INSERT USER
	 */
	
	// Insert User by Register Form
	@Transactional(propagation=Propagation.REQUIRED, rollbackFor=Exception.class, isolation=Isolation.READ_COMMITTED)
	public void insertNewUser(RegisterForm form) {
		Session session = mysf.openSession();
		User user = new User();
		user.setUserFullName(form.getName());
		user.setUserEmail(form.getEmail());
		user.setUserPassword(form.getPassword());
		user.setUserCity(form.getCity());
		user.setUserState(form.getState().toUpperCase());
		user.setUserNumber(form.getNumber());
		user.setUserLookUp(generateLookup(form.getName()));
		session.flush();
		session.save(user);
		session.close();
	}
	
	//generate lookup id
	public String generateLookup(String name) {
		StringBuffer result = new StringBuffer();
		String[] name_split = name.split("\\s+");
		
		for (int i = 0; i < name_split.length; i++) {
			result.append(name_split[i].toLowerCase()).append(".");
		}
		result.append(randomId());
		return result.toString();
	}
	
	//random id generator
	public String randomId() {
		String result = "";
		Random generator = new Random();
		for (int i = 0; i < 9; i++) {
			int k = generator.nextInt(10);
			result = result + Integer.toString(k);
		}
		return result;
	}	
	
	//FOR ADDING FRIENDS
//	@Transactional(propagation=Propagation.REQUIRED, rollbackFor=Exception.class, isolation=Isolation.READ_COMMITTED)
//	public void addFriends(User user1, User user2) {
//		Session session = mysf.openSession();
//		
//		List<User> user1List = user1.getFriends();
//		List<User> user2List = user2.getFriendsOf();
//		
//		user1List.add(user2);
//		user2List.add(user1);
//		
//		user1.setFriends(user1List);
//		user2.setFriendsOf(user2List);
//		session.update(user1);
//		session.update(user2);
//		
//		session.flush();
//		session.close();
//	}
}
