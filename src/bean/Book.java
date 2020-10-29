package bean;

public class Book {
	private String bookId,bookName,authorName;

	public Book(String bookID, String bookName, String authorName) {
		super();
		this.bookId = bookID;
		this.bookName = bookName;
		this.authorName = authorName;
	}

	public String getBookId() {
		return bookId;
	}

	public void setBookId(String bookId) {
		this.bookId = bookId;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getAuthorName() {
		return authorName;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "[" + bookId+" "+ bookName+" "+authorName+"]";
	}
	
	
}
