<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ include file = "/pages/includes/bot-login-page.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
<link href="<c:url value="/resources/styles/style.css"/>" rel="stylesheet">
<script src = "<c:url value="/resources/scripts/jquery-1.10.2.min.js"/>"></script>
<script src = "<c:url value="/resources/scripts/jquery-1.9.1.js"/>"></script>
<script src = "<c:url value="/resources/scripts/errorRemove.js"/>"></script>
</head>

<body>
	<img class = "loginimg" src = "<c:url value = "/resources/images/loginimg.jpg" />" />

	<div id = "login-form">
		<!-- <form method = "post" action = "/TodoApp/login" id = "loginFormForAjax"> -->
		<form:form id="loginFormForAjax">
			<div id = "logintitle">Login </div>
			<label for = "username" class = "loginlabel"> Email </label> <br>
			<input type = "text" name = "username" class = "logininput"/> <br><br>
	
			<label for = "password" class = "loginlabel"> Password </label><br> 
			<input type = "password" name = "password" class = "logininput"/><br>
			
			<input type = "submit" value="Login" id = "loginbutton"/>
		</form:form>
		
		<form method = "get" action = "/TodoApp/register">
			<input type = "submit" value = "Sign Up" id = "signupbutton"/>
		</form>
		
	</div>
	
</body>
</html>