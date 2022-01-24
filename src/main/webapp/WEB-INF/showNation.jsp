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
	
	<h1>Nation: <c:out value="${nation.name}"/></h1>
	<ul>
		<c:forEach items="${swimmers}" var="swimmer">
		<li><a href="/competitions/swimmers/${swimmer.id}"><c:out value="${swimmer.name}"/></a></li>
		</c:forEach>
	</ul>
	<p>Number of Swimmers:<c:out value="${number}"/></p>
	<%@ include file="footer.jsp" %>
</html>