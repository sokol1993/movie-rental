<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<html>
<head>
<link
	href="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8/themes/base/jquery-ui.css"
	rel="stylesheet" type="text/css" />
<script type="text/javascript"
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.6.2/jquery.min.js"></script>
<script
	src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8/jquery-ui.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
<script>
	$(document).ready(function() {
		$(".datepicker").datepicker({
			dateFormat : "yy-mm-dd"
		});
	});
</script>
<style>
/* Remove the navbar's default margin-bottom and rounded borders */
.navbar {
	margin-bottom: 0;
	border-radius: 0;
}

/* Set height of the grid so .sidenav can be 100% (adjust as needed) */
.row.content {
	height: 450px
}

/* Set gray background color and 100% height */
.sidenav {
	padding-top: 20px;
	background-color: #f1f1f1;
	height: 100%;
}

/* Set black background color, white text and some padding */
footer {
	background-color: #555;
	color: white;
	padding: 15px;
}

/* On small screens, set height to 'auto' for sidenav and grid */
@media screen and (max-width: 767px) {
	.sidenav {
		height: auto;
		padding: 15px;
	}
	.row.content {
		height: auto;
	}
}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
</head>
<body>
	<c:url value="/j_spring_security_logout" var="logoutUrl" />

	<!-- csrt for log out-->
	<form action="${logoutUrl}" method="post" id="logoutForm">
		<input type="hidden" name="${_csrf.parameterName}"
			value="${_csrf.token}" />
	</form>
	<script>
		function formSubmit() {
			document.getElementById("logoutForm").submit();
		}
	</script>
	<nav class="navbar navbar-inverse">
	<div class="container-fluid">
		<div class="collapse navbar-collapse" id="myNavbar">
			<ul class="nav navbar-nav">
				<li><a href="users.html"><spring:message
							code="label.register" /></a></li>
				<li class="active"><a href="rents.html"><spring:message
							code="label.rentMovie" /></a></li>
			</ul>
				<c:if test="${pageContext.request.userPrincipal.name != null}">
				<ul class="nav navbar-nav navbar-right">
					<li><a>${pageContext.request.userPrincipal.name}</a></li>
				</ul>
				<ul class="nav navbar-nav navbar-right">
					<li><a href="javascript:formSubmit()"><span
							class="glyphicon glyphicon-log-out"></span> <spring:message
								code="label.log-out" /></a></li>
				</ul>
			</c:if>
			<c:if test="${pageContext.request.userPrincipal.name == null}">
				<ul class="nav navbar-nav navbar-right">
					<li><a href="login.html"><span
							class="glyphicon glyphicon-log-in"></span> <spring:message
								code="label.log-in" /></a></li>
				</ul>
			</c:if>
		</div>
	</div>
	</nav>
	<div class="container">
		<h3><spring:message code="label.filmList"/></h3>
		<c:if test="${!empty movieList}">
			<table class="table">
				<tr>
					<th><spring:message code="label.title" /></th>
					<th colspan="2"><spring:message code="label.director" /></th>
					<th><spring:message code="label.genre" /></th>
					<th><spring:message code="label.country" /></th>
					<th><spring:message code="label.year" /></th>
					<th><spring:message code="label.category" /></th>
					<th><spring:message code="label.available" /></th>
				</tr>
				<c:forEach items="${movieList}" var="movie" varStatus="index">
					<tr>
						<td>${movie.title}</td>
						<td colspan="2">${movie.director.firstName}
							${movie.director.lastName}</td>
						<td>${movie.genre.genreName}</td>
						<td>${movie.countryOfProduction.country}</td>
						<td>${movie.producitonYear.year}</td>
						<td>${movie.ageCategory.age}</td>
						<td>${movie.available}</td>
					</tr>
				</c:forEach>
			</table>
		</c:if>
	</div>
	<p></p>
	<p></p>
	<footer class="container-fluid text-center"> <span
		style="float: right"> <a href="?lang=pl">pl</a> | <a
		href="?lang=en">en</a>
	</span>
	<p>@Kamil Sokolowski</p>
	</footer>
</body>
</html>