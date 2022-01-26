<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ include file="header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
	<h2>Composer Title:<c:out value="${composer.name}"/></h2>
	<p>Host: <c:out value="${composer.host.username}"/></p>
	<c:choose>
		<c:when test="${composer.host==loggedUser}">
			<a href="/competitions/composers/${composer.id}/edit">Edit</a>
		</c:when>
		<c:otherwise>
			<p>Only a host can edit composer</p>
		</c:otherwise>
	</c:choose>
	<%@ include file="footer.jsp" %>
</html>