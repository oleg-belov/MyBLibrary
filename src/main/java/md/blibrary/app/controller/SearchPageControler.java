package md.blibrary.app.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SearchPageControler extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String PAGE_ERROR = "home.do";   
    public SearchPageControler() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setAttribute("title", "todo");
		response.sendRedirect(PAGE_ERROR);
	}

}
