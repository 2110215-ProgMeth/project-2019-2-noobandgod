package input;

import java.util.ArrayList;

import javafx.scene.input.KeyCode;

public class InputUtility {
	private static ArrayList<KeyCode> keypressed = new ArrayList<KeyCode>();
	
	public static void setKeyPressed(KeyCode keyCode, boolean pressed) {
		if(pressed) {
			if(!keypressed.contains(keyCode)) {
				keypressed.add(keyCode);
			} else {
				keypressed.remove(keyCode);
			}
		}
		System.out.println(keypressed);
	}

	public static ArrayList<KeyCode> getKeypressed() {
		return keypressed;
	}
	
	public static void removeKeyPressed() {
		for (int i = keypressed.size()-1; i>=0; i--) {
			keypressed.remove(i);
		}
	}
	
	public static void removeSpecificKeyCode(KeyCode keyCode) {
		if (keypressed.contains(keyCode)) {
			keypressed.remove(keyCode);
		} 
	}
	
}
