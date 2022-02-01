<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@include file="header.jsp"%>
	<div class="wrapper">
			
		<%@include file="navigator_left.jsp"%>
		<div id="b_main">		
		<section id="section_main">
			<article class="nav_main">
	
				<form:form action="/competitions/${competition.id}/edit" method="POST" modelAttribute="competition">
					<input type="hidden" name="_method" value="PUT">
					<div class="row2">
						<div class="label2">
							<form:label path="name">Name</form:label>
						</div>
						<div class="label2">
							<form:errors path="name"/>
						</div>
						<div class="label2">
							<form:input path="name"/>
						</div>
					</div>
					<div class="row2">
						<div class="label2">
							<form:label path="location">Location</form:label>
						</div>
						<div class="label2">
							<form:errors path="location"/>
						</div>
						<div class="label2">
							<form:input path="location"/>
						</div>
					</div>
					<div class="row2">
						<div class="label2">
							<form:label path="year">Year</form:label>
						</div>
						<div class="label2">
							<form:errors path="year"/>
						</div>
						<div class="label2">
							<form:input type="number" path="year"/>
						</div>
					</div>
					<div class="row2">
						<div class="label2">
							<form:label path="description">Description</form:label>
						</div>
						<div class="label2">
							<form:errors path="description"/>
						</div>
						<div class="label2">
							<form:textarea rows="6" path="description"/>
						</div>
					</div>
					<div class="row2">
						<div class="label2">
							<form:label path="eventType">Event Type</form:label>
						</div>
						<div class="label2">
							<form:errors path="eventType"/>
						</div>
						<div class="label2">
							<form:select name="eventType" path="eventType">
								<form:option value="Olympics">Olympics</form:option>
								<form:option value="Olympics Qualification">Olympics Qualification</form:option>
								<form:option value="World Cup">World Cup</form:option>
								<form:option value="World Championship">World Championship</form:option>
								<form:option value="ETC">ETC</form:option>
							</form:select>
						</div>
					</div>
					<div class="row2">
						<input type="submit" value="Edit competition"> |
						<a href="/competitions/${competition.id}">Cancel</a>
					</div>
				</form:form>
	
			</article>
		</section>
		</div>
	</div>
	<%@ include file="footer.jsp" %>
