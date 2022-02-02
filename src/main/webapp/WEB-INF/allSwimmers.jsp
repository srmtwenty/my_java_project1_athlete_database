<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isErrorPage="true"%>
<%@ include file="header.jsp" %>

<div class="wrapper">
		
	<%@include file="navigator_left.jsp"%>
	<div id="b_main">	
		<section id="section_main">
			<article class="nav_main">

				<h2>All Swimmers</h2>
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
										<a href="/swimmers/${swimmer.id}/edit" class="buttonE">Edit</a>
										<a href="/swimmers/${swimmer.id}/delete" class="buttonD">Delete</a>	
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