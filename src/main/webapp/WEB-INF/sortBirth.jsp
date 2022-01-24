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

	<h1>Swimmers in Birth Year order</h1>
	<table>
		<thead>
			<tr>
				<th>Swimmer</th>
				<th>Birth date</th>
				<th></th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${swimmers}" var="swimmer">
			<tr>
				<td><c:out value="${swimmer.name}"/></td>
				<td><c:out value="${swimmer.birthYear}"/></td>
				<td></td>
			</tr>
			</c:forEach>
		</tbody>
	</table>
	<%@ include file="footer.jsp" %>
</html>