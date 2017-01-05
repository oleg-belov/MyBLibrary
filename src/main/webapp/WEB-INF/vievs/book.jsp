<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>

<%@include file="jsp/header.jsp" %>

		<div id="allContent">	
		
<%@include file="jsp/category.jsp" %>	
	
				<div id ="books">
					<div class="authorBook">
						<img class="bookImg" src="bookimage.do?img_id=${book.bookID}" alt="${book.bookName}" height=400px>
						<h1 class="title">${book.bookName}</h1>
						<p class="autor">Авторы:
							<c:forEach var="author" items="${book.bookAuthors}">
								<a href="author.do?author_id=${author.key}">${author.value}</a>, 
							</c:forEach>
						</p>
						<p>Формат книги: ${book.bookTupe}</p>
						<p>Количество страниц: ${book.bookPages}</p>
						<p>Год выпуска: ${book.bookDate}</p>
						<p>О книге: </p>
							<p>${book.bookDescr}</p>
						<a class="bookImg" href="pdf.do?pdf_Id=${book.bookID}""><h1>Читать книгу</h1></a>
					</div>
				</div>
		</div> <!-- allContent -->
			
<%@include file="jsp/footer.jsp" %>	
