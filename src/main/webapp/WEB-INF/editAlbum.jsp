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
	<h2>New Album</h2>
	<form:form action="/competitions/albums/${album.id}/edit" method="POST" modelAttribute="album">
		<input type="hidden" name="_method" value="PUT">
		<p>
			<form:label path="title">Title:</form:label>
			<form:errors path="title"/>
			<form:input path="title"/>
		</p>
		<input type="submit" value="Edit Album">
	</form:form>
	<%@ include file="footer.jsp" %>
</html>