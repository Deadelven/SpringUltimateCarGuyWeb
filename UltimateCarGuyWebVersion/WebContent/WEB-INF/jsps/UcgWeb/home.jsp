<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>CSS Website Layout</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">


<link href="<c:url value="/resources/css/main.css" />" rel="stylesheet">
</head>
<body>

	<div class="header">
		<h1>Ultimate Car Guy</h1>
		<p>Awesome Car Image</p>
	</div>

	<div class="topnav">
		<a href="${pageContext.request.contextPath}/">Home</a> <a
			href="${pageContext.request.contextPath}/energyKW">KWHP
			Calculations</a> <a href="${pageContext.request.contextPath}/economy">Energy
			Calculations</a> <a href="#">Volume Calculations</a><a href="#">Economy
			Calculations</a><a href="#">Race Time Calculations</a>
	</div>

	<div class="row">
		<div class="column side">
			<h2>Social Media</h2>
			<p></p>
		</div>
		<div class="column middle">
			<h2>Main Content</h2>
		</div>
		<div class="column side">
			<h2>Updates List</h2>
			<p></p>
		</div>
	</div>

</body>
</html>
