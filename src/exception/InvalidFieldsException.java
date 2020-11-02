package exception;

public class InvalidFieldsException extends Exception{
	String invalidFields;

	public InvalidFieldsException(String invalidFields) {
		super();
		this.invalidFields = invalidFields;
	}

	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return "Invalid Fields: "+invalidFields;
	}
	
}
