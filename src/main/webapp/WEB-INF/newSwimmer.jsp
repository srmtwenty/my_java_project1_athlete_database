<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ include file="header.jsp" %>
	
	<div class="wrapper">
		
		<%@include file="navigator_left.jsp"%>
		
		<section id="section_main">
			<article class="nav_main">
				<h1 id="h1_align">New Swimmer</h1>
				<form:form action="/swimmers/new" method="POST" modelAttribute="swimmer">
					<div class="row2">
						<div class="label2">
							<form:label path="name">Name:</form:label>
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
							<form:label path="birthYear">Birth Year:</form:label>
						</div>
						<div class="label2">
							<form:errors path="birthYear"/>
						</div>
						<div class="label2">
							<form:input type="number" path="birthYear"/>
						</div>
					</div>
					<div class="row2">
						<div class="label2">
							<form:label path="description">Description:</form:label>
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
							<form:label path="nation">Nation:</form:label>
						</div>
						<div class="label2">
							<form:errors path="nation"/>
						</div>
						<div class="label2">
							<form:select name="nation" path="nation">
								<c:forEach items="${nations}" var="nation">
								<form:option value="${nation}">
									<c:out value="${nation.name}"/>
								</form:option>
								</c:forEach>
							</form:select>
						</div>
					</div>
					<div class="row2">
						<input type="submit" value="New Swimmer">
					</div>
				</form:form>
			</article>
		</section>
	</div>	
	<%@ include file="footer.jsp" %>
