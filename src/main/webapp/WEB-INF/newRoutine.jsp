<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="header.jsp" %>
<div class="wrapper">
			
	<%@include file="navigator_left.jsp"%>
	<div id="b_main">			
		<section id="section_main">
			<article class="nav_main">
				<h1 id="h1_align">New Music</h1>

				<form:form action="/routines/new" method="POST" modelAttribute="routine">
					<div class="row2">
						<div class="label2">
							<form:label path="routineName">Name:</form:label>
						</div>
						<div class="label2">
							<form:errors path="routineName"/>
						</div>
						<div class="label2">
							<form:input path="routineName"/>
						</div>
					</div>
					<div class="row2">
						<input type="submit" value="Add Routine">
					</div>
				</form:form>
			</article>
		</section>
	</div>
</div>				
<%@ include file="footer.jsp" %>
