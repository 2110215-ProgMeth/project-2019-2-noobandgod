package screen;

import application.CSVParser;
import gui.SimulationManager;
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
	private GraphicsContext gamegc;
	
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
		GameController.InitializeMap(gamemap);
		SimulationManager.initializeAllPane();
		
		draw_origin_x = 32;
		draw_origin_y = 32;
		pixel = 64;
		//---------------------------------------------------
		
		
		HBox root = new HBox(8);
		root.setPadding(new Insets(8));
		

		VBox leftBox = new VBox(8);
		
		Canvas orderCanvas = new Canvas(768,100);
		GraphicsContext ordergc = orderCanvas.getGraphicsContext2D();
		ordergc.setFill(Color.LIMEGREEN);
		ordergc.fillRect(0, 0, ordergc.getCanvas().getWidth(), ordergc.getCanvas().getHeight());
		
		
		this.gameCanvas = new Canvas(768,512);
		this.gamegc = gameCanvas.getGraphicsContext2D();
		gamegc.setFill(Color.GRAY);
		gamegc.fillRect(0, 0, gamegc.getCanvas().getWidth(), gamegc.getCanvas().getHeight());
		
		//drawGameBoard(gamegc);
		//drawGameBoard2(gamegc);
		InitializeGameGraphic();
		
		//RenderableHolder.show();
		
		
	
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
		
		addListener(scene, gamegc);
		
		AnimationTimer animationTimer = new AnimationTimer() {
			public void handle(long arg0) {
				RenderableHolder.getInstance().update();
				InitializeGameGraphic();
				
			}
		};animationTimer.start();
		
		
		this.primaryStage = primaryStage;
		this.primaryStage.setScene(scene);
		
		
	}
	
	private void addListener(Scene s, GraphicsContext gc) {
		s.setOnKeyPressed((KeyEvent e) -> {
			String code = e.getCode().toString();
			System.out.println(code);
			
			switch (code) {
			case "D":
				GameController.movePlayer(Direction.RIGHT,GameController.getPlayers(0));
				break;
			case "A":
				GameController.movePlayer(Direction.LEFT, GameController.getPlayers(0));
				break;
			case "S":
				GameController.movePlayer(Direction.DOWN, GameController.getPlayers(0));
				break;
			case "W":
				GameController.movePlayer(Direction.UP, GameController.getPlayers(0));
				break;
			}
		});
	}
	
	public void InitializeGameGraphic() {
		int width = GameController.getCurrentGameMap().getWidth();
		int height = GameController.getCurrentGameMap().getHeight();
		
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
