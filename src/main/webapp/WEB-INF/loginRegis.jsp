<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="C" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Register</h1>
	<p><form:errors path="register.*"/></p>
	<form:form action="/register" method="POST" modelAttribute="register">
		<p>
			<form:label path="username">Name:</form:label>	
			<form:input path="username"/>
		</p>
		<p>
			<form:label path="email">Email:</form:label>
			<form:input path="email"/>
		</p>
		<p>
			<form:label path="password">Password:</form:label>
			<form:input path="password"/>
		</p>
		<p>
			<form:label path="passwordConfirm">Password Confirmation:</form:label>
			<form:input path="passwordConfirm"/>
		</p>
		<input type="submit" value="Register">
	</form:form> 
	
	<h1>Login</h1>
	<p><form:errors path="login.*"/></p>
	<form:form action="/login" method="POST" modelAttribute="login">
		<p>
			<form:label path="email">Email:</form:label>	
			<form:input path="email"/>
		</p>
		<p>
			<form:label path="password">Password:</form:label>
			<form:input path="password"/>
		</p>
		
		<input type="submit" value="Login">
	</form:form> 
</body>
</html>