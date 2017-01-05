package md.blibrary.app.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import md.blibrary.app.dao.BookDAO;
import md.blibrary.app.dao.exceptions.NoSuchEntityException;
import md.blibrary.app.dao.exceptions.SystemException;
import md.blibrary.app.dao.impl.BookDAOImpl;
import md.blibrary.app.entity.Book;

public class CategoryPageControler extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String PAGE_OK = "WEB-INF/vievs/home.jsp";
	private static final String PAGE_ERROR = "home.do";
	private static final int SC_NOT_FOUND = 404;
	
    public CategoryPageControler() {
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			BookDAO bookDAO = new BookDAOImpl();
			List<Book> bookList = bookDAO.selectByCategory(Integer.parseInt(request.getParameter("category_id")));
			if(bookList != null)
				request.setAttribute("books", bookList);
			
			request.getRequestDispatcher(PAGE_OK).forward(request, response);
		
		} catch (NoSuchEntityException e) {
			request.getRequestDispatcher(PAGE_OK).forward(request, response);
		} catch (SystemException e) {
			request.getRequestDispatcher(PAGE_ERROR).forward(request, response);
		} catch (NumberFormatException nfe) {
			response.sendError(SC_NOT_FOUND);
		}
	}

}