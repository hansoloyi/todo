<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
	<div id = "sidebar"> 
		<div id = "sidebaritems">
			<div id = "loggedInName"> ${user.userFullName} </div>
			<img class = "loggedInPicture" src = "<c:url value="/resources/images/testimg.jpg"/>" />
			<div id = "todo_link" class = "sidebarFeed"> <a href = "/TodoApp/feed"> Todo Feed  </a></div>
			<div id = "todo_link" class = "sidebarNotification"> <a href = "/TodoApp/notification"> Notifications</a></div>
			<div id = "todo_link" class = "sidebarYourTodo"> <a href = "/TodoApp/yourTodo"> Your Todo </a></div>
			<div id = "todo_link" class = "sidebarRandomTodo"> <a href = "/TodoApp/randomTodo"> Random Todo </a></div>
			<div id = "todo_link" class = "sidebarAccount"> <a href = "/TodoApp/account"> Account </a></div>
		</div>
	</div>
</body>	
</html>