<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

	<section id="section_side">
		<article class="search">
			<h2>Search Swimmer</h2>
			<form id="formS" action="/search0">
				<input id="inputLen" type="text" name="searchQ" placeholder="By Nation Name">
				<input type="submit" value="Search">
			</form>
			<form id="formS" action="/se">
				<input id="inputLen"  type="number" name="searchQ1" placeholder="By Birth Year">
				<input type="submit" value="Search">
			</form>
			<form id="formS" action="/se2">
				<input id="inputLen" type="text" name="searchQ2" placeholder="By Name">
				<input type="submit" value="Search">
			</form>
			
		</article>
			
		<article>
			<h2>Links</h2>
			<ul>
				<li><a href="http://youtube.com">Youtube</a></li>
				<li><a href="https://www.fina.org/artistic-swimming">FINA</a></li>
				<li><a href="http://kallipolis.es/peranys.htm?var-any=1993">CNK</a></li>
				<li><a href="https://www.gettyimages.com/photos/artistic-swimming?family=editorial&phrase=artistic%20swimming&sort=newest#license">Getty Images</a></li>
			</ul>
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
				
				<article>
					<h2>Routines</h2>
					<ul>
						<c:forEach items="${routines}" var="routine">
						<li><a href="/routines/${routine.id}"><c:out value="${routine.routineName}"/></a></li>
						</c:forEach>
					</ul>
				</article>
	</section>