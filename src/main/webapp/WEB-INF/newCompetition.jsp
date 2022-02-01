<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="header.jsp" %>
<div class="wrapper">
			
	<%@include file="navigator_left.jsp"%>
	<div id="b_main">		
		<section id="section_main">
			<article class="nav_main">
				<h1 id="h1_align">New Competition</h1>

				<form:form action="/competitions/create" method="POST" modelAttribute="competition">
					<div class="row2">
						<div class="label2">
							<form:label path="name">Name</form:label>
						</div>
						<div class="label2">
							<form:errors path="name"/>
						<div class="label2">
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
						<div class="label2">
						</div>
							<form:label path="description">Description</form:label>
						<div class="label2">	
						</div>	
							<form:errors path="description"/>
						<div class="label2">
						</div>	
							<form:textarea path="description"/>
						</div>
					</div>
					<div class="label2">
						<input type="submit" value="New competition">
					</div>
				</form:form>
			</article>
		</section>
	</div>
</div>	
<%@ include file="footer.jsp" %>
