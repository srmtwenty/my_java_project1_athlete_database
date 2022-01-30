<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isErrorPage="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@include file="header.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
	<img src='<c:out value="${swimmer.photos}"/>' 
		onerror="javascript:this.src='/img/avatar.png'">
	
	<h1>Edit Swimmer</h1>
		
	<form action="/photo/pic/${swimmer.id}" method="POST"
		enctype="multipart/form-data">
		<label for="image">Photo:</label>
		<input type="file" id="image" name="image" accept="image/png, image/jpeg"/>
		<button type="submit">Upload</button>
	</form>
	
	<form:form action="/swimmers/${swimmer.id}/edit" method="POST" modelAttribute="swimmer">
		<input type="hidden" name="_method" value="PUT">
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

		<input type="submit" value="Update Swimmer">
	</form:form>
	<%@ include file="footer.jsp" %>
</html>