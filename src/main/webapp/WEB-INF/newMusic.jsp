<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="header.jsp"%>
<div class="wrapper">
	<%@include file="navigator_left.jsp"%>
	<div id="b_main">			
		<section id="section_main">
			<article class="nav_main">
				<h1 id="h1_align">New Music</h1>

				<form:form action="/musics/new" method="POST" modelAttribute="music">
					<div class="row2">
						<div class="label2">
							<form:label path="title">Title:</form:label>
						</div>
						<div class="label2">
							<form:errors path="title"/>
						</div>
						<div class="label2">
							<form:input path="title"/>
						</div>
					</div>
					<div class="row2">
						<div class="label2">
							<form:label path="album">Album:</form:label>
						</div>
						<div class="label2">
							<form:errors path="album"/>
						</div>
						<div class="label2">
							<form:select name="album" path="album">
								<c:forEach items="${albums}" var="album">
									<form:option value="${album.id}">
										<c:out value="${album.title}"/>
									</form:option>
								</c:forEach>
							</form:select>
						</div>
					</div>
					<div class="row2">
						<div class="label2">
							<form:label path="composer">Composer:</form:label>
						</div>
						<div class="label2">
							<form:errors path="composer"/>
						</div>
						<div class="label2">
							<form:select name="composer" path="composer">
								<c:forEach items="${composers}" var="composer">
									<form:option value="${composer.id}">
										<c:out value="${composer.name}"/>
									</form:option>
								</c:forEach>
							</form:select>
						</div>
					</div>
					<div class="row2">
						<div class="label2">
							<form:label path="performer">Performer:</form:label>
						</div>
						<div class="label2">	
							<form:errors path="performer"/>
						</div>
						<div class="label2">	
							<form:input path="performer"/>
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
						<input type="submit" value="Create Music">
					</div>
				</form:form>
			</article>
		</section>
	</div>
</div>
<%@ include file="footer.jsp" %>
