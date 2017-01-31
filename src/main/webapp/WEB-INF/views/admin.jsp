<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">

<!-- jQuery library -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>

<!-- Latest compiled JavaScript -->
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
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
				<li class="active"><a href="admin.html"><spring:message
							code="label.manage" /></a></li>
				<li><a href="movies.html"><spring:message
							code="label.addMovie" /></a></li>
				<li><a href="agecategories.html"><spring:message
							code="label.addAge" /></a></li>
				<li><a href="countries.html"><spring:message
							code="label.addCountry" /></a></li>
				<li><a href="directors.html"><spring:message
							code="label.addDirector" /></a></li>
				<li><a href="genres.html"><spring:message
							code="label.addGenre" /></a></li>
				<li><a href="years.html"><spring:message
							code="label.addYear" /></a></li>
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
		<h3>
			<spring:message code="label.filmList" />
		</h3>
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
	</div>
	<div class="container">
		<h3>
			<spring:message code="label.rents" />
		</h3>
		<table class="table">
			<tr>
				<th><spring:message code="label.title" /></th>
				<th><spring:message code="label.fname" /></th>
				<th><spring:message code="label.lname" /></th>
				<th><spring:message code="label.returnDate" /></th>
				<th>&nbsp;</th>
			</tr>
			<c:forEach items="${filmsList}" var="film">
				<tr>
					<td>${film.filmTitle}</td>
					<td>${film.firstName}</td>
					<td>${film.lastName}</td>
					<td>${film.dateReturn}</td>
					<td><a href="delete/admin/${film.rentId}.html"
						class="btn btn-link"><spring:message code="label.delete" /></a></td>
				</tr>
			</c:forEach>
		</table>
	</div>
	<div class="container">
		<h3>
			<spring:message code="label.userList" />
		</h3>
		<table class="table">
			<tr>
				<th><spring:message code="label.fname" /></th>
				<th><spring:message code="label.lname" /></th>
				<th><spring:message code="label.street" /></th>
				<th><spring:message code="label.numberstreet" /></th>
				<th><spring:message code="label.numberhome" /></th>
				<th><spring:message code="label.city" /></th>
				<th><spring:message code="label.email" /></th>
				<th><spring:message code="label.telephone" /></th>
				<th>&nbsp;</th>
				<th>&nbsp;</th>
			</tr>
			<c:forEach items="${userList}" var="user">
				<tr>
					<td>${user.firstName}</td>
					<td>${user.lastName}</td>
					<td>${user.street}</td>
					<td>${user.streetNumber}</td>
					<td>${user.homeNumber}</td>
					<td>${user.city}</td>
					<td>${user.email}</td>
					<td>${user.telephone}</td>
					<c:if test="${user.login != 'Admin'}">
						<td><a href="delete/users/${user.id}.html"><spring:message
									code="label.delete" /></a></td>
						<td><a href="useredit.html?userId=${user.id}"><spring:message
									code="label.edit" /></a></td>
					</c:if>
					<c:if test="${user.login == 'Admin'}">
						<td></td>
						<td></td>
					</c:if>
				</tr>
			</c:forEach>
		</table>
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