<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="header.jsp" %>
<div class="wrapper">
		
		<%@include file="navigator_left.jsp"%>
		<div id="b_main">
			<section>
				<article class="nav_main">
					<h1>Name:<c:out value="${party.partyName}"/></h1>
					
					<p><strong>Routine:</strong> <c:out value="${party.routine.routineName}"/></p>
					<p><strong>Nation:</strong> <c:out value="${party.nation.name}"/></p>
					<p><strong>Description:</strong> <c:out value="${party.description}"/></p>
					<p><strong>Host:</strong> <c:out value="${party.host.username}"/></p>
					
				</article>
			</section>
			<section id="section_show1">
				<article class="sub-wrap">
					<div><strong>Coaches:</strong></div>
					<table>
						<thead>
							<tr>
								<th>Coach</th>
								<th>Action</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${coaches}" var="coach">
							<tr>
								<td><a href="/swimmers/${coach.id}"><c:out value="${coach.name}"/></a></td>
								<td><a href="/parties/${party.id}/removeCoach?coach=${coach.id}">Remove</a></td>
							</tr>
							</c:forEach>
						</tbody>
					</table>
				</article>
				
				<article>
					<p>Add Coach</p>
					<form action="/parties/${party.id}/addCoach" method="POST">
						<select name="coach">
							<c:forEach items="${swimmers}" var="coach">
								<option value="${coach.id}">
									<c:out value="${coach.name}"/>
								</option>
							</c:forEach>
						</select>
						<input type="submit" value="Add Coach">
					</form>
				</article>
			</section>
			
			<section>
				<article>
					<div><strong>Swimmers:</strong></div>
					<table>
						<thead>
							<tr>
								<th>Swimmer</th>
								<th>Action</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${pSwimmers}" var="swimmer">
							<tr>
								<td><a href="/swimmers/${swimmer.id}"><c:out value="${swimmer.name}"/></a></td>
								<td><a href="/parties/${party.id}/removeSwimmer?swimmer=${swimmer.id}">Remove</a></td>
							</tr>
							</c:forEach>
						</tbody>
					</table>
				</article>
				
				<article>
					<p>Add Swimmer</p>
					<form action="/parties/${party.id}/addSwimmer" method="POST">
						<select name="swimmer">
							<c:forEach items="${swimmers}" var="swimmer">
							<option value="${swimmer.id}">
								<c:out value="${swimmer.name}"/>
							</option>
							</c:forEach>
						</select>
						<input type="submit" value="Add Swimmer">
					</form>
				</article>
			</section>
			
			<section>
				<article>
					<div><strong>Competitions:</strong></div>
					<table>
						<thead>
							<tr>
								<th>Competition</th>
								<th>Action</th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td><c:out value="${competition.name}"/></td>
								<td><a href="/competition/${competition.id}/remove">Remove</a></td>
							</tr>
						</tbody>
					</table>
				</article>
				
			</section>
			
			<section>
				<article>
					<div><strong>Music:</strong></div>
					
					<table>
						<thead>
							<tr>
								<th>Music Title</th>
								<th>Action</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${pMusics}" var="pMusic">
								<tr>
									<td><a href="/musics/${pMusic.id}"><c:out value="${pMusic.title}"/></a></td>
									<td></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
							
					
				</article>
					
				<article>
					<p>Add Music</p>
					<form action="/parties/${party.id}/addMusic" method="POST">
						<select name="music">
							<c:forEach items="${musics}" var="music">
							<option value="${music.id}">
								<c:out value="${music.title}"/>
							</option>
							</c:forEach>
						</select>
						<input type="submit" value="Add Music">
					</form>
				</article>
			</section>
				
			<section>
				<article>
					<ul>
						<c:forEach items="${comments}" var="comment">
							<li>Commented By:<c:out value="${comment.host.username}"/> <c:out value="${comment.content}"/> <c:out value="${comment.createdAt}"/></li>
						</c:forEach>
					</ul>
				</article>
					
				<article>
					<form action="/parties/${party.id}/addComment" method="POST">
						<div class="row">
							<div class="col-35-textarea">
								<label><strong>Comment:</strong></label>
							</div>
							<div class="col-65_textarea">
								<textarea id="content" name="content"></textarea>
							</div>
						</div>
						<input type="submit" value="Add Comment">
					</form>
				
					<c:choose> 
						<c:when test="${loggedUser==party.host}">
							<a href="/parties/${party.id}/edit">Edit Party</a>
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
