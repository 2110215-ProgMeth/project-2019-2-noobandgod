package sharedObject;


import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class Song {
	public static boolean isPlaying = true ;
	private  MediaPlayer mediaPlayer ;
	private int music ;
	private String url ;
	public Song(int music)  {
		// TODO Auto-generated constructor stub
		this.music = music ;
		switch (music) {
		case 1: url = "StartScreen.mp3";
			break ;
		case 2: url = "GameScreen.mp3";
			break ;
		case 3: url = "EndScreen.mp3";
			break ;
		default:
			url = "StartScreen.mp3";
		}
		if(ClassLoader.getSystemResource(url) == null ) {
			mediaPlayer = new MediaPlayer(new Media("file:res/audio/"+url));
		}
		else {
			String songPath = ClassLoader.getSystemResource(url).toString();
			mediaPlayer = new MediaPlayer(new Media(songPath));
		}
		mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
		mediaPlayer.setVolume(0.3);
	}
	public void playSong() {
		mediaPlayer.play();
	}
	public void stopSong() {
		mediaPlayer.stop();
	}

}
