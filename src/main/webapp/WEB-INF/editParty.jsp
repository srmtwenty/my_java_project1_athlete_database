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

	<form:form action="/parties/${party.id}/edit" method="POST" modelAttribute="party">
		<input type="hidden" name="_method" value="PUT">
		<div class="row2">
			<div class="label2">
				<form:label path="partyName">Name:</form:label>
			</div>
			<div class="label2">	
				<form:errors path="partyName"/>
			</div>	
			<div class="label2">	
				<form:input path="partyName"/>
			</div>
		</div>
		<div class="row2">
			<div class="label2">
				<form:label path="description">Description:</form:label>
			</div>
			<div class="label2">
				<form:errors path="description"/>
			</div>
			<div class="label2">	
				<form:textarea path="description"/>
			</div>
		</div>
		
		<div class="row2">
			<div class="label2">
				<form:label path="nation">Nation:</form:label>
			</div>	
			<div class="label2">	
				<form:errors path="nation"/>
			</div>
			<div class="label2">
				<form:select name="nation" path="nation">
					<c:forEach items="${nations}" var="nation">
						<form:option value="${nation}">
							<c:out value="${nation.name}"/>
						</form:option>
					</c:forEach>
				</form:select>
			</div>
		</div>
		<div class="row2">
			<div class="label2">
				<form:label path="routine">Routine:</form:label>
			</div>
			<div class="label2">
				<form:errors path="routine"/>
			</div>
			<div class="label2">
				<form:select name="routine" path="routine">
					<c:forEach items="${routines}" var="routine">
						<form:option value="${routine}">
							<c:out value="${routine.routineName}"/>
						</form:option>
					</c:forEach>
				</form:select>
			</div>
		</div>
		<div class="row2">
			<div class="label2">
				<form:label path="competition">Competition:</form:label>
			</div>
			<div class="label2">
				<form:errors path="competition"/>
			</div>
			<div class="label2">
				<form:select name="competition" path="competition">
					<c:forEach items="${competitions}" var="competition">
						<form:option value="${competition}">
							<c:out value="${competition.name}"/>
						</form:option>
					</c:forEach>
				</form:select>
			</div>
		</div>
		<div class="row2">
			<input type="submit" value="Update Party">
		</div>
	</form:form>
	<%@ include file="footer.jsp" %>
</html>