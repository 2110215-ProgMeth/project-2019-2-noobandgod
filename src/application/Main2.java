package application;

import gui.IngredientStoragePane;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import screen.StartScreen;

public class Main2 extends Application {

	@Override
	public void start(Stage primaryStage) {
		StartScreen start = new StartScreen();
		Scene scene = new Scene(start);
		scene.setFill(Color.RED);
		
		primaryStage.setScene(scene);
		
		primaryStage.setResizable(false);
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
