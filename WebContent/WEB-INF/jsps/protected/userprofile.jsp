<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="<c:url value="/resources/css/main.css" />" rel="stylesheet">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome <c:out value="${UserDisplayName}"></c:out></title>
</head>
<body>

	<c:if test="${UserDisplayName == null}">
		<c:redirect url="/p/dologin" />
	</c:if>
	<%@ include file="/WEB-INF/jsps/UcgWeb/MenuBar.jsp"%>



	<div class="column side">
		<table>
			<h2>My Cars</h2>
			<tr>
				<th>Make:</th>
				<th>Mode:</th>
				<th>Year:</th>
				<th>Odometer:</th>
				<th>Description:</th>
				<th>Last Oil Change:</th>
				<th>Last Tyre Change:</th>
				<th>Last Break Change:</th>
				<th>Other Maitenance:</th>
				<th>More Info</th>
			</tr>
			<c:forEach var="Car" items="${SavedCars}">
				<tr>
					<td><c:out value="${ Car.getMake()}"></c:out></td>
					<td><c:out value="${ Car.getModel()}"></c:out></td>
					<td><c:out value="${ Car.getYear()}"></c:out></td>
					<td><c:out value="${ Car.getOdometer()}"></c:out></td>
					<td><c:out value="${ Car.getDescription()}"></c:out></td>
					<td><c:out value="${ Car.getLastOilChange()}"></c:out></td>
					<td><c:out value="${ Car.getLastTyreChange()}"></c:out></td>
					<td><c:out value="${ Car.getLastBreakChange()}"></c:out></td>
					<td><c:out value="${ Car.getOtherMaitenance()}"></c:out></td>
					<td>
						<form method="post"
							action="${pageContext.request.contextPath}/p/doeditcar">
							<table class="formtable">
								<input name="CarId" type="hidden" value="${Car.getdBID()}" />
								<input name="UserId" type="hidden" value="${UserID}" />
								<input value="More" type="submit" />
								</tr>
							</table>
						</form>
					</td>
				</tr>
			</c:forEach>
		</table>
		<a href="${pageContext.request.contextPath}/p/createcar">Add a Car</a>
	</div>
	<div class="column middle">
		<table class="Calculations">
			<h2>Stored Calculations</h2>
			<tr>
				<th>Calc1</th>
				<th>Calc2</th>
				<th>Description</th>
				<th>Delete Value</th>
			</tr>
			<c:forEach var="Calc" items="${SavedCalcs}">
				<tr>
					<td><c:out value="${ Calc.getCalc1()}"></c:out></td>
					<td><c:out value="${ Calc.getCalc2()}"></c:out></td>
					<td><c:out value="${ Calc.getDescription()}"></c:out></td>
					<td>
						<form method="post"
							action="${pageContext.request.contextPath}/p/dodeletecalculation">
							<table class="formtable">
								<input name="DatabaseID" type="hidden"
									value="${Calc.getDatabaseID()}" />
								<input value="Delete" type="submit" />
								</tr>
							</table>
						</form>
					</td>
					<c:out value="${row}"></c:out>
				</tr>
			</c:forEach>
		</table>
	</div>




</body>
</html>