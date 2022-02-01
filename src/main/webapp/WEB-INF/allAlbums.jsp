<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="header.jsp" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>

<div class="wrapper">
		
	<%@include file="navigator_left.jsp"%>
	<div id="b_main">	
		<section id="section_main">
			<article class="nav_main">
				<h2>All Albums</h2>
				<table>
					<thead>
						<tr>
							<th>Album</th>
							<th>Host</th>
							<th>Action</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${albums}" var="album">
						<tr>
							
							<td><a href="/albums/${album.id}"><c:out value="${album.title}"/></a></td>
							<td><c:out value="${album.host.username}"/></td>
							<td>
								<c:choose>
									<c:when test="${loggedUser==album.host}">
										<a href="/albums/${album.id}/edit">Edit</a>
										<a href="/albums/${album.id}/delete">Delete</a>
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
