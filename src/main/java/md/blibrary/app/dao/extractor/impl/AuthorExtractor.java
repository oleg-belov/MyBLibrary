package md.blibrary.app.dao.extractor.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.TreeMap;

import md.blibrary.app.dao.extractor.Extractor;
import md.blibrary.app.entity.Author;



public class AuthorExtractor extends Extractor<Author> {
	
	public Author extract(ResultSet rs) throws SQLException {
		Author author = new Author(rs.getInt("author_id"));
		
		author.setAuthorName(rs.getString("author_name"));
		author.setAuthorDateOfBirth(rs.getDate("author_date_of_birth"));
		author.setBooks(getBooksMap(
				rs.getString("books_id"),
				rs.getString("books_name")));
		
		return author;
	}
	private static TreeMap<String, String> getBooksMap(String booksId, String booksName) throws SQLException {
		String[] bookId =booksId.split(","); 
		String[] bookName =booksName.split("/"); 
		TreeMap<String, String> books = new TreeMap<>();
		
		for(int i = 0; i < bookId.length; i++) {
			books.put(bookId[i], bookName[i]);
		}
		return books;
	}
}
