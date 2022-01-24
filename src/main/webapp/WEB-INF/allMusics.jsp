<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="header.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>

	<h1>All Musics</h1>
	<table>
		<thead>
			<tr>
				<th>Music title</th>
				<th>Album</th>
				<th>Composer</th>
				<th>Host</th>
				<th>Performed By</th>
				<th>Action</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${musics}" var="music">
			<tr>
				<td><a href="/competitions/musics/${music.id}"><c:out value="${music.title}"/></a></td>
				<td><c:out value="${music.album}"/></td>
				<td><c:out value="${music.composer}"/></td>
				<td><c:out value="${music.host.username}"/></td>
				<td><c:out value="${music.performer}"/></td>
				<td><a href="/competitions/musics/${music.id}/edit">Edit</a>
					<a href="/competitions/musics/${music.id}/delete">Delete</a>
				</td>
			</tr>
			</c:forEach>
		</tbody>
	</table>
	<%@ include file="footer.jsp" %>
</html>