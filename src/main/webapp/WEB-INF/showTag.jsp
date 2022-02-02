<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="header.jsp" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>

<div class="wrapper">
	<%@include file="navigator_left.jsp"%>
		<div id="b_main">	
		<section id="section_main">
			<article class="nav_main">
				<h1>Tag Name: <c:out value="${tag.tagName}"/></h1>
			</article>
		</section>
	</div>
</div>
				
<%@ include file="footer.jsp" %>