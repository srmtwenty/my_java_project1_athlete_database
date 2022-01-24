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

	<table>
		<thead>
			<tr>
				<th>Parties</th>
				<th>Host</th>
				<th>Action</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${parties}" var="party">
			<tr>
				<td><a href="/competitions/parties/${party.id}"><c:out value="${party.partyName}"/></a></td>
				<td><c:out value="${party.host.username}"/></td>
				<td>
					<form action="/competitions/parties/${party.id}" method="POST">
						<input type="hidden" name="_method" value="delete">
						<input type="submit" value="Delete">
					</form>
					<a href="/competitions/parties/${party.id}"></a>
				</td>
			</tr>
			</c:forEach>
		</tbody>
	</table>
	<%@ include file="footer.jsp" %>
</html>