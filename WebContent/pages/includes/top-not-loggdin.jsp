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
		<div id = "brand"> tadue </div>
		<form method = "post" action = "/TodoApp/login2" id = "login-register">
			<div id = "l-r-box">
				<label for = "username" id = "l-r-label"> Email </label> <br>
				<input type = "text" name = "username" class = "login-register-input"/>
			</div>
			<div id = "l-r-box">
				<label for = "password" id = "l-r-label"> Password </label> <br>
				<input type = "password" name = "password" class = "login-register-input" />
			</div>
			<input type = "submit" value = "Log In" />
		</form>
	</div>
</body>
</html>