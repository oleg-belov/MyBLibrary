<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>

<%@include file="jsp/header.jsp" %>

		<div id="allContent">	
		
<%@include file="jsp/category.jsp" %>	
	
				<div id ="books">
				<c:forEach  var="book" items="${books}">
					<div class="book">
						<a class="bookImg" href="book.do?book_id=${book.bookID}""><img src="bookimage.do?img_id=${book.bookID}" alt="${book.bookName}" height=250px></a>
						<h1 class="title"><a href="book.do?book_id=${book.bookID}">${book.bookName}</a></h1>
						<p class="autor">Авторы:
							<c:forEach var="author" items="${book.bookAuthors}">
								<a href="author.do?author_id=${author.key}">${author.value}</a>, 
							</c:forEach>
						</p>
					<p>${book.bookDescr}</p>	
					</div>
					</c:forEach>
				</div>
		</div> <!-- allContent -->
			
<%@include file="jsp/footer.jsp" %>	
