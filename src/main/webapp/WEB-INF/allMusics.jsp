<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isErrorPage="true"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ include file="header.jsp" %>
	
<div class="wrapper">
		
	<%@include file="navigator_left.jsp"%>
	<div id="b_main">		
		<section id="section_main">
			<article class="nav_main">
				<h2>All Musics</h2>
				<table>
					<thead>
						<tr>
							<th>Music title</th>
							<th>Album</th>
							<th>Composer</th>
							<th>Host</th>
							<th>Performed By</th>
							<th>Action</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${musics}" var="music">
						<tr>
							<td><a href="/musics/${music.id}"><c:out value="${music.title}"/></a></td>
							<td><c:out value="${music.album.title}"/></td>
							<td><c:out value="${music.composer.name}"/></td>
							<td><c:out value="${music.host.username}"/></td>
							<td><c:out value="${music.performer}"/></td>
							<td>
								<c:choose>
									<c:when test="${loggedUser==music.host}">
										<a href="/musics/${music.id}/edit">Edit</a>
										<a href="/musics/${music.id}/delete">Delete</a>
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
