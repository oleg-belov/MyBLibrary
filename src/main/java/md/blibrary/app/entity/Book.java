package md.blibrary.app.entity;

import java.util.Map;

public class Book {
	private int bookID;
	private String bookName;
	private String bookDescr;
	private int bookPages;
	private int bookDate;
	private String bookLanguage;
	private int bookCategory;
	private String bookTupe;
	private Map<String, String> bookAuthors;
	
	public Book(int bookID) {
		this.bookID = bookID;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getBookDescr() {
		return bookDescr;
	}

	public void setBookDescr(String bookDescr) {
		this.bookDescr = bookDescr;
	}

	public int getBookPages() {
		return bookPages;
	}

	public void setBookPages(int bookPages) {
		this.bookPages = bookPages;
	}

	public int getBookDate() {
		return bookDate;
	}

	public void setBookDate(int bookDate) {
		this.bookDate = bookDate;
	}

	public String getBookLanguage() {
		return bookLanguage;
	}

	public void setBookLanguage(String bookLanguage) {
		this.bookLanguage = bookLanguage;
	}

	public int getBookCategory() {
		return bookCategory;
	}

	public void setBookCategory(int bookCategory) {
		this.bookCategory = bookCategory;
	}

	public String getBookTupe() {
		return bookTupe;
	}

	public void setBookTupe(String bookTupe) {
		this.bookTupe = bookTupe;
	}

	public Map<String, String> getBookAuthors() {
		return bookAuthors;
	}

	public void setBookAuthors(Map<String, String> bookAuthors) {
		this.bookAuthors = bookAuthors;
	}

	public int getBookID() {
		return bookID;
	}

}
