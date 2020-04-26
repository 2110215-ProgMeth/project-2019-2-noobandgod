package application;


import gui.DataPane;
import gui.IngredientShopBox;
import gui.IngredientStorageBox;
import gui.ShopPane;
import gui.SimulationManager;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import logic.GameController;
import screen.GameScreen;

public class Main extends Application {

	@Override
	public void start(Stage primaryStage) {
		GameScreen gameScreen = new GameScreen(primaryStage);
		
		primaryStage.setResizable(false); //Unable to resize!
		primaryStage.setTitle("Umm Aroiii");
		primaryStage.show();
		
		
	}

	public static void main(String[] args) {
		launch(args);
	}
}
