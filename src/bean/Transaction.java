package bean;

public class Transaction{
	private String bookId, userID, issueDate, returnDate;
	int fine;
	
	public Transaction(String bookId, String userID, String issueDate, String returnDate, int fine) {
		super();
		this.bookId = bookId;
		this.userID = userID;
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

	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
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
		return "Transaction [bookId=" + bookId + ", userID=" + userID + ", issueDate=" + issueDate + ", returnDate="
				+ returnDate + ", fine=" + fine + "]";
	}
}

