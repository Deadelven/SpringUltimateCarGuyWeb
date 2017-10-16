<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="<c:url value="/resources/css/main.css" />" rel="stylesheet">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
</head>
<body>
	<div class="header">
		<h1>Ultimate Car Guy</h1>
	</div>
	<%@ include file="/WEB-INF/jsps/UcgWeb/MenuBar.jsp"%>

	<form method="post"
		action="${pageContext.request.contextPath}/j_spring_security_check">
		<table class="formtable">
			<tr>
				<td>Username:</td>
				<td><input name="j_username" type="text" /></td>
			</tr>
			<tr>
				<td>Password</td>
				<td><input name="j_password" type="text" /></td>
			</tr>
			<td><input value="Login" type="submit" /></td>
			</tr>
		</table>
	</form>


</body>
</html>