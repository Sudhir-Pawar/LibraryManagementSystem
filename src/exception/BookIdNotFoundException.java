package exception;

import java.sql.SQLIntegrityConstraintViolationException;

public class BookIdNotFoundException extends SQLIntegrityConstraintViolationException{
	String BookId;

	public BookIdNotFoundException(String bookId) {
		super();
		BookId = bookId;
	}

	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return "BookId: "+BookId+" not found";
	}
	
}
