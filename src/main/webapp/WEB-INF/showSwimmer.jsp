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

	
	<h1><c:out value="${swimmer.name}"/></h1>
	<p><strong>Nation:</strong><a href="/nations/${swimmer.nation.id}"><c:out value="${swimmer.nation.name}"/></a></p>
	<p><strong>Birth year:</strong><c:out value="${swimmer.birthYear}"/></p>
	<p><strong>Host:</strong><c:out value="${swimmer.host.username}"/></p>
	<p><strong>Description:</strong><c:out value="${swimmer.description}"/></p>
	<p><strong>Number of groups:</strong><c:out value="${partyNumbers}"/></p>
	<p><strong>Photo:</strong><c:out value="${swimmer.picPath}"/></p>
	<img src='<c:out value="{swimmer.picPath}"/>'/>
	
	<p><strong>Groups:</strong>
	<table>
		<thead>
			<tr>
				<th>Groups</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${parties}" var="party">
			<tr>
				<td><a href="/parties/${party.id}"><c:out value="${party.partyName}"/></a></td>
			</tr>
			</c:forEach>
		</tbody>
	</table>
	
	<p>Comments:</p>
	<ul>
		<c:forEach items="${comments}" var="comment">	
			<li>Commented By:<c:out value="${comment.host.username}"/> <c:out value="${comment.content}"/> <c:out value="${comment.createdAt}"/></li>
		</c:forEach>
	</ul>
	
	<form action="/swimmers/${swimmer.id}/addComment" method="POST">
		<div class="row">
			<div class="col-35-textarea">
				<label><strong>Comment:</strong></label>
			</div>
			<div class="col-65_textarea">
				<textarea id="content" name="content"></textarea>
			</div>
		</div>
		<input type="submit" value="Post Comment">
	</form>
	
	<c:choose>
		<c:when test="${loggedUser==swimmer.host}">
			<a href="/swimmers/${swimmer.id}/edit">Edit Swimmer</a>
			<a href="/swimmers/${swimmer.id}/delete">Delete</a>
		</c:when>
		<c:otherwise>
			<p>Only a host can edit or delete info</p>
		</c:otherwise>
	</c:choose>
	
	<%@ include file="footer.jsp" %>
</html>