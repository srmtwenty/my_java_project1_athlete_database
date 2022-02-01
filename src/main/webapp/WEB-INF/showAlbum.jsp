<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isErrorPage="true"%>
<%@ include file="header.jsp" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<div class="wrapper">	
	<%@include file="navigator_left.jsp"%>
	<div id="b_main">	
		<section id="section_main">
			<article class="nav_main">
				<h2>Album Title: <c:out value="${album.title}"/></h2>
				<p>Host: <c:out value="${album.host.username}"/></p>
				
				<c:choose>
					<c:when test="${loggedUser==album.host}">
						<a href="/albums/${album.id}/edit">Edit</a>
					</c:when>
					<c:otherwise>
						<p>Only a host can edit Album.</p>
					</c:otherwise>
				</c:choose>
			
			</article>
		</section>
	</div>
</div>
<%@ include file="footer.jsp" %>
