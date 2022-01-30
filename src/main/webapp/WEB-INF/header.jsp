<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isErrorPage="true"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
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
		<c:choose>
			<c:when test="${loggedUser==null}">
				<h3 id="welcome">Welcome, guest</h3>
			</c:when>
			<c:otherwise>
				<h3 id="welcome">Welcome, <c:out value="${loggedUser.username}"/></h3>
			</c:otherwise>
		</c:choose>
		<h4 id="logout"><a href="/logout">Log out</a></h4>
		<h1 id="home_name">Artistic Swimming Data record / 아티스틱 스위밍 기록</h1>
		<nav id="nav_top">
			<a href="/home">Home</a> |
			<a href="/competitions">All Competitions</a> |
			<a href="/albums">All Albums</a> |
			<a href="/composers">All Composers</a> |
			<a href="/musics">All Musics</a> |
			<a href="/parties">All Parties</a> |
			<a href="/swimmers">All Swimmers</a>
		</nav>
		
	</header>
	
