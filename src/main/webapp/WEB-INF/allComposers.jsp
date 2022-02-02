<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="header.jsp" %>

<div class="wrapper">	
	<%@include file="navigator_left.jsp"%>
	<div id="b_main">	
	<section id="section_main">
		<article class="nav_main">
			<h2>All Composers</h2>
			<table>
				<thead>
					<tr>
						<th>Composer</th>
						<th>Host</th>
						<th>Action</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${composers}" var="composer">
					<tr>
						<td><a href="/composers/${composer.id}"><c:out value="${composer.name}"/></a></td>
						<td><c:out value="${composer.host.username}"/></td>	
						<td>
							<c:choose>
								<c:when test="${loggedUser==composer.host}">	
									<a href="/composers/${composer.id}/edit" class="buttonE">Edit</a>
									<a href="/composers/${composer.id}/delete" class="buttonD">Delete</a>
								</c:when>
								<c:otherwise>
									None
								</c:otherwise>
							</c:choose>
						</td>
					</tr>
					</c:forEach>
				</tbody>
			</table>
		</article>
	</section>
	</div>	
</div>
<%@ include file="footer.jsp" %>
