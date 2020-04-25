package application;

import gui.IngredientStoragePane;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main2 extends Application {

	@Override
	public void start(Stage primaryStage) {
		IngredientStoragePane a = new IngredientStoragePane(new String[]{"Tomato","Cabbage","Fish"});
		Scene scene = new Scene(a);
		primaryStage.setScene(scene);
		primaryStage.setResizable(false);
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
