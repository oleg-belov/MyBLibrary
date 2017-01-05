package md.blibrary.app.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import md.blibrary.app.dao.DAO;
import md.blibrary.app.dao.exceptions.NoSuchEntityException;
import md.blibrary.app.dao.exceptions.SystemException;
import md.blibrary.app.dao.impl.BookDAOImpl;
import md.blibrary.app.entity.Book;

public class HomePageControler extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String PAGE_OK = "WEB-INF/vievs/home.jsp";
	private static final int PAGE_NOT_FOUND_ERROR = 404;
	private static final int PAGE_GONE_ERROR = 410;

	public HomePageControler() {
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			DAO<Book> bookDAO = new BookDAOImpl();
			List<Book> bookList = bookDAO.selectAll();
			request.setAttribute("books", bookList);
			request.setAttribute("title", "Home ");

			request.getRequestDispatcher(PAGE_OK).forward(request, response);

		} catch (NoSuchEntityException | NumberFormatException e) {
			response.sendError(PAGE_NOT_FOUND_ERROR);
		} catch (SystemException e) {
			response.sendError(PAGE_GONE_ERROR);
		}
	}

}
