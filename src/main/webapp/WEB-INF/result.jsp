<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="header.jsp" %>


	<h3>Swimmers by nation: <c:out value="${searchN}"/></h3>
	<ul>
		<c:forEach items="${swimmersBN}" var="sBN">
			<li><c:out value="${sBN.name}"/></li>
		</c:forEach>
	</ul>
	<%@ include file="footer.jsp" %>
