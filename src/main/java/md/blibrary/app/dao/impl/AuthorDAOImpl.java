package md.blibrary.app.dao.impl;

import java.util.List;

import md.blibrary.app.dao.AuthorDAO;
import md.blibrary.app.dao.BaseDAO;
import md.blibrary.app.dao.exceptions.NoSuchEntityException;
import md.blibrary.app.dao.exceptions.SystemException;
import md.blibrary.app.dao.extractor.impl.AuthorExtractor;
import md.blibrary.app.entity.Author;



public class AuthorDAOImpl extends BaseDAO<Author> implements AuthorDAO {
	private static final String SELECT_ALL_SQL = "SELECT author.author_id, author.author_name, author.author_date_of_birth "
													+ ", STRING_AGG(book.book_id::character varying,',' ORDER BY  book.book_id) AS books_id "
													+ ", STRING_AGG(book.book_name,'/' ORDER BY  book.book_id) AS books_name "
											 		+ "FROM author "
											 		+ " JOIN book_author ON book_author.author_id = author.author_id "
											 		+ " JOIN book ON book.book_id = book_author.book_id "
											 		+ "GROUP BY author.author_id;";
	private static final String SELECT_BY_ID_SQL = "SELECT author.author_id, author.author_name, author.author_date_of_birth "
													+ ", STRING_AGG(book.book_id::character varying,',' ORDER BY  book.book_id) AS books_id "
													+ ", STRING_AGG(book.book_name,'/' ORDER BY  book.book_id) AS books_name "
											 		+ "FROM author "
													+ " JOIN book_author ON book_author.author_id = author.author_id AND author.author_id = ? "
													+ " JOIN book ON book.book_id = book_author.book_id "
													+ "GROUP BY author.author_id;";
	
	public List<Author> selectAll() throws SystemException, NoSuchEntityException {
		return super.selectALL(SELECT_ALL_SQL, new AuthorExtractor());
	}

	public Author selectByID(int authorID) throws SystemException, NoSuchEntityException {
		return super.selectBy(SELECT_BY_ID_SQL, authorID, new AuthorExtractor());
	}
}
