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

	<form:form action="/competitions/parties/${party.id}/edit" method="POST" modelAttribute="party">
		<input type="hidden" name="_method" value="PUT">
		<p>
			<form:label path="partyName">Name:</form:label>
			<form:errors path="partyName"/>
			<form:input path="partyName"/>
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
		<p>
			<form:label path="routine">Routine:</form:label>
			<form:errors path="routine"/>
			<form:select name="routine" path="routine">
				<c:forEach items="${routines}" var="routine">
					<form:option value="${routine}">
						<c:out value="${routine.routineName}"/>
					</form:option>
				</c:forEach>
			</form:select>
		</p>
		<p>
			<form:label path="competition">Competition:</form:label>
			<form:errors path="competition"/>
			<form:select name="competition" path="competition">
				<c:forEach items="${competitions}" var="competition">
					<form:option value="${competition}">
						<c:out value="${competition.name}"/>
					</form:option>
				</c:forEach>
			</form:select>
		</p>
		<input type="submit" value="Update Party">
	</form:form>
	<%@ include file="footer.jsp" %>
</html>