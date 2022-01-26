<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ include file="header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>

	<h1><c:out value="${music.title}"/></h1>
	
	<p>Album:<a href="/competitions/albums/${album.id}"><c:out value="${music.album.title}"/></a></p>
	<p>Composer:<a href="/competitions/composers/${composer.id}"><c:out value="${music.composer.name}"/></a></p>
	<p>Performer:<c:out value="${music.performer}"/></p>
	<p>Description:<c:out value="${music.description}"/></p>
	<p>Host:<c:out value="${music.host.username}"/></p>
	<p>Parties:
	<table>
		<thead>
			<tr>
				<th>Group</th>
			</tr>
		</thead>
			<c:forEach items="${sParties}" var="party">
			<tr>
				<td><c:out value="${party.partyName}"/></td>
			</tr>
			</c:forEach>
		<tbody>
		
		</tbody>
	</table>
	
	<form action="/competitions/musics/${music.id}/addParty" method="POST">
		<select name="party">
			<c:forEach items="${parties}" var="party">
			<option value="${party.getId()}">
				<c:out value="${party.partyName}"/>
			</option>
			</c:forEach>
		</select>
		<input type="submit" value="Add Party">
	</form>
	<form action="/competitions/musics/${music.id}/removeParty" method="POST">
		<select name="party">
			<c:forEach items="${parties}" var="party">
			<option value="${party.getId()}">
				<c:out value="${party.partyName}"/>
			</option>
			</c:forEach>
		</select>
		<input type="submit" value="Remove Party">
	</form>
	
	<ul>
		<c:forEach items="${competitions}" var="comp">
			<li>Commented By:<c:out value="${comp.host.username}"/> <c:out value="${comp.content}"/> <c:out value="${comp.createdAt}"/></li>
		</c:forEach>
	</ul>
	
	<form action="/competitions/musics/${music.id}/addComment" method="POST">
		<p>
			<label>Comment:</label>
			<textarea name="content" id="content"></textarea>
		</p>
		<input type="submit" value="Add comment">
	</form>
	
	<c:choose>
		<c:when test="${loggedUser==music.host}">
			<a href="/competitions/musics/${music.id}/edit">Edit Competition</a>
		</c:when>
		<c:otherwise>
			<p>Only a host can edit party.</p>
		</c:otherwise>
	</c:choose>
	
	<%@ include file="footer.jsp" %>
</html>