<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@include file="header.jsp"%>
	
	<div class="wrapper">
		
		<%@include file="navigator_left.jsp"%>
		
		<section id="section_main">
			<article class="nav_main">
				<h2>Competitions</h2>
				<table>
					<thead>
						<tr>
							<th>Competition</th>
							<th>Location</th>
							<th>Year</th>
							<th>Action</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${competitions}" var="competition">
						<tr>
							<td><a href="/competitions/${competition.id}"><c:out value="${competition.name}"/></a></td>
							<td><c:out value="${competition.location}"/></td>
							<td><c:out value="${competition.year}"/></td>
							<td>
								<c:choose>
									<c:when test="${loggedUser==competition.host}">
										<div class="button_group">
											<a href="/competitions/${competition.id}/edit">Edit</a> |
											<a href="/competitions/${competition.id}/delete">Delete</a> 
										</div>
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
			
			<article>
					
					<h2>Nations</h2>
					<ul>
						
						<c:forEach items="${nations}" var="nation">
							<li>
								<a href="/nations/${nation.id}"><c:out value="${nation.name}"/></a>
							</li>
						</c:forEach>
					</ul>
				</article>
				
		</section>
	
	</div>
	<%@ include file="footer.jsp" %>
