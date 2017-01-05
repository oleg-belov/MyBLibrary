package md.blibrary.app.dao.impl;

import java.util.LinkedList;
import java.util.List;

import md.blibrary.app.dao.exceptions.NoSuchEntityException;
import md.blibrary.app.dao.exceptions.SystemException;
import md.blibrary.app.dao.extractor.impl.BookExtractor;
import md.blibrary.app.dao.BaseDAO;
import md.blibrary.app.dao.BookDAO;
import md.blibrary.app.entity.Book;

public class BookDAOImpl extends BaseDAO<Book> implements BookDAO {
	 private static final String SELECT_ALL_SQL = "SELECT book.book_id, book.book_name, book.book_descr, book.book_pages, book.book_date, book.book_language, book.category_id, " 
		 											+ "	book.book_tupe, STRING_AGG(author.author_id::character varying,',' ORDER BY  author.author_id) AS author_id, "
		 											+ "	STRING_AGG(author.author_name,'/' ORDER BY  author.author_id) AS author_name "
											 		+ "FROM book "
											 		+ " JOIN book_author ON book_author.book_id = book.book_id "
											 		+ " JOIN author ON author.author_id = book_author.author_id "
											 		+ "GROUP BY book.book_id;";
	  private static final String SELECT_BY_ID_SQL = "SELECT book.book_id, book.book_name, book.book_descr, book.book_pages, book.book_date, book.book_language, book.category_id, " 
													+ "	book.book_tupe, STRING_AGG(author.author_id::character varying,',' ORDER BY  author.author_id) AS author_id, "
													+ "	STRING_AGG(author.author_name,'/' ORDER BY  author.author_id) AS author_name "
											 		+ "FROM book "
			  										+ " JOIN book_author ON book_author.book_id = book.book_id AND book_author.book_id = ? "
			  										+ " JOIN author ON author.author_id = book_author.author_id "
			  										+ "GROUP BY book.book_id;";
	  private static final String SELECT_BY_CATEGORY_SQL = "SELECT book.book_id, book.book_name, book.book_descr, book.book_pages, book.book_date, book.book_language, book.category_id, " 
															+ "	book.book_tupe, STRING_AGG(author.author_id::character varying,',' ORDER BY  author.author_id) AS author_id, "
															+ "	STRING_AGG(author.author_name,'/' ORDER BY  author.author_id) AS author_name "
													 		+ "FROM book "
													 		+ " JOIN book_author ON book_author.book_id = book.book_id AND book.category_id = ? "
					  										+ " JOIN author ON author.author_id = book_author.author_id "
					  										+ "GROUP BY book.book_id;";
	  private static final String SELECT_BY_BOOK_NAME_AND_AUTHOR_SQL = " ?;";

	public List<Book> selectAll() throws SystemException, NoSuchEntityException {
		return super.selectALL(SELECT_ALL_SQL, new BookExtractor());
	}

	public Book selectByID(int bookID) throws SystemException, NoSuchEntityException {
		return super.selectBy(SELECT_BY_ID_SQL, bookID, new BookExtractor());
	}

	public List<Book> selectByCategory(int categoryID) throws SystemException, NoSuchEntityException {
		return super.selectBy(SELECT_BY_CATEGORY_SQL, new BookExtractor(), categoryID);
	}

	public List<Book> selectByBookNameAndAuthor(String bookName, String author)
			throws SystemException, NoSuchEntityException {
		// TODO Auto-generated method stub
		List<Book> result = new LinkedList<>();
		return result;
	}
}
