<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
		$("#datepicker").datepicker({
			dateFormat : 'yy-mm-dd',
			minDate : -40000,
			maxDate : -6570
		});
	});
</script>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

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
				<li class="active"><a href="users.html"><spring:message
							code="label.register" /></a></li>
				<li><a href="rents.html"><spring:message
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
		<h2>
			<spring:message code="label.user" />
		</h2>
		<form:form role="form" method="post" action="addUser.html"
			commandName="user">

			<tr>
				<td><form:hidden path="id" />
			</tr>
			<div class="form-group">
				<spring:message code="label.enterLogin" var="enter1" />
				<label for="login"><spring:message code="label.login" /></label>
				<form:input path="login" class="form-control" id="login"
					placeholder="${enter1 }"></form:input>
				<span style='color: red'><form:errors path="login" /></span>
			</div>

			<div class="form-group">
				<spring:message code="label.enterPassword" var="enter2" />
				<label for="password"><spring:message code="label.password" /></label>
				<form:input path="password" class="form-control" id="password"
					placeholder="${enter2 }" />
					<span style='color: red'><form:errors path="password"/></span>
			</div>
			<div class="form-group">
				<spring:message code="label.enterfName" var="enter3" />
				<label for="firstName"><spring:message code="label.fname" /></label>
				<form:input path="firstName" class="form-control" id="firstName"
					placeholder="${enter3 }" />
				<span style='color: red'><form:errors path="firstName" /></span>
			</div>
			<div class="form-group">
				<spring:message code="label.enterlName" var="enter4" />
				<label for="lastName"><spring:message code="label.lname" /></label>
				<form:input path="lastName" class="form-control" id="lastName"
					placeholder="${enter4 }" />
					<span style='color: red'><form:errors path="lastName"/></span>
			</div>
			<div class="form-group">
				<spring:message code="label.enterDate" var="enter5" />
				<label for="dateOfBirth"><spring:message
						code="label.birthdate" /></label>
				<form:input path="dateOfBirth" class="form-control" id="datepicker"
					placeholder="${enter5 }" />
					<span style='color: red'><form:errors path="dateOfBirth"/></span>
			</div>
			<div class="form-group">
				<spring:message code="label.enterStreet" var="enter6" />
				<label for="street"><spring:message code="label.street" /></label>
				<form:input path="street" class="form-control" id="street"
					placeholder="${enter6 }" />
					<span style='color: red'><form:errors path="street"/></span>
			</div>
			<div class="form-group">
				<label for="streetNumber"><spring:message
						code="label.numberstreet" /></label>
				<form:input path="streetNumber" class="form-control"
					id="streetNumber" />
					<span style='color: red'><form:errors path="streetNumber"/></span>
			</div>

			<div class="form-group">
				<label for="homeNumber"><spring:message
						code="label.numberhome" /></label>
				<form:input path="homeNumber" class="form-control" id="homeNumber" />
				<span style='color: red'><form:errors path="homeNumber"/></span>
			</div>
			<div class="form-group">
				<spring:message code="label.enterCity" var="enter7" />
				<label for="city"><spring:message code="label.city" /></label>
				<form:input path="city" class="form-control" id="city"
					placeholder="${enter7 }" />
					<span style='color: red'><form:errors path="city"/></span>
			</div>
			<div class="form-group">
				<spring:message code="label.enterEmail" var="enter9" />
				<label for="email"><spring:message code="label.email" /></label>
				<form:input path="email" class="form-control" id="email"
					placeholder="${enter9 }" />
					<span style='color: red'><form:errors path="email"/></span>
			</div>
			<div class="form-group">
				<spring:message code="label.enterTelephone" var="enter10" />
				<label for="telephone"><spring:message
						code="label.telephone" /></label>
				<form:input path="telephone" class="form-control" id="telephone"
					placeholder="${enter10 }" />
					<span style='color: red'><form:errors path="telephone"/></span>
			</div>
			<div class="checkbox">
				<label><input type="checkbox" name="enabled"> <spring:message
						code="label.enabled" /></label>
			</div>
			<c:if test="${user.id==0}">
				<button type="submit" class="btn btn-default">
					<spring:message code="label.addUser" />
				</button>
			</c:if>
			<c:if test="${user.id!=0}">
				<button type="submit" class="btn btn-default">
					<spring:message code="label.editUser" />
				</button>
			</c:if>
		</form:form>
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
