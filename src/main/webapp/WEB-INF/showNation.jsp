<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="header.jsp" %>
<div class="wrapper">
			
	<%@include file="navigator_left.jsp"%>
		<div id="b_main">	
		<section id="section_main">
			<article class="nav_main">
				<h1>Nation: <c:out value="${nation.name}"/></h1>
				<p>Number of Swimmers:<c:out value="${number}"/></p>
				<ul>
					<c:forEach items="${swimmers}" var="swimmer">
					<li><a href="/swimmers/${swimmer.id}"><c:out value="${swimmer.name}"/></a></li>
					</c:forEach>
				</ul>
				
			</article>
		</section>
	
	</div>
</div>
<%@ include file="footer.jsp" %>