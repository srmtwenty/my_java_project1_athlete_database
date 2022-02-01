<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isErrorPage="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@include file="header.jsp"%>
<div class="wrapper">			
	<%@include file="navigator_left.jsp"%>
	<div id="b_main">			
		<section id="section_main">
			<article class="nav_main">
			<img src='<c:out value="${swimmer.photos}"/>' 
				onerror="javascript:this.src='/img/avatar.png'">
			
			<h1 id="h1_align">Edit Swimmer</h1>
				
			<form action="/photo/pic/${swimmer.id}" method="POST"
				enctype="multipart/form-data">
				<label for="image">Photo:</label>
				<input type="file" id="image" name="image" accept="image/png, image/jpeg"/>
				<button type="submit">Upload</button>
			</form>
			
			<form:form action="/swimmers/${swimmer.id}/edit" method="POST" modelAttribute="swimmer">
				<input type="hidden" name="_method" value="PUT">
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
					<input type="submit" value="Update Swimmer">
				</div>
			</form:form>
			</article>
		</section>
	</div>
</div>
<%@ include file="footer.jsp" %>