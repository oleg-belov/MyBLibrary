<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>

<%@include file="jsp/header.jsp" %>

		<div id="allContent">	
		
<%@include file="jsp/category.jsp" %>	
	
				<div id ="books">
					<div class="authorBook">
						<img class="bookImg" src="authorimage.do?img_id=${author.authorID}" alt="${author.authorName}" height=400px>
						<h1 class="title">${author.authorName}</h1>
						<c:if test="${not empty author.authorDateOfBirth}">
   							 <p>Дата рождения: ${author.authorDateOfBirth}</p>
						</c:if>
						<p class="autor">Книги:
						<c:forEach var="book" items="${author.books}">
							<a href="book.do?book_id=${book.key}">${book.value}</a>,</br> 
						</c:forEach>	
						</p>
					</div>
				</div>
		</div> <!-- allContent -->
			
<%@include file="jsp/footer.jsp" %>	
