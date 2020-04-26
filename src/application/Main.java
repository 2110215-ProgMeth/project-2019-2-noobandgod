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

public class Main extends Application {

	@Override
	public void start(Stage primaryStage) {
		String[][] gamemap = CSVParser.readCSV("Book1.csv"); //don't delete this line please
		
		GameController.InitializeMap(gamemap);
		SimulationManager.initializeAllPane();
		
		
		HBox mainWindow = new HBox(10);
		mainWindow.setPadding(new Insets(10));
		
	
		
		VBox boxleft = new VBox(10);
		
		Canvas testCanvas = new Canvas(640,512);
		GraphicsContext gc = testCanvas.getGraphicsContext2D();
		gc.setFill(Color.BLUEVIOLET);
		gc.fillRect(0, 0, gc.getCanvas().getWidth(), gc.getCanvas().getHeight());
		
		
		StackPane pane2 = new StackPane();
		pane2.setMaxHeight(108); pane2.setMaxWidth(640);
		Canvas testCanvas3 = new Canvas(640,108);
		GraphicsContext gc3 = testCanvas3.getGraphicsContext2D();
		gc3.setFill(Color.AQUAMARINE);
		gc3.fillRect(0, 0, gc3.getCanvas().getWidth(), gc3.getCanvas().getHeight());
		pane2.getChildren().add(testCanvas3);
		
		
		
		StackPane pane = new StackPane();
		Canvas testCanvas2 = new Canvas(640,100);
		GraphicsContext gc2 = testCanvas2.getGraphicsContext2D();
		gc2.setFill(Color.YELLOW);
		gc2.fillRect(0, 0, gc2.getCanvas().getWidth(), gc2.getCanvas().getHeight());
		
		pane.getChildren().addAll(testCanvas2,SimulationManager.getDataPane());
		
		
		boxleft.getChildren().addAll(pane2,testCanvas,pane);
		
		
		mainWindow.getChildren().addAll(boxleft,SimulationManager.getShopPane());
		
		
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
