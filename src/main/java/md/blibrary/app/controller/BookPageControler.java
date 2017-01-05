package md.blibrary.app.controller;


import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import md.blibrary.app.dao.BookDAO;
import md.blibrary.app.dao.exceptions.NoSuchEntityException;
import md.blibrary.app.dao.exceptions.SystemException;
import md.blibrary.app.dao.impl.BookDAOImpl;
import md.blibrary.app.entity.Book;

public class BookPageControler extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String PAGE_OK = "WEB-INF/vievs/book.jsp";
	private static final String PAGE_ERROR = "home.do";
	private static final int SC_NOT_FOUND = 404;
	
    public BookPageControler() {
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			BookDAO bookDAO = new BookDAOImpl();
			Book book = bookDAO.selectByID(Integer.parseInt(request.getParameter("book_id")));
			request.setAttribute("book", book);
			request.setAttribute("title", book.getBookName());
			
			request.getRequestDispatcher(PAGE_OK).forward(request, response);
			
		} catch (NoSuchEntityException | SystemException ignore) {
			response.sendRedirect(PAGE_ERROR);
		} catch (NumberFormatException nfe) {
			response.sendError(SC_NOT_FOUND);
		}
	}
}