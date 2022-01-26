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

	
	<h1>Swimmer: <c:out value="${swimmer.name}"/></h1>
	<h3>Nation: <a href="/competitions/nations/${swimmer.nation.id}"><c:out value="${swimmer.nation.name}"/></a></h3>
	<h3>Birth year: <c:out value="${swimmer.birthYear}"/></h3>
	<h3>Host:<c:out value="${swimmer.host.username}"/></h3>
	<p>Description:<c:out value="${swimmer.description}"/></p>
	<p>Photo:<c:out value="${swimmer.picPath}"/></p>
	<img src='<c:out value="{swimmer.picPath}"/>'/>
	
	<p>Comments:</p>
	<ul>
		<c:forEach items="${comments}" var="comment">	
			<li>Commented By:<c:out value="${comment.host.username}"/> <c:out value="${comment.content}"/> <c:out value="${comment.createdAt}"/></li>
		</c:forEach>
	</ul>
	
	<form action="/competitions/swimmers/${swimmer.id}/addComment" method="POST">
		<p>
			<label>Comment:</label>
			
			<textarea id="content" name="content"></textarea>
		</p>
		<input type="submit" value="Post Comment">
	</form>
	
	<c:choose>
		<c:when test="${loggedUser==swimmer.host}">
			<a href="/competitions/swimmers/${swimmer.id}/edit">Edit Swimmer</a>
			<a href="/competitions/swimmers/${swimmer.id}/delete">Delete</a>
		</c:when>
		<c:otherwise>
			<p>Only a host can edit or delete info</p>
		</c:otherwise>
	</c:choose>
	
	<%@ include file="footer.jsp" %>
</html>