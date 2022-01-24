<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="header.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>

	<form:form action="/competitions/musics/new" method="POST" modelAttribute="music">
		<p>
			<form:label path="title">Title:</form:label>
			<form:errors path="title"/>
			<form:input path="title"/>
		</p>
		<p>
			<form:label path="album">Album:</form:label>
			<form:errors path="album"/>
			<form:input path="album"/>
		</p>
		<p>
			<form:label path="composer">Composer:</form:label>
			<form:errors path="composer"/>
			<form:input path="composer"/>
		</p>
		<p>
			<form:label path="performer">Performer:</form:label>
			<form:errors path="performer"/>
			<form:input path="performer"/>
		</p>
		<p>
			<form:label path="description">Description:</form:label>
			<form:errors path="description"/>
			<form:textarea path="description"/>
		</p>
		
		<input type="submit" value="Create Music">
	</form:form>
	<%@ include file="footer.jsp" %>
</html>