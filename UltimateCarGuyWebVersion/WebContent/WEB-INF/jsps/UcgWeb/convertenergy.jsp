<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Energy Conversions</title>
</head>
<body>
	<!--Standard Post form. Input names match vaules inside the value retainer object.\
number and step limited to 0.01 to match Float Java limits.
-->
	<c:if test="${ conversion.type == conversion.hpstatic}">
		<form method="post"
			action="${pageContext.request.contextPath}/convertenergyKW">
			<table class="formtable">
				<tr>
					<td>Horsepower</td>
					<td><input name="HP" type="number" step=0.01 /></td>
				</tr>
				<tr>
					<td>Kilowats</td>
					<td><input name="KW" type="number" step=0.01 /></td>
				</tr>
				<td><input value="Convert" type="submit" /></td>
				</tr>
			</table>
		</form>
	</c:if>



</body>
</html>