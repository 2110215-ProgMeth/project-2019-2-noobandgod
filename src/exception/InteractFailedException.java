package exception;

import sharedObject.AudioLoader;

public class InteractFailedException extends Exception{
	private String message;
	
	public InteractFailedException(String message) {
		setMessage(message);
	}

	public void playSound() {
		AudioLoader.ERROR.play();
	}
	
	public void setMessage(String message) {
		this.message = message;
	}
	
}
