package sharedObject;

import javafx.scene.media.AudioClip;

public class AudioLoader {
	public static final AudioClip Almost_Time_Up = new AudioClip(ClassLoader.getSystemResource("sound/almostTimeUp.wav").toString());
	public static final AudioClip BUTTON_CLICK = new AudioClip(ClassLoader.getSystemResource("sound/buttonclick.mp3").toString());
	public static final AudioClip DIED = new AudioClip(ClassLoader.getSystemResource("sound/lose.mp3").toString());
	public static final AudioClip ERRORR = new AudioClip(ClassLoader.getSystemResource("sound/rror.mp3").toString());
	public static final AudioClip CONGRAT = new AudioClip(ClassLoader.getSystemResource("sound/congratulation.mp3").toString());
	public static final AudioClip SUCCESS_SEND = new AudioClip(ClassLoader.getSystemResource("sound/SuccessSend.mp3").toString());
//	
//	public static final Song START_SONG = new Song(1);
//	public static final Song GAME_SONG = new Song(2);
//	public static final Song END_SONG = new Song(3);
	
	public static final AudioClip END = new AudioClip(ClassLoader.getSystemResource("sound/EndScreen.mp3").toString());
	
}