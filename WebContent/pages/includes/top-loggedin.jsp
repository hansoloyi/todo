<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
	<div id = "top-bar-not-logged">
		<div id = "brand"> tadue</div>

		<form method = "POST" action = "/TodoApp/search" id = "searchform">
			<input type = "text" id = "searchbar" placeholder="Search by name...">
			<input type = "submit" id = "search" value = "Search..">
		</form>

		<form method = "POST" action = "/TodoApp/logout">
			<input type = "submit" value = "Logout" id = "logout"/>
		</form>
	</div>
</body>
</html>