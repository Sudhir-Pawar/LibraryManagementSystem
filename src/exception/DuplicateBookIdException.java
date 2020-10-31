package exception;

import java.sql.SQLIntegrityConstraintViolationException;

public class DuplicateBookIdException extends SQLIntegrityConstraintViolationException{

	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return "BookId already exists";
	}
	
}
