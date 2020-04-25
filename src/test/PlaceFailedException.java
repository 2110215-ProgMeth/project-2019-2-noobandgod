package test;

public class PlaceFailedException extends Exception{
public String message;
	
	public PlaceFailedException(String message) {
		setMessage(message);
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
