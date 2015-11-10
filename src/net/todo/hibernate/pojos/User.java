package net.todo.hibernate.pojos;

import java.util.List;
import java.util.SortedSet;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.Sort;
import org.hibernate.annotations.SortType;

@Entity
@Table(name = "TODOUSERS", uniqueConstraints=@UniqueConstraint(columnNames={"userEmail", "userLookUp"}))
public class User {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long userId;
	@Column
	private String userFullName;
	private String userEmail;
	private String userPassword;
	private String userCity;
	private String userState;
	private String userNumber;
	private String userLookUp; //for looking up a user by url
	/*
	 * Need to Add relationships
	 */
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "user", cascade=CascadeType.ALL)
	@Sort(type=SortType.NATURAL)
	private SortedSet<TodoList> todoLists;
	
	@ManyToMany 
	@JoinTable(name = "FRIENDS_TABLE", joinColumns = @JoinColumn(name = "user1"), inverseJoinColumns=@JoinColumn(name="user2"))
	private List<User> friends;
	
	@ManyToMany
	@JoinTable(name = "FRIENDS_TABLE", joinColumns = @JoinColumn(name = "user2"), inverseJoinColumns=@JoinColumn(name="user1"))
	private List<User> friendsOf;

	
	//Getters and Setters
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	public String getUserFullName() {
		return userFullName;
	}
	public void setUserFullName(String userFullName) {
		this.userFullName = userFullName;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	public String getUserCity() {
		return userCity;
	}
	public void setUserCity(String userCity) {
		this.userCity = userCity;
	}
	public String getUserState() {
		return userState;
	}
	public void setUserState(String userState) {
		this.userState = userState;
	}
	public String getUserNumber() {
		return userNumber;
	}
	public void setUserNumber(String userNumber) {
		this.userNumber = userNumber;
	}
	public String getUserLookUp() {
		return userLookUp;
	}
	public void setUserLookUp(String userLookUp) {
		this.userLookUp = userLookUp;
	}
	public SortedSet<TodoList> getTodoLists() {
		return todoLists;
	}
	public void setTodoLists(SortedSet<TodoList> todoLists) {
		this.todoLists = todoLists;
	}
	public List<User> getFriends() {
		return friends;
	}
	public void setFriends(List<User> friends) {
		this.friends = friends;
	}
	public List<User> getFriendsOf() {
		return friendsOf;
	}
	public void setFriendsOf(List<User> friendsOf) {
		this.friendsOf = friendsOf;
	}	
}
