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
	
</head>
	<h2>All Albums</h2>
	<table>
		<thead>
			<tr>
				<th>Album</th>
				<th>Host</th>
				<th>Action</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${albums}" var="album">
			<tr>
				<td><a href="/competitions/albums/${album.id}"><c:out value="${album.title}"/></a></td>
				<td><c:out value="${album.host.username}"/></td>
				<td>
					<a href="/competitions/albums/${album.id}/edit">Edit</a>
					<a href="/competitions/albums/${album.id}/delete">Delete</a>
				</td>
			</tr>
			</c:forEach>
		</tbody>
	</table>
	<%@ include file="footer.jsp" %>
</html>