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
	<a href="/competitions">Sort by Name</a>
	<a href="/competitions/yearDesc">Sort by Year Desc</a>
	<a href="/competitions/yearAsc">Sort by Year Asc</a>
	
	<table>
		<thead>
			<tr>
				<th>Competition</th>
				<th>Location</th>
				<th>Year</th>
				<th>Host</th>
				<th>Action</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${competitionsAsc}" var="competition">
			<tr>
				<td><a href="/competitions/${competition.id}"><c:out value="${competition.name}"/></a></td>
				<td><c:out value="${competition.location}"/></td>
				<td><c:out value="${competition.year}"/></td>
				<td><c:out value="${competition.host.username}"/></td>
				<td></td>
			</tr>
			</c:forEach>
		</tbody>
	</table>

	<%@ include file="footer.jsp" %>
</html>