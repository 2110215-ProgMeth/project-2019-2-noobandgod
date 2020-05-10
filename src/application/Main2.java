package application;


import javafx.application.Application;
import javafx.stage.Stage;
import screen.StartScreen;
import sharedObject.AudioLoader;

public class Main2 extends Application {
	@Override
	public void start(Stage primaryStage) {
		
		StartScreen start = new StartScreen(primaryStage);
		primaryStage.show();
		System.out.println(AudioLoader.BUTTON_CLICK.toString());

	}

	public static void main(String[] args) {
		launch(args);
	}

}

