<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ include file="header.jsp" %>
<div class="wrapper">	
	<%@include file="navigator_left.jsp"%>
	<div id="b_main">	
		<section id="section_main">
			<article class="nav_main">
	
				<h1>Routine Name: <c:out value="${routine.routineName}"/></h1>
				<p>Competitions:</p> 
				<c:forEach items="${competitions}" var="competition">
				<ul>
					<li><c:out value="${competition.name}"/><a href="/competitions/routines/${routine.id}/remove">Remove</a></li>
				</ul>
				</c:forEach>
				
				<p>Routine Groups:</p>
				
				<table>
					<thead>
						<tr>
							<th>Group Names</th>
							<th>Action</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${parties}" var="party">
						<tr>
							<td><c:out value="${party.partyName}"/></td>
							<td></td>
						</tr>
						</c:forEach>
					</tbody>
				</table>
				
				<h3>Add Competition</h3>
				<form action="/routines/${r.id}/addCompetition" method="POST">	
					<p>
						<select name="competition">
							<c:forEach items="${competitions}" var="competition">
							<option value="${competition.id}">
								<c:out value="${competition.name}"/>
							</option>
							</c:forEach>
						</select>
					</p>
					<input type="submit" value="Add Competition">
				</form>
			</article>
		</section>
	</div>
</div>
<%@ include file="footer.jsp" %>
</html>