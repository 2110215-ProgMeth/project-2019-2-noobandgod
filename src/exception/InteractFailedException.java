package exception;

import sharedObject.AudioLoader;

public class InteractFailedException extends Exception{
	public String message;
	
	public InteractFailedException(String message) {
		setMessage(message);
	}

	public void setMessage(String message) {
		this.message = message;
	}
	public void playSound() {
		AudioLoader.ERROR.play();
	}
}
