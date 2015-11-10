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
<script src = "<c:url value="/resources/scripts/feed.js"/>"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>tadue</title>
</head>
<body>
	<div id = "feedBody" class = "todoBody">
		<form id = "test" method = "post" action = "/TodoApp/test">
			<input type = "submit" value = "test"/>
		</form>
	</div>
</body>
</html>