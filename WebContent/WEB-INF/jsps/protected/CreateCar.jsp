<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="<c:url value="/resources/css/main.css" />" rel="stylesheet">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Create Car</title>
</head>
<body>
	<c:if test="${UserDisplayName == null}">
		<c:redirect url="/p/dologin" />
	</c:if>

	<%@ include file="/WEB-INF/jsps/UcgWeb/MenuBar.jsp"%>

	<form method="post"
		action="${pageContext.request.contextPath}/p/daoCreateCar">
		<table class="formtable">
			<tr>
				<td>Make</td>
				<td><input name="Make" type="text" /></td>
			</tr>
			<tr>
				<td>Model</td>
				<td><input name="Model" type="text" /></td>
			</tr>
			<tr>
				<td>Year</td>
				<td><input name="Year" type="integer" /></td>
			</tr>
			<tr>
				<td>Odometer</td>
				<td><input name="Odometer" type="integer" /></td>
			</tr>
			<tr>
				<td>Last Oil Change</td>
				<td><input name="LastOilChange" type="integer" /></td>
			</tr>
			<tr>
				<td>Last Tyre Change</td>
				<td><input name="LastTyreChange" type="integer" /></td>
			</tr>
			<tr>
				<td>Last Break Change</td>
				<td><input name="LastBreakChange" type="integer" /></td>
			</tr>
			<tr>
				<td>Other Maitenance Items</td>
				<td><textarea name="OtherMaitenance"></textarea></td>
			</tr>
			<tr>
				<td>Description</td>
				<td><textarea name="Description"></textarea></td>
			</tr>
			<td><input type="hidden" name="UserID" value="${UserID}" /></td>
			<td><input value="Save" type="submit" /></td>
			</tr>
		</table>
	</form>


</body>
</html>