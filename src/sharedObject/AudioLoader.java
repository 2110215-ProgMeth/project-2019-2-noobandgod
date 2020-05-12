package sharedObject;

import javafx.scene.media.AudioClip;

public class AudioLoader {
	public static  AudioClip Almost_Time_Up = new AudioClip(ClassLoader.getSystemResource("sound/almostTimeUp.wav").toString());
	public static AudioClip BUTTON_CLICK = new AudioClip(ClassLoader.getSystemResource("sound/buttonclick.mp3").toString());
	public static AudioClip LOSE = new AudioClip(ClassLoader.getSystemResource("sound/lose.mp3").toString());
	public static AudioClip ERROR = new AudioClip(ClassLoader.getSystemResource("sound/error.mp3").toString());
	public static AudioClip CONGRAT = new AudioClip(ClassLoader.getSystemResource("sound/congratulation.mp3").toString());
	public static AudioClip SUCCESS_SEND = new AudioClip(ClassLoader.getSystemResource("sound/SuccessSend.mp3").toString());
	public static AudioClip Start_Screen = new AudioClip(ClassLoader.getSystemResource("sound/StartScreen.mp3").toString());
	public static AudioClip Game_Screen = new AudioClip(ClassLoader.getSystemResource("sound/GameScreen.mp3").toString());
	public static AudioClip End_Screen = new AudioClip(ClassLoader.getSystemResource("sound/EndScreen.mp3").toString());
}