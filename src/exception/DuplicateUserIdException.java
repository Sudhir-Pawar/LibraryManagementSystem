package exception;

import java.sql.SQLIntegrityConstraintViolationException;

public class DuplicateUserIdException extends SQLIntegrityConstraintViolationException{
	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return "UserId already exists";
	}
}
