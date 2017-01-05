package md.blibrary.app.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import md.blibrary.app.beans.BaseImageDo;
import md.blibrary.app.dao.FileDAO;
import md.blibrary.app.dao.exceptions.NoSuchEntityException;
import md.blibrary.app.dao.exceptions.SystemException;
import md.blibrary.app.dao.impl.FileDAOImpl;

public class AuthorImageControler extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String SELECT_BY_ID_SQL = "SELECT author_img FROM author WHERE author_id = ?";  
	
    public AuthorImageControler() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int imgId = Integer.parseInt(request.getParameter("img_id"));
		FileDAO fileDao = new FileDAOImpl();
		try {
			byte[] imgBytes = fileDao.selectFileById(SELECT_BY_ID_SQL, imgId);
			BaseImageDo.responseProces(response, imgBytes);
			
		} catch (NoSuchEntityException | SystemException e) {
			e.printStackTrace();
		} catch (NumberFormatException ignore) {
			/*NOP*/
		}
	}

}