package exception;

public class BookAlreadyIssuedException extends Exception{

	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return "Book Already Issued.";
	}
	
}
