package exception;

public class InvalidIngredientNameException extends Exception{
	public String message;
	
	public InvalidIngredientNameException(String message) {
		setMessage(message);
	}

	public void setMessage(String message) {
		this.message = message;
	}

	
}
