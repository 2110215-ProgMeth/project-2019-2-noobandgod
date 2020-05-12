package application;


import javafx.application.Application;
import javafx.stage.Stage;
import screen.StartScreen;
import sharedObject.AudioLoader;

public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {	
		StartScreen start = new StartScreen(primaryStage);
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}

}

