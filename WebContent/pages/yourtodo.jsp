<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file = "/pages/includes/loggedinchooser.jsp" %>
<%@ include file = "/pages/includes/sidebar.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="<c:url value="/resources/styles/style.css"/>" rel="stylesheet">
<script src = "<c:url value="/resources/scripts/jquery-1.10.2.min.js"/>"></script>
<script src = "<c:url value="/resources/scripts/jquery-1.9.1.js"/>"></script>
<script src = "<c:url value="/resources/scripts/yourtodo.js"/>"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>tadue</title>
</head>
<body>
	<div id = "yourTodoBody" class = "todoBody">
		<div id = "yourTodoTitle"> What do you have todo? </div>
		
		<form id = "yourTodoNewList" method = "post" action = "/TodoApp/newList">
			<input type = "submit" id = "newList" value = "New List/Clear" />
		</form>
		
		<c:if test = "${sessionScope.newlist == true }"> 
			<div id = "todoList">
				<div id = "jsonList"> 
					<table>
						<c:if test="${not empty sessionScope.newListTodos}">
							<c:forEach var = "todo" items = "${sessionScope.newListTodos}">
								<tr>
									<td> ${todo} </td>
									<td> <div class = "delete">x</div></td>
								</tr>
							</c:forEach>
						</c:if>
					</table>
					
				</div>
				<form id = "yourTodoForm" method = "post" action = "/TodoApp/addTodo">
					<input type = "text" name = "todoAdd" id ="todoAddInput" placeholder = "todo..."/>
					<input type = "submit" id = "todoAddSubmit" value = "Add" />
				</form>
				
				<form id = "postTodos" method = "post" action = "/TodoApp/post">
					<input type = "submit" id = "postTodoSubmit" value = "Done" />
				</form>
			</div>
		</c:if>
		
		<c:forEach var = "list" items = "${sessionScope.user.todoLists}">
			<table class = "listTable">
				<tr>
					<th> ${list.displayDate} </th>
				</tr>
				<c:forEach var = "listTodo" items = "${list.todos}">
					<tr>
						<td> ${listTodo.description} </td>
					</tr>
				</c:forEach>

			</table>
		</c:forEach>
	</div>
</body>
</html>