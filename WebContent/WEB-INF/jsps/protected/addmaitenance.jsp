<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="<c:url value="/resources/css/main.css" />" rel="stylesheet">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Car Maitenance Log</title>
</head>
<body>
	<c:if test="${UserDisplayName == null}">
		<c:redirect url="/p/dologin" />
	</c:if>

	<%@ include file="/WEB-INF/jsps/UcgWeb/MenuBar.jsp"%>

	<form method="post"
		action="${pageContext.request.contextPath}/p/doaddmaitenance">
		<table class="formtable">
			<td><input type="hidden" name="carID" value="${CID.getCarId()}" /></td>
			<td><input type="hidden" name="userID" value="${UID.getID()}" /></td>
			<tr>
				<td>Description</td>
				<td><textarea name="Description"></textarea></td>
			</tr>
			<tr>
				<td>Cost</td>
				<td><input name="cost" type="integer" /></td>
			</tr>
			<tr>
				<td>Odo</td>
				<td><input name="odo" type="Integer" /></td>
			</tr>

			<td><input value="Save" type="submit" /></td>
			</tr>
		</table>
	</form>
	<c:out value="${CID.getCarId()}"></c:out>
	<c:out value="${UID.getID()}"></c:out>

</body>
</html>