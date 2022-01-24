<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@include file="header.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>

	<form:form action="/competitions/musics/${music.id}/edit" method="POST" modelAttribute="music">
		<input type="hidden" name="_method" value="PUT">
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
			<form:input path="description"/>
		</p>
		<input type="submit" value="Update Music">
	</form:form>
	<%@ include file="footer.jsp" %>
</html>