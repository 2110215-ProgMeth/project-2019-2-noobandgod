package application;

import gui.IngredientShopBox;
import gui.ShopPane;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Main extends Application {

	@Override
	public void start(Stage primaryStage) {
		String[] ingredientName = new String[]{"Tomato","Cabbage"};
		
		ShopPane shopPane = new ShopPane(ingredientName);
		
		Scene scene = new Scene(shopPane,256,600);
		
		primaryStage.setResizable(false); //Unable to resize!
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
