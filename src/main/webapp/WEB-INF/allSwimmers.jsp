<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isErrorPage="true"%>
<%@ include file="header.jsp" %>

	<div class="wrapper">
		
		<%@include file="navigator_left.jsp"%>
		
		<section id="section_main">
			<article class="nav_main">

				<h1>Swimmers List</h1>
				<table>
					<thead>
						<tr>
							<th>Swimmer</th>
							<th>Nation</th>
							<th>Host</th>
							<th>Action</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${swimmers}" var="swimmer">
						<tr>
							<td><a href="/swimmers/${swimmer.id}"><c:out value="${swimmer.name}"/></a></td>
							<td><a href="/nations/${swimmer.nation.id}"><c:out value="${swimmer.nation.name}"/></a></td>
							<td><c:out value="${swimmer.host.username}"/></td>
							<td>
								<c:choose>
									<c:when test="${loggedUser==swimmer.host}">
										<a href="/swimmers/${swimmer.id}/delete">Delete</a> |
										<a href="/swimmers/${swimmer.id}/edit">Edit</a>
								
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
<%@ include file="footer.jsp" %>