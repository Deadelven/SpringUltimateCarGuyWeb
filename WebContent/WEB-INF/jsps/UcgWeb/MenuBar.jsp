<link href="<c:url value="/resources/css/main.css" />" rel="stylesheet">
	<div class="topnav">
		<a href="${pageContext.request.contextPath}/">
			Home
		</a> 
		<a href="${pageContext.request.contextPath}/c/energyKW">
			KWHP Calculations
		</a> 
		<a href="${pageContext.request.contextPath}/c/economy">
			Economy Calculations
		</a> 
		<a href="${pageContext.request.contextPath}/c/volume">
			Volume Calculations</a> 
		<a href="${pageContext.request.contextPath}/c/drag">
			Drag Time Calculator
		</a> 
		<a href="${pageContext.request.contextPath}/c/kwton">
			Power To Weight
		</a>

		
		<c:if test="${UserDisplayName != null}">
			<a style="float: right" class="active"
				href="${pageContext.request.contextPath}/p/profile"><c:out value="${UserDisplayName}"></c:out></a>
		</c:if>
		<c:if test="${UserDisplayName != null}">
			<a style="float: right" class="active"
				href="${pageContext.request.contextPath}/p/logout">LogOut</a>
		</c:if>
			<c:if test="${UserDisplayName == null}">
			<a style="float: right" class="active"
				href="${pageContext.request.contextPath}/c/register">Register</a>
		</c:if>
		<c:if test="${UserDisplayName == null}">
			<a style="float: right" class="active"
				href="${pageContext.request.contextPath}/c/login">Login</a>
		</c:if>

	</div>