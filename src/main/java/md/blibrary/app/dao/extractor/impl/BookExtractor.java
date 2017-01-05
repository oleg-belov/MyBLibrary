package md.blibrary.app.dao.extractor.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.TreeMap;

import md.blibrary.app.dao.extractor.Extractor;
import md.blibrary.app.entity.Book;

public class BookExtractor extends Extractor<Book>{

	public Book extract(ResultSet rs) throws SQLException {
		Book book = new Book(rs.getInt("book_id"));
		
		book.setBookName(rs.getString("book_name"));
		book.setBookDescr(rs.getString("book_descr"));
		book.setBookPages(rs.getInt("book_pages"));
		book.setBookDate(rs.getInt("book_date"));
		book.setBookLanguage(rs.getString("book_language"));
		book.setBookCategory(rs.getInt("category_id"));
		book.setBookTupe(rs.getString("book_tupe"));
		book.setBookAuthors(getAuthorsMap(
				rs.getString("author_id"),
				rs.getString("author_name")));

		return book;
	}

	private static TreeMap<String, String> getAuthorsMap(String authorsId, String authorsName) throws SQLException {
		String[] authorId =authorsId.split(","); 
		String[] authorName =authorsName.split("/"); 
		TreeMap<String, String> authors = new TreeMap<>();
		
		for(int i = 0; i < authorId.length; i++) {
			authors.put(authorId[i], authorName[i]);
		}
		return authors;
	}
}
