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

	<h1>New Swimmer</h1>
	<form:form action="/competitions/swimmers/new" method="POST" modelAttribute="swimmer">
		<p>
			<form:label path="name">Name:</form:label>
			<form:errors path="name"/>
			<form:input path="name"/>
		</p>
		<p>
			<form:label path="birthYear">Birth Year:</form:label>
			<form:errors path="birthYear"/>
			<form:input type="number" path="birthYear"/>
		</p>
		<p>
			<form:label path="description">Description:</form:label>
			<form:errors path="description"/>
			<form:textarea path="description"/>
		</p>
		
		<p>
			<form:label path="nation">Nation:</form:label>
			<form:errors path="nation"/>
			<form:select name="nation" path="nation">
				<c:forEach items="${nations}" var="nation">
				<form:option value="${nation}">
					<c:out value="${nation.name}"/>
				</form:option>
				</c:forEach>
			</form:select>
		</p>
		
		<input type="submit" value="New Swimmer">
	</form:form>
	<%@ include file="footer.jsp" %>
</html>