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

	
	<h1><c:out value="${competition.name}"/></h1>
	<p><c:out value="${competition.location}"/></p>
	<p><c:out value="${competition.year}"/></p>
	<p><c:out value="${competition.description}"/></p>
	<p><c:out value="${competition.host.username}"/></p>
	<p><c:out value="${competition.eventType}"/></p>
	<table>
		<thead>
			<tr>
				<th>Parties</th>
				<th>Routine</th>
				<th>Action</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${compParties}" var="party">
			<tr>
				<td><a href="/competitions/parties/${party.id}"><c:out value="${party.partyName}"/></a></td>
				<td><a href="/competitions/routines/${party.routine.id}"><c:out value="${party.routine.routineName}"/></a></td>			
				<td><a href="/competitions/${party.competition.id}/remove">Remove</a></td>
			</tr>
			</c:forEach>
		</tbody>
	</table>

	
	<%-- <h3>Add Party</h3>
	<form action="/competitions/${competition.id}/addParty" method="POST">
		<p>
			<select name="party">
				<c:forEach items="${parties}" var="party">
					<option value="${party.id}">
						<c:out value="${party.partyName}"/>
					</option>
				</c:forEach>
			</select>
		</p>
		<input type="submit" value="Add Party">
	</form> --%>
	<c:choose> 
		<c:when test="${loggedUser==null}">
			<p>Login to edit party.</p>
		</c:when>
		<c:otherwise>
			<a href="/competitions/${competition.id}/edit">Edit Competition</a>
		</c:otherwise>
	</c:choose>
	
	<ul>
		<c:forEach items="${cComments}" var="cComment">
			<li>Commented By:<c:out value="${cComment.host.username}"/> <c:out value="${cComment.content}"/> <c:out value="${cComment.createdAt}"/></li>
		</c:forEach>
	</ul>
	<form action="/competitions/${competition.id}/addComment" method="POST">
		<p>
			<label>Comment:</label>
			<textarea id="content" name="content"></textarea>
		</p>
		<input type="submit" value="Add Comment">
	</form>
	<%@ include file="footer.jsp" %>
</html>