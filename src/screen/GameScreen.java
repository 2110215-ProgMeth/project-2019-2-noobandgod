package screen;

import application.CSVParser;
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
import javafx.scene.text.Font;
import javafx.stage.Stage;
import logic.GameController;
import meal.OrderManager;
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
	
	public static int gametime;
	
	public GameScreen(Stage primaryStage) {
		this.primaryStage = primaryStage;
		//---------------------------------------------------
		//Initialzing map and system
		String[][] map_1 = CSVParser.readCSV("map_1.csv"); //don't delete this line please
		String[][] map_2 = CSVParser.readCSV("map_2.csv");
		
		GameController.InitializeGame(2, map_1);
		SimulationManager.initializeAllPane();
		
		draw_origin_x = 48;
		draw_origin_y = 24;
		pixel = 64;
		//---------------------------------------------------
		HBox root = new HBox(4);
		root.setPadding(new Insets(4));
		

		VBox leftBox = new VBox(4);
		
		this.gameCanvas = new Canvas(800,496);
		gamegc = gameCanvas.getGraphicsContext2D();
		
		
		StackPane orderPane = new StackPane();
		orderPane.setPrefWidth(800);
		orderPane.setPrefHeight(192);
		
		Canvas orderCanvas = new Canvas(800,192);
		GraphicsContext orderbg = orderCanvas.getGraphicsContext2D();
		orderbg.drawImage(RenderableHolder.orderpane_bg_Image, 0, 0, orderbg.getCanvas().getWidth(), orderbg.getCanvas().getHeight());;
		
		orderPane.getChildren().addAll(orderCanvas,SimulationManager.getOrderPane());
		
		leftBox.getChildren().addAll(orderPane,gameCanvas, SimulationManager.getDataPane());
		//---------------------------------------------------
		VBox rightBox = new VBox(4);
		
		Canvas timeCanvas = new Canvas(190,192);
		timegc = timeCanvas.getGraphicsContext2D();
		gametime = GameController.MAX_TIME;
		
		final long startNanoTime = System.nanoTime();
		AnimationTimer timer = new AnimationTimer() {
			public void handle(long currentNanoTime) {
				double t = ((currentNanoTime - startNanoTime) / 1000000000.0);
				gametime = (int) (GameController.MAX_TIME - t);
				drawTime();
				OrderManager.addMenu();
				System.out.println(GameController.getSuccessDish()+"  "+GameController.getFailedDish());
				if(gametime <= 0) {
					GameController.setIsTimeUp(true);
					gametime--;
					this.stop();
				}
			}
		};
		
		rightBox.getChildren().addAll(timeCanvas,SimulationManager.getShopPane());
		//---------------------------------------------------
		root.getChildren().addAll(leftBox,rightBox);
		root.setAlignment(Pos.CENTER);
		
		
		Scene scene = new Scene(root);
		
		addListener(scene, gamegc);
		AnimationTimer animationTimer = new AnimationTimer() {
			public void handle(long arg0) {
				//===========================================
				RenderableHolder.getInstance().update();
				paintGameScreenComponent();
				InputUtility.removeKeyPressed();
				//===========================================
				SimulationManager.updatePane();
				//GameController.getOrderManager().printTimeLeftOfEachMenu();
				
				if(GameController.is_timeup) {
					System.out.println("TIME UP");
					this.stop();
				}
				
				//RenderableHolder.show();
				
			}
		};
		
		timer.start();
		animationTimer.start();
		
		
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
				gamegc.drawImage(RenderableHolder.floor_Image,draw_origin_x+(j)*pixel,draw_origin_y+(i)*pixel);
			}
		}
		
		//background
		gamegc.drawImage(RenderableHolder.gamescreen_bg_Image,0,0,gameCanvas.getWidth(),gameCanvas.getHeight());
	
		//allblock and entity!!
		for(IRenderable entity: RenderableHolder.getInstance().getEntities()) {
			entity.draw(gamegc);
		}
	}
	
	public void drawTime() {
		timegc.clearRect(0, 0, timegc.getCanvas().getWidth(), timegc.getCanvas().getHeight()); //don't remove
		timegc.drawImage(RenderableHolder.timebox_bg_Image, 0, 0, timegc.getCanvas().getWidth(), timegc.getCanvas().getHeight());
		timegc.setFont(new Font(30));
		timegc.setFill(Color.WHITE);
		
		if (100 <= gametime && gametime <= 999) {
			timegc.fillText(Integer.toString(gametime), 68, 158);
		} else if (10 <= gametime && gametime <= 99) {
			timegc.fillText(Integer.toString(gametime), 76, 158);
		} else if (0 <= gametime && gametime <= 9){
			timegc.setFill(Color.PINK);
			timegc.fillText(Integer.toString(gametime), 84, 158);
		}
	}
}
