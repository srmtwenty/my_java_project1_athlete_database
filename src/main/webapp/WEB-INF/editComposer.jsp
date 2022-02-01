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
				<h2>Edit Composer</h2>
				<form:form action="/composers/${composer.id}/edit" method="POST" modelAttribute="composer">
					<input type="hidden" name="_method" value="PUT">
					<div class="row2">
						<form:label path="name">Composer name:</form:label>
						<form:errors path="name"/>
						<form:input path="name"/>
					</div>
					<div class="row2">
						<input type="submit" value="Edit Composer">
					</div>
				</form:form>
			</article>
		</section>
	</div>
</div>	
<%@ include file="footer.jsp" %>