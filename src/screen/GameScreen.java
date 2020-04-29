package screen;

import application.CSVParser;
import gui.SimulationManager;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import logic.GameController;

public class GameScreen {
	private Stage primaryStage;
	
	public GameScreen(Stage primaryStage) {
		this.primaryStage = primaryStage;
		//---------------------------------------------------
		//Initialzing map and system
		String[][] gamemap = CSVParser.readCSV("Book1.csv"); //don't delete this line please
		GameController.InitializeMap(gamemap);
		SimulationManager.initializeAllPane();
		//---------------------------------------------------
		
		
		HBox root = new HBox(8);
		root.setPadding(new Insets(8));
		

		VBox leftBox = new VBox(8);
		
		Canvas orderCanvas = new Canvas(768,100);
		GraphicsContext ordergc = orderCanvas.getGraphicsContext2D();
		ordergc.setFill(Color.LIMEGREEN);
		ordergc.fillRect(0, 0, ordergc.getCanvas().getWidth(), ordergc.getCanvas().getHeight());
		
		
		Canvas gameCanvas = new Canvas(768,512);
		GraphicsContext gamegc = gameCanvas.getGraphicsContext2D();
		gamegc.setFill(Color.BLUEVIOLET);
		gamegc.fillRect(0, 0, gamegc.getCanvas().getWidth(), gamegc.getCanvas().getHeight());
		
	
		StackPane pane = new StackPane();
		Canvas testCanvas2 = new Canvas(768,100);
		GraphicsContext gc2 = testCanvas2.getGraphicsContext2D();
		gc2.setFill(Color.YELLOW);
		gc2.fillRect(0, 0, gc2.getCanvas().getWidth(), gc2.getCanvas().getHeight());
		pane.getChildren().addAll(testCanvas2,SimulationManager.getDataPane());
		
		
		leftBox.getChildren().addAll(orderCanvas,gameCanvas,pane);
		
		//---------------------------------------------------
		VBox rightBox = new VBox(8);
		
		Canvas timeCanvas = new Canvas(190,100);
		GraphicsContext timegc = timeCanvas.getGraphicsContext2D();
		timegc.setFill(Color.ORANGE);
		timegc.fillRect(0, 0, timegc.getCanvas().getWidth(), timegc.getCanvas().getHeight());
		
		
		rightBox.getChildren().addAll(timeCanvas,SimulationManager.getShopPane());
		//---------------------------------------------------
		root.getChildren().addAll(leftBox,rightBox);
		root.setAlignment(Pos.CENTER);
		
		Scene scene = new Scene(root);
		this.primaryStage = primaryStage;
		this.primaryStage.setScene(scene);
		
	}
	
	public void drawGameBoard(GraphicsContext gc) {
		
		
		
	}
}
