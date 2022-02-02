<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="header.jsp" %>
<div class="wrapper">	
	<%@include file="navigator_left.jsp"%>
	<div id="b_main">	
		<section id="section_main">
			<article class="nav_main">

				<h1><c:out value="${competition.name}"/></h1>
				<p><strong>Location:</strong> <c:out value="${competition.location}"/></p>
				<p><strong>Year:</strong> <c:out value="${competition.year}"/></p>
				<p><strong>Description:</strong><c:out value="${competition.description}"/></p>
				<p><strong>Host:</strong><c:out value="${competition.host.username}"/></p>
				<p><strong>Event Type:</strong><c:out value="${competition.eventType}"/></p>
				<p><strong>Attendees:</strong></p>
				<ul>
					<c:forEach items="${findAllByComp}" var="findA">
						<li><c:out value="${findA.username}"/></li>
					</c:forEach>
				</ul>
				<p><strong>Number of Attendees:</strong> <c:out value="${countByComp}"/></p>
				<table>
					<thead>
						<tr>
							<th>Parties</th>
							<th>Routine</th>
							<th>Action</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${compParties}" var="party">
						<tr>
							<td><a href="/parties/${party.id}"><c:out value="${party.partyName}"/></a></td>
							<td><a href="/routines/${party.routine.id}"><c:out value="${party.routine.routineName}"/></a></td>			
							<td><a href="/competitions/${party.competition.id}/remove">Remove</a></td>
						</tr>
						</c:forEach>
					</tbody>
				</table>
				
				
				<%-- <h3>Add Party</h3>
				<form action="/competitions/${competition.id}/addParty" method="POST">
					<p>
						<select name="party">
							<c:forEach items="${parties}" var="party">
								<option value="${party.id}">
									<c:out value="${party.partyName}"/>
								</option>
							</c:forEach>
						</select>
					</p>
					<input type="submit" value="Add Party">
				</form> --%>
				
				<ul>
					<c:forEach items="${cComments}" var="cComment">
						<li>Commented By:<c:out value="${cComment.host.username}"/> <c:out value="${cComment.content}"/> <c:out value="${cComment.createdAt}"/></li>
					</c:forEach>
				</ul>
				<form action="/competitions/${competition.id}/addComment" method="POST">
					<p>
						<label>Comment:</label>
						<textarea id="content" name="content"></textarea>
					</p>
					<input type="submit" value="Add Comment">
				</form>
				
				<c:choose> 
					<c:when test="${loggedUser==competition.host}">
						<a href="/competitions/${competition.id}/edit">Edit Competition</a>
					</c:when>
					<c:otherwise>
						<p>Only a host can edit party.</p>
					</c:otherwise>
				</c:choose>
			</article>
		</section>
	</div>
</div>
<%@ include file="footer.jsp" %>
