<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="C" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<title>Insert title here</title>
	<link rel="stylesheet" type="text/css" href="/css/style.css">
	<script type="text/javascript" src="js/app.js"></script>
</head>
<body>
	<header>
		<h1>Register and Login Page</h1>
	</header>
	
	<div class="wrapper_loginRegis">
		
		<section id="loginRegis">
			<h1>Register</h1>
			<p><form:errors path="register.*"/></p>
			<form:form action="/register" method="POST" modelAttribute="register">
				<div class="row">
					<div class="col-35">
						<form:label path="username">Name:</form:label>	
					</div>
					<div class="col-65">
						<form:input path="username"/>
					</div>
				</div>
				<div class="row">
					<div class="col-35">
						<form:label path="email">Email:</form:label>
					</div>
					<div class="col-65">
						<form:input path="email"/>
					</div>
				</div>
				
				<div class="row">
					<div class="col-35">
						<form:label path="password">Password:</form:label>
					</div>
					<div class="col-65">
						<form:input path="password"/>
					</div>
				</div>
				<div class="row">
					<div class="col-35">
						<form:label path="passwordConfirm">Password Confirmation:</form:label>
					</div>
					<div class="col-65">	
						<form:input path="passwordConfirm"/>
					</div>
				</div>
				<input type="submit" value="Register">
			</form:form> 
		</section>
		<section id="loginRegis">
			<h1>Login</h1>
			<p><form:errors path="login.*"/></p>
			<form:form action="/login" method="POST" modelAttribute="login">
				<div class="row">
					<div class="col-35">
						<form:label path="email">Email:</form:label>
					</div>
					<div class="col-65">
						<form:input path="email"/>
					</div>
				</div>
				<div class="row">
					<div class="col-35">
						<form:label path="password">Password:</form:label>
					</div>
					<div class="col-65">
						<form:input path="password"/>
					</div>
				</div>
				
				<input type="submit" value="Login">
			</form:form> 
		</section>
	</div>
</body>
</html>