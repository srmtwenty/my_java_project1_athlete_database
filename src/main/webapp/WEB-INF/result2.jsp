<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="header.jsp" %>


	<h3>Search Swimmer By Name Result: <c:out value="${searchA2}"/></h3>
	<ul>
		<c:forEach items="${swimmersBL}" var="swimmerBL">
			<li><c:out value="${swimmerBL.name}"/></li>
		</c:forEach>
	</ul>
	<%@ include file="footer.jsp" %>
