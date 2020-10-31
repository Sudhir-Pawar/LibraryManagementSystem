package exception;

import java.sql.SQLIntegrityConstraintViolationException;

public class UserIdNotFoundException extends SQLIntegrityConstraintViolationException{
	String UserId;

	public UserIdNotFoundException(String userId) {
		super();
		UserId = userId;
	}

	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return "UserId: "+UserId+" not found";
	}
	
}
