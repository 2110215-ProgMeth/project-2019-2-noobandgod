package application;

import gui.IngredientShopBox;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Main extends Application {

	@Override
	public void start(Stage primaryStage) {
		IngredientShopBox tomatoBox = new IngredientShopBox("Tomato");
		
		Scene scene = new Scene(tomatoBox,200,200);
		
		primaryStage.setResizable(false); //Unable to resize!
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
