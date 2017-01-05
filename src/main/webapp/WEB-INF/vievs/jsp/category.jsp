<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


		<div id="category">
				<h1>CATEGORY</h1>
				<h2>Java</h2>
				<c:forEach  var="category" items="${bookCaregoryMap}">
					<c:choose>
						<c:when test="${category.key eq 16}">
							<h2>SQL</h2>
							<p>
								<a href="category.do?category_id=${category.key}">${category.value}</a>
							</p>
						</c:when>
						<c:when test="${category.key eq 21}">
							<h2>Front - end</h2>
							<p>
								<a href="category.do?category_id=${category.key}">${category.value}</a>
							</p>
						</c:when>
						<c:otherwise>
							<p>
								<a href="category.do?category_id=${category.key}">${category.value}</a>
							</p>
						</c:otherwise>
					</c:choose>
				</c:forEach>
				
			</div> <!-- category -->