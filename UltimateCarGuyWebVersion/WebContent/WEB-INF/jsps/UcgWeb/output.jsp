<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>output</title>
</head>
<body>
	<c:if test="${CStorage  == 1}">
		<c:out value="${KWString}"></c:out>
		<p />
		<c:out value="${HPString}"></c:out>
	</c:if>

	<c:if test="${CStorage  == 2}">
		<c:out value="${L100}"></c:out>
		<p />
		<c:out value="${MPG}"></c:out>
	</c:if>

	<c:if test="${CStorage  == 3}">
		<c:out value="${L100}"></c:out>
		<p />
		<c:out value="${MPG}"></c:out>
	</c:if>

	<c:if test="${CStorage  == 4}">
		<c:out value="${L100}"></c:out>
		<p />
		<c:out value="${MPG}"></c:out>
	</c:if>

	<c:if test="${CStorage  == 5}">
		<c:out value="${L100}"></c:out>
		<p />
		<c:out value="${MPG}"></c:out>
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



	<p />
	<a href="${pageContext.request.contextPath}/">Home</a>
</body>
</html>
</html>
