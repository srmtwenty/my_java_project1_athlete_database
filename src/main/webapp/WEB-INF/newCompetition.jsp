<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>

	<form:form action="/competitions/create" method="POST" modelAttribute="competition">
		<p>
			<form:label path="name">Name</form:label>
			<form:errors path="name"/>
			<form:input path="name"/>
		</p>
		<p>
			<form:label path="location">Location</form:label>
			<form:errors path="location"/>
			<form:input path="location"/>
		</p>
		<p>
			<form:label path="year">Year</form:label>
			<form:errors path="year"/>
			<form:input type="number" path="year"/>
		</p>
		<p>
			<form:label path="eventType">Event Type</form:label>
			<form:errors path="eventType"/>
			<form:select name="eventType" path="eventType">
				<form:option value="Olympics">Olympics</form:option>
				<form:option value="Olympics Qualification">Olympics Qualification</form:option>
				<form:option value="World Cup">World Cup</form:option>
				<form:option value="World Championship">World Championship</form:option>
				<form:option value="ETC">ETC</form:option>
			</form:select>
		</p>
		<p>
			<form:label path="description">Description</form:label>
			<form:errors path="description"/>
			<form:textarea path="description"/>
		</p>
		<input type="submit" value="New competition">
	</form:form>
	<%@ include file="footer.jsp" %>
</html>