<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="header.jsp" %>

<div class="wrapper">
		
	<%@include file="navigator_left.jsp"%>
	<div id="b_main">		
		<section id="section_main">
	
			<article class="nav_main">
				<h2>Competitions</h2>
				
				<nav>
					<a href="/competitions">Sort by Name</a> |
					<a href="/competitions/yearDesc">Sort by Year Desc</a> |
					<a href="/competitions/yearAsc">Sort by Year Asc</a> |
				</nav>
				
				<table>
					<thead>
						<tr>
							<th>Competition(sort by name)</th>
							<th>Location</th>
							<th>Year</th>
							<th>Host</th>
							<th>Action</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${competitions}" var="competition">
						<tr>
							<td><a href="/competitions/${competition.id}"><c:out value="${competition.name}"/></a></td>
							<td><c:out value="${competition.location}"/></td>
							<td><c:out value="${competition.year}"/></td>
							<td><c:out value="${competition.host.username}"/></td>
							<td>
								<c:choose>
									<c:when test="${loggedUser.id==competition.host.id}">
										<a href="/competitions/${competition.id}/edit" class="buttonE">Edit</a>
										<a href="/competitions/${competition.id}/delete" class="buttonD">Delete</a>
									</c:when>
									<c:when test="${competition.attendees.contains(loggedUser)}">
										Joined <a href="/competitions/${competition.id}/cancel">Cancel</a>
									</c:when>
									<c:otherwise>
										<a href="/competitions/${competition.id}/join">Join</a>
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
