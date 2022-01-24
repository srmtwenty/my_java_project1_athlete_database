<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>

	<form:form action="/competitions/routines/new" method="POST" modelAttribute="routine">
		<p>
			<form:label path="routineName">Name:</form:label>
			<form:errors path="routineName"/>
			<form:input path="routineName"/>
		</p>
		<input type="submit" value="Add Routine">
	</form:form>
	<%@ include file="footer.jsp" %>
</html>