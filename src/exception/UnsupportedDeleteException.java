package exception;

import java.sql.SQLIntegrityConstraintViolationException;

public class UnsupportedDeleteException extends SQLIntegrityConstraintViolationException{

	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return "Unsupported Delete: Record linked to Transaction table.";
	}
	
}
