package application;

import gui.IngredientStorageBox;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main2 extends Application {

	@Override
	public void start(Stage primaryStage) {
		IngredientStorageBox storage = new IngredientStorageBox("Fish");
		Scene scene = new Scene(storage);
		primaryStage.setScene(scene);
		primaryStage.setResizable(false);
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
