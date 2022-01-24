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
<body>
	<h3>Today's Visit number:<c:out value="${currentCount}"/></h3>

	<h2>Competitions</h2>
	<table>
		<thead>
			<tr>
				<th>Competition</th>
				<th>Location</th>
				<th>Year</th>
				<th>Action</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${competitions}" var="competition">
			<tr>
				<td><a href="/competitions/${competition.id}"><c:out value="${competition.name}"/></a></td>
				<td><c:out value="${competition.location}"/></td>
				<td><c:out value="${competition.year}"/></td>
				<td><a href="/competitions/${competition.id}/edit">Edit</a>
					<form action="/competitions/${competition.id}/delete" method="POST">
						<input type="hidden" name="_method" value="DELETE">
						<input type="submit" value="DELETE">
					</form>
				</td>
			</tr>
			</c:forEach>
		</tbody>
	</table>
	
	
	<article>
	<h2>Nations</h2>
	<table>
		<thead>
			<tr>
				<th>Nations</th>
				
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${nations}" var="nation">
			<tr>
				<td><a href="/competitions/nations/${nation.id}"><c:out value="${nation.name}"/></a></td>
			</tr>
			
			</c:forEach>
		</tbody>
	</table>
	</article>
	
	<article>
		<h2>Routines</h2>
		<ul>
			<c:forEach items="${routines}" var="routine">
			<li><c:out value="${routine.routineName}"/></li>
			</c:forEach>
		</ul>
	</article>
	<%@ include file="footer.jsp" %>
