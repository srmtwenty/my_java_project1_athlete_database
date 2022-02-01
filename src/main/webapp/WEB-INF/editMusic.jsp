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
				<h1 id="h1_align">Edit Music</h1>

				<form:form action="/musics/${music.id}/edit" method="POST" modelAttribute="music">
					<input type="hidden" name="_method" value="PUT">
					<div class="row2">
						<div class="label2">
							<form:label path="title">Title:</form:label>
						</div>
						<div  class="input2">
							<form:errors path="title"/>
						</div>
						<div>
							<form:input path="title"/>
						</div>
					</div>
					<div class="row2">
						<div>
							<form:label path="album">Album:</form:label>
						</div>
						<div>
							<form:errors path="album"/>
						</div>
						<div>
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
						<div>
							<form:label path="composer">Composer:</form:label>
						</div>
						<div>
							<form:errors path="composer"/>
						</div>
						<div>
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
						<div>
							<form:label path="performer">Performer:</form:label>
						</div>
						<div>
							<form:errors path="performer"/>
						</div>
						<div>
							<form:input path="performer"/>
						</div>
					</div>
					
					<div class="row2">
						<div>
							<form:label path="description">Description:</form:label>
						</div>
						<div>
							<form:errors path="description"/>
						</div>
						<div>
							<form:textarea rows="6" path="description"/>
						</div>
					</div>
					<div class="row2">
						<input id="row2_button" type="submit" value="Update Music"> |
						<a href="/musics/${music.id}">Cancel</a>
					</div>
				</form:form>
			</article>
		</section>
	</div>
</div>
<%@ include file="footer.jsp" %>
