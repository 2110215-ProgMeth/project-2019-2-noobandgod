package screen;

import application.CSVParser;
import gui.DataPane2;
import gui.OrderPane;
import gui.SimulationManager;
import input.InputUtility;
import javafx.animation.AnimationTimer;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import logic.GameController;
import sharedObject.IRenderable;
import sharedObject.RenderableHolder;
import logic.Direction;

public class GameScreen {
	private Stage primaryStage;
	private Canvas gameCanvas;
	public static GraphicsContext gamegc;
	public static GraphicsContext timegc;
	
	public static int draw_origin_x;
	public static int draw_origin_y; 
	public static int pixel;
	
	private static String image_path = ClassLoader.getSystemResource("picture/floortest1.png").toString();
	private static Image floortest = new Image(image_path);
	
	public GameScreen(Stage primaryStage) {
		this.primaryStage = primaryStage;
		//---------------------------------------------------
		//Initialzing map and system
		String[][] gamemap = CSVParser.readCSV("Book1.csv"); //don't delete this line please
		GameController.InitializeGame(2, gamemap);
		SimulationManager.initializeAllPane();
		
		draw_origin_x = 48;
		draw_origin_y = 48;
		pixel = 64;
		//---------------------------------------------------
		
		
		HBox root = new HBox(8);
		root.setPadding(new Insets(8));
		

		VBox leftBox = new VBox(4);
		
		

		//Canvas orderCanvas = new Canvas(768,128);
		//GraphicsContext ordergc = orderCanvas.getGraphicsContext2D();
		//ordergc.setFill(Color.LIMEGREEN);
		//ordergc.fillRect(0, 0, ordergc.getCanvas().getWidth(), ordergc.getCanvas().getHeight());
		
		this.gameCanvas = new Canvas(800,544);
		this.gamegc = gameCanvas.getGraphicsContext2D();
		//initialize grey background
		//gamegc.setFill(Color.GRAY);
		//gamegc.fillRect(0, 0, gamegc.getCanvas().getWidth(), gamegc.getCanvas().getHeight());
		
		//RenderableHolder.show();
		
		//StackPane pane = new StackPane();
		//Canvas testCanvas2 = new Canvas(800,96);
		//GraphicsContext gc2 = testCanvas2.getGraphicsContext2D();
		//gc2.setFill(Color.YELLOW);
		//gc2.fillRect(0, 0, gc2.getCanvas().getWidth(), gc2.getCanvas().getHeight());
		//pane.getChildren().addAll(testCanvas2,SimulationManager.getDataPane());
		
		leftBox.getChildren().addAll(SimulationManager.getOrderPane(),gameCanvas, new DataPane2());
		//leftBox.getChildren().addAll(SimulationManager.getOrderPane(),gameCanvas,pane);
		
		//---------------------------------------------------
		VBox rightBox = new VBox(8);
		
		Canvas timeCanvas = new Canvas(190,128);
		timegc = timeCanvas.getGraphicsContext2D();
		timegc.drawImage(RenderableHolder.timebox_bg_Image, 0, 0, timegc.getCanvas().getWidth(), timegc.getCanvas().getHeight());
		
		
		rightBox.getChildren().addAll(timeCanvas,SimulationManager.getShopPane());
		//---------------------------------------------------
		root.getChildren().addAll(leftBox,rightBox);
		root.setAlignment(Pos.CENTER);
		
		
		Scene scene = new Scene(root);
		
		addListener(scene, gamegc);
		AnimationTimer animationTimer = new AnimationTimer() {
			public void handle(long arg0) {
				//fulfill background
				gamegc.setFill(Color.GRAY);
				gamegc.fillRect(0, 0, gamegc.getCanvas().getWidth(), gamegc.getCanvas().getHeight());
				
				RenderableHolder.getInstance().update();
				paintGameScreenComponent();
				InputUtility.removeKeyPressed();
				
				//RenderableHolder.show();
				
			}
		};animationTimer.start();
		
		
		this.primaryStage = primaryStage;
		this.primaryStage.setScene(scene);
		
		
	}
	
	private void addListener(Scene s, GraphicsContext gc) {
		s.setOnKeyPressed((KeyEvent e) -> {
			InputUtility.setKeyPressed(e.getCode(), true);
		});
		
		s.setOnKeyReleased((KeyEvent e) -> {
			InputUtility.setKeyPressed(e.getCode(), false);
		});
	}
	
	public void paintGameScreenComponent() {
		int width = GameController.getCurrentGameMap().getWidth();
		int height = GameController.getCurrentGameMap().getHeight();
		
		//floor
		for (int i=0; i < height; i++) {
			for (int j=0; j < width; j++) {
				gamegc.drawImage(floortest,draw_origin_x+(j)*pixel,draw_origin_y+(i)*pixel);
			}
		}
		
		for(IRenderable entity: RenderableHolder.getInstance().getEntities()) {
			entity.draw(gamegc);
		}
		
	}
	
	
}
