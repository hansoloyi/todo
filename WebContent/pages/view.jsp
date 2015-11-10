<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file = "/pages/includes/loggedinchooser.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="<c:url value="/resources/styles/style.css"/>" rel="stylesheet">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div id = "sidebar"> 
		<div id = "sidebaritems">
			<div id = "loggedInName"> Test Name </div>
			<img class = "loggedInPicture" src = "<c:url value="/resources/images/testimg.jpg"/>" />
			<div id = "todo_link" class = "active"> <a href = "feed.jsp"> Todo Feed  </a></div>
			<div id = "todo_link"> <a href = "yourtodo.jsp"> Your Todo </a></div>
			<div id = "todo_link"> <a href = "randomtodo.jsp"> Random Todo </a></div>
			<div id = "todo_link"> <a href = "account.jsp"> Account </a></div>
		</div>
	</div>
	
	
	
</body>
</html>