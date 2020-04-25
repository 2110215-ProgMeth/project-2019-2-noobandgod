package Exception;

public class ConsumeFailedException extends Exception{
public String message;
	
	public ConsumeFailedException(String message) {
		setMessage(message);
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
