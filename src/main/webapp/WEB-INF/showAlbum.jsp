<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isErrorPage="true"%>
<%@ include file="header.jsp" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>

	<h2>Album Title: <c:out value="${album.title}"/></h2>
	<p>Host: <c:out value="${album.host.username}"/></p>
	
	<c:choose>
		<c:when test="${loggedUser==album.host}">
			<a href="/albums/${album.id}/edit">Edit</a>
		</c:when>
		<c:otherwise>
			<p>Only a host can edit Album.</p>
		</c:otherwise>
	</c:choose>
	
	<%@ include file="footer.jsp" %>
