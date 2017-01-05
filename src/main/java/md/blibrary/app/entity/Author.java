package md.blibrary.app.entity;

import java.util.Date;
import java.util.Map;

public class Author {
	
	private int authorID;
	private String authorName;
	private Date authorDateOfBirth;
	private  Map<String, String> books;
	
	public Author(int authorID) {
		this.authorID = authorID;
	}
	
	public String getAuthorName() {
		return authorName;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}

	public Date getAuthorDateOfBirth() {
		return authorDateOfBirth;
	}

	public void setAuthorDateOfBirth(Date authorDateOfBirth) {
		this.authorDateOfBirth = authorDateOfBirth;
	}

	public Map<String, String> getBooks() {
		return books;
	}

	public void setBooks(Map<String, String> books) {
		this.books = books;
	}
	
	public int getAuthorID() {
		return authorID;
	}
}
