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
			<h2>My Car</h2>
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
				<th>Remove:</th>

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
					<td><form method="post"
							action="${pageContext.request.contextPath}/p/doDeleteCar">
							<table class="formtable">
								<input name="CarId" type="hidden" value="${Car.getdBID()}" />
								<input value="Delete" type="submit" />
								</tr>
							</table>
						</form></td>
				</tr>
			</c:forEach>
		</table>
		<h2>Update</h2>
		<c:forEach var="Car" items="${SavedCars}">
			<form method="post"
				action="${pageContext.request.contextPath}/p/daoEditCar">
				<table class="formtable">
					<tr>
						<td>Odometer</td>
						<td><input value="${ Car.getOdometer()}" name="Odometer"
							type="integer" /></td>
					</tr>
					<tr>
						<td>Last Oil Change</td>
						<td><input value="${ Car.getLastOilChange()}"
							name="LastOilChange" type="integer" /></td>
					</tr>
					<tr>
						<td>Last Tyre Change</td>
						<td><input value="${ Car.getLastTyreChange()}"
							name="LastTyreChange" type="integer" /></td>
					</tr>
					<tr>
						<td>Last Break Change</td>
						<td><input value="${ Car.getLastBreakChange()}"
							name="LastBreakChange" type="integer" /></td>
					</tr>
					<tr>
						<td>Other Maitenance Items</td>
						<td><textarea name="OtherMaitenance"><c:out
									value="${ Car.getOtherMaitenance()}"></c:out></textarea></td>
					</tr>
					<tr>
						<td>Description</td>
						<td><textarea name="Description"><c:out
									value="${ Car.getDescription()}"></c:out></textarea></td>
					</tr>
					<td><input type="hidden" name="CarId" value="${Car.getdBID()}" /></td>
					<td><input value="Save" type="submit" /></td>
					</tr>
				</table>
			</form>

		</c:forEach>
	</div>

	<div class="column middle">
		<table>
			<h2>Maitenance Log</h2>
			<tr>
				<th>Description:</th>
				<th>Cost:</th>
				<th>Odometer:</th>
				<th>Remove:</th>
			</tr>
			<c:forEach var="Car" items="${CarMai}">
				<tr>
					<td><c:out value="${ Car.getDescription()}"></c:out></td>
					<td><c:out value="${ Car.getCost()}"></c:out></td>
					<td><c:out value="${ Car.getOdo()}"></c:out></td>
					<td><form method="post"
							action="${pageContext.request.contextPath}/p/doDeleteMaitenance">
							<table class="formtable">
								<input name="dbID" type="hidden" value="${Car.getDbID()}" />
								<input value="Delete" type="submit" />
								</tr>
							</table>
						</form></td>

				</tr>
			</c:forEach>
		</table>
	</div>


	<form method="post"
		action="${pageContext.request.contextPath}/p/addmaitenance">
		<table class="formtable">
			<td><input type="hidden" name="UserId" value="${UserID}" /></td>
			<td><input type="hidden" name="CarId" value="${CarId}" /></td>
			<td><input value="Add Maitenance" type="submit" /></td>
			</tr>
		</table>
	</form>



</body>
</html>