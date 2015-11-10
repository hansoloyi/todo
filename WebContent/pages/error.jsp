<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file = "/pages/includes/bot.jsp" %>
<%@ include file = "/pages/includes/loggedinchooser.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Page Not Found</title>
<link href="<c:url value="/resources/styles/style.css"/>" rel="stylesheet">
</head>
<body>
	<div id = "error-message-box">
		<div id = "error-message">This Page Cannot Be Found.. </div>
		<div id = "error-message">Try a different URL. Sorry!</div>
		<img class = "errorimg" src = "<c:url value = "/resources/images/errorimg.jpg"/>" />
	</div>
</body>
</html>