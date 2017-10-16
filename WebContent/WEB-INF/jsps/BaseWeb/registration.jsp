<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Register</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">


</head>
<body>

	<div class="header">
		<h1>Register</h1>
	</div>
	<%@ include file="/WEB-INF/jsps/UcgWeb/MenuBar.jsp"%>


	<form method="post"
		action="${pageContext.request.contextPath}/c/doadduser">
		<table class="formtable">
			<tr>
				<td>UserName:</td>
				<td><input name="Username" type="text" /></td>
			</tr>
			<tr>
				<td>Password:</td>
				<td><input name="Password" type="text" /></td>
			</tr>
			<tr>
				<td>DisplayName:</td>
				<td><input name="DisplayName" type="text"></td>
			</tr>
			<tr>
				<td></td>
				<td><input value="CreateUser" type="submit" /></td>
			</tr>
		</table>
	</form>

</body>
</html>
