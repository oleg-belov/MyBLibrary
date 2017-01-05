package md.blibrary.app.controller;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import md.blibrary.app.dao.FileDAO;
import md.blibrary.app.dao.exceptions.NoSuchEntityException;
import md.blibrary.app.dao.exceptions.SystemException;
import md.blibrary.app.dao.impl.FileDAOImpl;

public class PdfControler extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String SELECT_BY_ID_SQL = "SELECT book_pdf FROM book WHERE book_id = ?";
	private static final String PAGE_ERROR = "home.do";
	private static final int SC_NOT_FOUND = 404;
       
    public PdfControler() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int pdfId = Integer.parseInt(request.getParameter("pdf_Id"));
		FileDAO fileDao = new FileDAOImpl();
		try {
			byte[] pdfBytes = fileDao.selectFileById(SELECT_BY_ID_SQL, pdfId);
			
			response.setContentType("application/pdf");
	       
			OutputStream os = response.getOutputStream();
	        BufferedOutputStream bos = new BufferedOutputStream(os);
	        bos.write(pdfBytes, 0, pdfBytes.length);
	        bos.close();
			
		} catch (NoSuchEntityException | SystemException ignore) {
			response.sendRedirect(PAGE_ERROR);
		} catch (NumberFormatException nfe) {
			response.sendError(SC_NOT_FOUND);
		}
	}

}
