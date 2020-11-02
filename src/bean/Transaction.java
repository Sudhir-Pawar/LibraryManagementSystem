package bean;

public class Transaction{
	private String bookId, userId, issueDate, returnDate;
	int fine;
	
	
	
	public Transaction(String bookId, String userId, String date,boolean isReturndate) {
		super();
		this.bookId = bookId;
		this.userId = userId;
		if(isReturndate) {
			this.returnDate = date;
		}
		this.issueDate = date;
	}

	public Transaction(String bookId, String userId, String issueDate, String returnDate, int fine) {
		super();
		this.bookId = bookId;
		this.userId = userId;
		this.issueDate = issueDate;
		this.returnDate = returnDate;
		this.fine = fine;
	}


	public String getBookId() {
		return bookId;
	}

	public void setBookId(String bookId) {
		this.bookId = bookId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getIssueDate() {
		return issueDate;
	}

	public void setIssueDate(String issueDate) {
		this.issueDate = issueDate;
	}

	public String getReturnDate() {
		return returnDate;
	}

	public void setReturnDate(String returnDate) {
		this.returnDate = returnDate;
	}

	public int getFine() {
		return fine;
	}

	public void setFine(int fine) {
		this.fine = fine;
	}
	
	@Override
	public String toString() {
		return "Transaction [bookId=" + bookId + ", userId=" + userId + ", issueDate=" + issueDate + ", returnDate="
				+ returnDate + ", fine=" + fine + "]";
	}
}

