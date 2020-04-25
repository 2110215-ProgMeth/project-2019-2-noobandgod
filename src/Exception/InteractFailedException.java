package Exception;

public class InteractFailedException  extends Exception{
public String message;
	
	public InteractFailedException(String message) {
		setMessage(message);
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
