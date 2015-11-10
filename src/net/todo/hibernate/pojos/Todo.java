package net.todo.hibernate.pojos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="TODOS")
public class Todo {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long todoId;
	
	@Column
	private String todoDescription;
	
	@ManyToOne
	@JoinColumn(name = "todolist_id")
	private TodoList list;
	

	public long getTodoId() {
		return todoId;
	}

	public void setTodoId(long todoId) {
		this.todoId = todoId;
	}

	public String getDescription() {
		return todoDescription;
	}

	public void setDescription(String description) {
		this.todoDescription = description;
	}

	public TodoList getList() {
		return list;
	}

	public void setList(TodoList list) {
		this.list = list;
	}
}
