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
	<h2>Edit Composer</h2>
	<form:form action="/competitions/composers/${composer.id}/edit" method="POST" modelAttribute="composer">
		<input type="hidden" name="_method" value="PUT">
		<p>
			<form:label path="name">Composer name:</form:label>
			<form:errors path="name"/>
			<form:input path="name"/>
		</p>
		<input type="submit" value="Edit Composer">
	</form:form>
	<%@ include file="footer.jsp" %>
</html>