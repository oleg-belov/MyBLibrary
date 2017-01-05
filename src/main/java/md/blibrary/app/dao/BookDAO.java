package md.blibrary.app.dao;

import java.util.List;

import md.blibrary.app.dao.exceptions.NoSuchEntityException;
import md.blibrary.app.dao.exceptions.SystemException;
import md.blibrary.app.entity.Book;

public interface BookDAO extends DAO<Book>{

	public List<Book> selectByCategory(int categoryID) throws SystemException, NoSuchEntityException;
	public List<Book> selectByBookNameAndAuthor(String bookName, String author) 
			throws SystemException, NoSuchEntityException; 
	
}
