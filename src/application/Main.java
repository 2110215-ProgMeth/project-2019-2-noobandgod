package application;

import gui.DataPane;
import gui.IngredientShopBox;
import gui.ShopPane;
import gui.SimulationManager;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import logic.GameController;

public class Main extends Application {

	@Override
	public void start(Stage primaryStage) {
		String[][] gamemap = CSVParser.readCSV("Book1.csv"); //don't delete this line please
		
		
		String[] ingredients = new String[]{"Tomato","Cabbage","Fish"};
		
		GameController.InitializeMap(gamemap);
		SimulationManager.initializeAllPane();
		
		
		//GameController.InitializeShopPane(ingredients);
		
		HBox mainWindow = new HBox();
		mainWindow.setPadding(new Insets(10));
		
		Pane pane = new StackPane();
		pane.setPrefHeight(600);
		pane.setPrefWidth(500);
		
		DataPane dataPane = new DataPane();
		pane.getChildren().addAll(dataPane);
		
		
		mainWindow.getChildren().addAll(pane,SimulationManager.getShopPane());
		
		
		Scene scene = new Scene(mainWindow);
		
		
		
		
		
		
		
		
		primaryStage.setResizable(false); //Unable to resize!
		primaryStage.setTitle("Umm Aroiii");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
