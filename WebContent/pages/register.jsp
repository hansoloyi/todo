<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file= "/pages/includes/bot.jsp" %>
<%@ include file = "/pages/includes/loggedinchooser.jsp" %>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Register</title>
<link href="<c:url value="/resources/styles/style.css"/>" rel="stylesheet">
</head>
<body>
	<form method = "post" action = "/TodoApp/registeredUser" id = "register-form">
		<div id = "register-title">Register</div>

		<div id = "reg-box">
			<label for = "name" id = "reg-label"> Full Name* </label> <br>
			<input type = "text" name = "name" id = "reg-input" /> <br><br>
			
			<label for = "email" id = "reg-label">Email*</label> <br>
			<input type = "text" name = "email" id = "reg-input"/> <br><br>
	
			<label for = "password" id = "reg-label"> Password* </label> <br>
			<input type = "password" name = "password" id = "reg-input"/> <br><br>

			<label for ="confirm_password" id = "reg-label"> Confirm Password* </label> <br>
			<input type = "password" name = "confirm_password" id = "reg-input" /> <br>
		</div>

		<div id = "reg-box">
			<label for = "city" id = "reg-label"> City </label> <br>
			<input type = "text" name = "city" id = "reg-input" /> <br> <br>

			<label for = "state" id = "reg-label"> State </label> <br>
			<input type = "text" name = "state" id = "reg-input" placeholder = "xx ex. CA" /> <br> <br>

			<label for = "number" id = "reg-label"> Phone </label> <br>
			<input type = "text" name = "number" id = "reg-input" placeholder = "(xxx)xxx-xxxx ex. (888)888-8888"/> <br> <br>
			<c:choose>
				<c:when test= "${emailExists != null}">
					<div id = "registererror">${emailExists}</div>
				</c:when>
				<c:otherwise>
					<div id = "registererror">${error}</div>
				</c:otherwise>
			</c:choose>
			
			<input type = "submit" value = "Register" id = "register" />
		</div>
	</form>
	
</body>
</html>