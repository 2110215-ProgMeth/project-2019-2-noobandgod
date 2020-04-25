package Exception;

public class SendFoodFailedException extends Exception{
public String message;
	
	public SendFoodFailedException(String message) {
		setMessage(message);
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
