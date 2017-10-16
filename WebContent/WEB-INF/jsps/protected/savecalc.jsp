<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="<c:url value="/resources/css/main.css" />" rel="stylesheet">
<title>Save Calculation</title>
</head>
<body>
	<c:if test="${UserDisplayName == null}">
		<c:redirect url="/p/dologin" />
	</c:if>

	<%@ include file="/WEB-INF/jsps/UcgWeb/MenuBar.jsp"%>

	<!-- 1 is KW/HP -->
	<c:if test="${CStorage  == 1}">
		<c:out value="${CalcStore.getCalc1()}"></c:out>
		<p />
		<c:out value="${CalcStore.getCalc2()}"></c:out>
		<form method="post"
			action="${pageContext.request.contextPath}/p/daosavecalc">
			<table class="formtable">
				<tr>
					<td><input type="hidden" name="Calc1"
						value="${CalcStore.getCalc1()}" /></td>
					<td><input type="hidden" name="Calc2"
						value="${CalcStore.getCalc2()}" /></td>
					<td><input type="hidden" name="UserId" value="${UserID}" /></td>
					<td>Description</td>
					<td><textarea name="Description">Enter description here...</textarea></td>
				</tr>
				<td><input value="Save" type="submit" /></td>
				</tr>
			</table>
		</form>



	</c:if>
	<!-- 2 is Economy -->
	<c:if test="${CStorage  == 2}">
		<c:out value="${L100}"></c:out>
		<p />
		<c:out value="${MPG}"></c:out>
	</c:if>
	<!-- 3 is Volume -->
	<c:if test="${CStorage  == 3}">
		<c:out value="${CylVolume}"></c:out>
		<p />
		<c:out value="${EngineVolume}"></c:out>
	</c:if>
	<!-- 4 is DragRaceTime -->
	<c:if test="${CStorage  == 4}">
		<c:out value="${DragTime}"></c:out>
		<p />
	</c:if>

	<c:if test="${CStorage  == 5}">
		<c:out value="${Cstorage}"></c:out>
		<c:out value="${PW}"></c:out>
		<p />
	</c:if>

	<c:if test="${CStorage  == 6}">
		<c:out value="${L100}"></c:out>
		<p />
		<c:out value="${MPG}"></c:out>
	</c:if>

	<c:if test="${CStorage  == 7}">
		<c:out value="${L100}"></c:out>
		<p />
		<c:out value="${MPG}"></c:out>
	</c:if>
</body>
</html>