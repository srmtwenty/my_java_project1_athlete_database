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
				<h1 id="h1_align">New Swimmer</h1>
				<form:form action="/tags/new" method="POST" modelAttribute="tagCategory">
					<div class="row2">
						<div class="label2">
							<form:label path="tagName">Tag:</form:label>
						</div>
						<div class="label2">
							<form:errors path="tagName"/>
						</div>
						<div class="label2">
							<form:input path="tagName"/>
						</div>
					</div>
					<div class="row2">
						<input type="submit" value="Create Tag">
					</div>
				</form:form>
			</article>
		</section>
	</div>
</div>
<%@ include file="footer.jsp" %>