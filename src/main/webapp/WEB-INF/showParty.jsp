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

	
	<h1>Name:<c:out value="${party.partyName}"/></h1>
	
	<p>Routine:<c:out value="${party.routine.routineName}"/></p>
	<p>Nation:<c:out value="${party.nation.name}"/></p>
	<p>Description:<c:out value="${party.description}"/></p>
	<p>Host:<c:out value="${party.host.username}"/></p>
	<p>Coach:</p>
	<table>
		<thead>
			<tr>
				<th>Coach</th>
				<th>Action</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${coaches}" var="coach">
			<tr>
				<td><a href="/competitions/swimmers/${coach.id}"><c:out value="${coach.name}"/></a></td>
				<td></td>
			</tr>
			</c:forEach>
		</tbody>
	</table>
	<p>Swimmers:</p>
	<table>
		<thead>
			<tr>
				<th>Swimmer</th>
				<th>Action</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${pSwimmers}" var="swimmer">
			<tr>
				<td><c:out value="${swimmer.name}"/></td>
				<td><a href="/competitions/parties/${swimmer.id}/removeSwimmer">Remove</a></td>
			</tr>
			</c:forEach>
		</tbody>
	</table>
	<table>
		<thead>
			<tr>
				<th>Competition</th>
				<th>Action</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td><c:out value="${competition.name}"/></td>
				<td><a href="/competition/${competition.id}/remove">Remove</a></td>
			</tr>
		</tbody>
	</table>
	<p>Music:</p>
	<c:forEach items="${pMusics}" var="pMusic">
	<ul>
		
			<li><a href="/competitions/musics/${pMusic.id}"><c:out value="${pMusic.title}"/></a></li>
		
	</ul>
	</c:forEach>
	
	<p>Add Music</p>
	<form action="/competitions/parties/${party.id}/addMusic" method="POST">
		<select name="music">
			<c:forEach items="${musics}" var="music">
			<option value="${music.id}">
				<c:out value="${music.title}"/>
			</option>
			</c:forEach>
		</select>
		<input type="submit" value="Add Music">
	</form>
	
	
	<p>Add Swimmer</p>
	<form action="/competitions/${party.id}/addSwimmer" method="POST">
		<select name="swimmer">
			<c:forEach items="${swimmers}" var="swimmer">
			<option value="${swimmer.id}">
				<c:out value="${swimmer.name}"/>
			</option>
			</c:forEach>
		</select>
		<input type="submit" value="Add Swimmer">
	</form>
	<c:choose> 
		<c:when test="${loggedUser==null}">
			<p>Login to edit party.</p>
		</c:when>
		<c:otherwise>
			<a href="/competitions/parties/${party.id}/edit">Edit Party</a>
		</c:otherwise>
	</c:choose>
	
	<p>Add Coach</p>
	<form action="/competitions/parties/${party.id}/addCoach" method="POST">
		<select name="coach">
			<c:forEach items="${swimmers}" var="coach">
				<option value="${coach.id}">
					<c:out value="${coach.name}"/>
				</option>
			</c:forEach>
		</select>
		<input type="submit" value="Add Coach">
	</form>
	
	<ul>
		<c:forEach items="${comments}" var="comment">
			<li>Commented By:<c:out value="${comment.host.username}"/> <c:out value="${comment.content}"/> <c:out value="${comment.createdAt}"/></li>
		</c:forEach>
	</ul>
	
	<form action="/competitions/parties/${party.id}/addComment" method="POST">
		<p>
			<label>Party:</label>
			<textarea id="content" name="content"></textarea>
		</p>
		<input type="submit" value="Add Comment">
	</form>
	
	<%@ include file="footer.jsp" %>
</html>