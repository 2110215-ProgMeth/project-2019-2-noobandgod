package test;

public class HoldFailedException extends Exception{
public String message;
	
	public HoldFailedException(String message) {
		setMessage(message);
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
