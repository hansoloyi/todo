package net.todo.hibernate.pojos;


import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="TODOLISTS")
public class TodoList implements Comparable<TodoList>{
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long listId;
	
	@Column(name="date", columnDefinition="DATETIME")
	@Temporal(TemporalType.TIMESTAMP) 
	private Date listDate;
	
	@Column
	private String displayDate;
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "list", cascade=CascadeType.ALL)
	private List<Todo> todos;

	public long getListId() {
		return listId;
	}

	public void setListId(long listId) {
		this.listId = listId;
	}

	public List<Todo> getTodos() {
		return todos;
	}

	public void setTodos(List<Todo> todos) {
		this.todos = todos;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Date getListDate() {
		return listDate;
	}

	public void setListDate(Date listDate) {
		this.listDate = listDate;
	}

	public String getDisplayDate() {
		return displayDate;
	}

	public void setDisplayDate(String displayDate) {
		this.displayDate = displayDate;
	}

	public int compareTo(TodoList arg0) {
		return arg0.getListDate().compareTo(this.listDate);
	}	
}
