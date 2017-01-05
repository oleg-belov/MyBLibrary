package md.blibrary.app.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import md.blibrary.app.dao.DAO;
import md.blibrary.app.dao.exceptions.NoSuchEntityException;
import md.blibrary.app.dao.exceptions.SystemException;
import md.blibrary.app.dao.impl.AuthorDAOImpl;
import md.blibrary.app.entity.Author;

public class AuthorPageControler extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String PAGE_OK = "WEB-INF/vievs/author.jsp";
	private static final String PAGE_ERROR = "home.do";
	private static final int SC_NOT_FOUND = 404;
	
    public AuthorPageControler() {
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			DAO<Author> aythorDAO = new AuthorDAOImpl();
			Author author = aythorDAO.selectByID(Integer.parseInt(request.getParameter("author_id")));
			request.setAttribute("author", author);
			request.setAttribute("title", author.getAuthorName());

			request.getRequestDispatcher(PAGE_OK).forward(request, response);
			
		} catch (NoSuchEntityException | SystemException ignore) {
			response.sendRedirect(PAGE_ERROR);
		} catch (NumberFormatException nfe) {
			response.sendError(SC_NOT_FOUND);
		}
	}

}
