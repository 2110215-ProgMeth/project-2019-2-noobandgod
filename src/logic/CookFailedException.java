package logic;

public class CookFailedException extends Exception{
public String message;
	
	public CookFailedException(String message) {
		setMessage(message);
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
