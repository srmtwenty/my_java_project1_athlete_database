<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ include file="header.jsp" %>
<div class="wrapper">	
	<%@include file="navigator_left.jsp"%>
	<div id="b_main">	
		<section id="section_main">
			<article class="nav_main">
				<h3>Composer:<c:out value="${composer.name}"/></h3>
				<p>Host: <c:out value="${composer.host.username}"/></p>
				<c:choose>
					<c:when test="${composer.host==loggedUser}">
						<a href="/composers/${composer.id}/edit">Edit</a>
					</c:when>
					<c:otherwise>
						<p>Only a host can edit composer</p>
					</c:otherwise>
				</c:choose>
			</article>
		</section>
	</div>
</div>
<%@ include file="footer.jsp" %>
