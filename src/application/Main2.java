package application;

import gui.IngredientStoragePane;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import screen.StartScreen;

public class Main2 extends Application {

	@Override
	public void start(Stage primaryStage) {
//		StartScreen start = new StartScreen();
//		Scene scene = new Scene(start);
//		scene.setFill(Color.RED);
//		primaryStage.setScene(scene);
//		primaryStage.setResizable(false);
//		primaryStage.show();
		Canvas canvas = new Canvas(800, 400);
		GraphicsContext gc = canvas.getGraphicsContext2D();
		primaryStage.getChildren().add(canvas);
	}

	public static void main(String[] args) {
		launch(args);
	}
}
