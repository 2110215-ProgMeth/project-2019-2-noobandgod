package application;

import gui.IngredientShopBox;
import gui.ShopPane;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import logic.GameController;

public class Main extends Application {

	@Override
	public void start(Stage primaryStage) {
		String[][] gamemap = CSVParser.readCSV("Book1.csv"); //don't delete this line please
		
		
		String[] ingredients = new String[]{"Tomato","Cabbage","Fish"};
		
		GameController.InitializeShopPane(ingredients);
	
		Scene scene = new Scene(GameController.getShopPane(),256,600);
		
		
		
		
		
		
		
		
		primaryStage.setResizable(false); //Unable to resize!
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
