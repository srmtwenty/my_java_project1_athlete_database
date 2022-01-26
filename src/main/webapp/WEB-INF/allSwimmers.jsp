<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isErrorPage="true"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ include file="header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<title>Insert title here</title>
	<link rel="stylesheet" type="text/css" href="css/style.css">
	<script type="text/javascript" src="js/app.js"></script>
</head>

	<h1>Swimmers List</h1>
	<table>
		<thead>
			<tr>
				<th>Swimmer</th>
				<th>Nation</th>
				<th>Host</th>
				<th>Action</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${swimmers}" var="swimmer">
			<tr>
				<th><a href="/competitions/swimmers/${swimmer.id}"><c:out value="${swimmer.name}"/></a></th>
				<th><a href="/competitions/nations/${swimmer.nation.id}"><c:out value="${swimmer.nation.name}"/></a></th>
				<td><c:out value="${swimmer.host.username}"/></td>
				<th>
					<c:choose>
						<c:when test="${loggedUser==swimmer.host}">
					<a href="/competitions/swimmers/${swimmer.id}/edit">Edit</a>
					<form action="/competitions/swimmers/${swimmer.id}/edit" method="POST">
						<input type="hidden" name="_method" value="EDIT">
						<input type="submit" value="EDIT">
					</form>
					<form action="/competitions/swimmers/${swimmer.id}/delete" method="POST">
						<input type="hidden" name="_method" value="DELETE">
						<input type="submit" value="DELETE">
					</form>
						</c:when>
						<c:otherwise>
							None
						</c:otherwise>
					</c:choose>
				</th>
			</tr>
			</c:forEach>
		</tbody>
	</table>
	
<%@ include file="footer.jsp" %>
</html>