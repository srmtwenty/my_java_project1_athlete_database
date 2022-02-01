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
			<h1 id="h1_align">New Party</h1>

			<form:form action="/parties/new" method="POST" modelAttribute="party">
				<div class="row2">
					<div class="label2">
						<form:label path="partyName">Name:</form:label>
					</div>
					<div class="label2">	
						<form:errors path="partyName"/>
					</div>
					<div class="label2">
						<form:input path="partyName"/>
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
						<form:textarea path="description"/>
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
					<div class="label2">
						<form:label path="routine">Routine:</form:label>
					</div>
					<div class="label2">
						<form:errors path="routine"/>
					</div>
					<div class="label2">
						<form:select name="routine" path="routine">
							<c:forEach items="${routines}" var="routine">
								<form:option value="${routine}">
									<c:out value="${routine.routineName}"/>
								</form:option>
							</c:forEach>
						</form:select>
					</div>
				</div>
				<div class="row2">
					<div class="label2">
						<form:label path="competition">Competition:</form:label>
					</div>
					<div class="label2">
						<form:errors path="competition"/>
					</div>
					<div class="label2">
						<form:select name="competition" path="competition">
							<c:forEach items="${competitions}" var="competition">
								<form:option value="${competition}">
									<c:out value="${competition.name}"/>
								</form:option>
							</c:forEach>
						</form:select>
					</div>
				</div>
				
				<div class="row2">
					<div class="label2">
						<form:label path="score">Score:</form:label>
					</div>
					<div class="label2">
						<form:errors path="score"/>
					</div>
					<div class="label2">
						<form:input type="number" step="any" path="score"/>
					</div>
				</div>
				<div class="row2">
					<div class="label2">
						<form:label path="ranking">Ranking:</form:label>
					</div>
					<div class="label2">
						<form:errors path="ranking"/>
					</div>
					<div class="label2">
						<form:input path="ranking"/>
					</div>
				</div>
				<div class="label2">
					<input type="submit" value="Create Party">
				</div>
			</form:form>
			</article>
		</section>
	</div>
</div>	
<%@ include file="footer.jsp" %>