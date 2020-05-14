package exception;

public class RemoveOrderFailedException extends Exception{
	public String message;
	
	public RemoveOrderFailedException(String message) {
		setMessage(message);
	}
	
	public void printErrorMessage() {
		System.out.println(message);
	}
	
	public void setMessage(String message) {
		this.message = message;
	}
}
