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
	<h2>All Composers</h2>
	<table>
		<thead>
			<tr>
				<th>Composer</th>
				<th>Host</th>
				<th>Action</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${composers}" var="composer">
			<tr>
				<td><a href="/competitions/composers/${composer.id}"><c:out value="${composer.name}"/></a></td>
				<td><c:out value="${composer.host.username}"/></td>	
				<td>
					<a href="/competitions/composers/${composer.id}/edit">Edit</a>
					<a href="/competitions/composers/${composer.id}/delete">Delete</a>
				</td>
			</tr>
			</c:forEach>
		</tbody>
	</table>
	<%@ include file="footer.jsp" %>
</html>