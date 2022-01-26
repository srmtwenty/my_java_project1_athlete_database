<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isErrorPage="true"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<title>Insert title here</title>
	<link rel="stylesheet" type="text/css" href="css/style.css">
	<script type="text/javascript" src="js/app.js"></script>
</head>
<body>
	<header>
	<c:choose>
		<c:when test="${loggedUser==null}">
			<h1>Welcome, guest</h1>
		</c:when>
		<c:otherwise>
			<h1>Welcome, <c:out value="${loggedUser.username}"/></h1>
		</c:otherwise>
	</c:choose>
	<a href="/home">Home</a>
	<a href="/competitions">All Competitions</a>
	<a href="/competitions/albums">All Albums</a>
	<a href="/competitions/composers">All Composers</a>
	<a href="/competitions/musics">All Musics</a>
	<a href="/competitions/parties">All Parties</a>
	<a href="/competitions/swimmers">All Swimmers</a>
	<a href="/logout">Log out</a>
	<form action="/search0">
		<input type="text" name="searchQ">
		<input type="submit" value="Search Swimmer by Nation Name">
	</form>
	<form action="/se">
		<input type="number" name="searchQ1">
		<input type="submit" value="Search Swimmer by Birth Year">
	</form>
	<form action="/se2">
		<input type="text" name="searchQ2">
		<input type="submit" value="Search Swimmer by Name">
	</form>
	
	</header>
	
