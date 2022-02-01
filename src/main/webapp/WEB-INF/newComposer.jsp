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
	
				<h1 id="h1_align">New Composer</h1>
				<form:form action="/composers/new" method="POST" modelAttribute="composer">
					<div class="row2">
						<div class="label2">
							<form:label path="name">Composer name:</form:label>
						</div>
						<div class="label2">
							<form:errors path="name"/>
						</div>
						<div class="label2">
							<form:input path="name"/>
						</div>
					<div class="row2">
						<input type="submit" value="Create Composer">
					</div>
					</div>
				</form:form>
			</article>
		</section>
	</div>
</div>
<%@ include file="footer.jsp" %>
