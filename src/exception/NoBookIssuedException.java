package exception;

public class NoBookIssuedException extends Exception{

	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return "No book has been issued to this User.";
	}
	
}
