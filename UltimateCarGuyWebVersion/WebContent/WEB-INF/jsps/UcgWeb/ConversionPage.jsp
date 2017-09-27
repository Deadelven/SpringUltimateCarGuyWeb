<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Conversions</title>
</head>
<body>
	<!--Standard Post form. Input names match vaules inside the value retainer object.\
number and step limited to 0.01 to match Float Java limits.
-->
	<!-- Type 1 is KW to HP -->
	<c:out value="${CStoreage}"></c:out>
	<c:if test="${CStorage  == 1}">
		<form method="post"
			action="${pageContext.request.contextPath}/convertenergyKW">
			<table class="formtable">
				<tr>
					<td>Horsepower</td>
					<td><input value=0 name="HP" type="number" step=0.01 /></td>
				</tr>
				<tr>
					<td>Kilowats</td>
					<td><input value=0 name="KW" type="number" step=0.01 /></td>
				</tr>
				<td><input value="Convert" type="submit" /></td>
				</tr>
			</table>
		</form>
	</c:if>

	<!-- Type 2 is Fuel Economy -->
	<c:if test="${CStorage  == 2}">
		<form method="post"
			action="${pageContext.request.contextPath}/calculateeconomy">
			<table class="formtable">
				<tr>
					<td>Distance (Miles or Kilomaters)</td>
					<td><input value=0 name="Distance" type="number" step=0.01 /></td>
				</tr>
				<tr>
					<td>Fuel (Litres or Gallons)</td>
					<td><input value=0 name="Volume" type="number" step=0.01 /></td>
				</tr>
				<td><input value="Convert" type="submit" /></td>
				</tr>
			</table>
		</form>
	</c:if>



</body>
</html>