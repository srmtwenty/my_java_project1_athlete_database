<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isErrorPage="true"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ include file="header.jsp" %>

	<div class="wrapper">
		
		<%@include file="navigator_left.jsp"%>
		
		<section id="section_main">
			<article class="nav_main">
				<table>
					<thead>
						<tr>
							<th>Parties</th>
							<th>Host</th>
							<th>Action</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${parties}" var="party">
						<tr>
							<td><a href="/parties/${party.id}"><c:out value="${party.partyName}"/></a></td>
							<td><c:out value="${party.host.username}"/></td>
							<td>
								<c:choose>
									<c:when test="${loggedUser==party.host}">
										<a href="/parties/${party.id}/edit" class="buttonE">Edit</a>|
										<a href="/parties/${party.id}/delete" class="buttonD">Delete</a>
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