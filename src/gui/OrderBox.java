package gui;

import javafx.animation.AnimationTimer;
import javafx.geometry.Pos;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import logic.GameController;
import screen.GameScreen;

public class OrderBox extends VBox {
	private Pane foodPic;
	private Canvas progressBar;
	private Label menuName;
	
	public OrderBox(int typeMenu) {
		super();
		this.setPrefHeight(64);
		this.setPrefWidth(80);
		this.setSpacing(16);
		this.setAlignment(Pos.CENTER);
		
		getMenuName(typeMenu);
		
		this.foodPic = new Pane();
		foodPic.setPrefHeight(64);
		foodPic.setPrefWidth(24);
		
		progressBar = new Canvas();
		
		if (typeMenu==1) {//simple salad
			progressBar.prefHeight(16);
			progressBar.prefWidth(48);
			drawProgressBar(GameScreen.gamegc,3);
			
			
		}else if (typeMenu==2) {//sashimi salad
			progressBar.prefHeight(16);
			progressBar.prefWidth(64);
			drawProgressBar(GameScreen.gamegc,3);
			
		}else {//fried fish
			progressBar.prefHeight(16);
			progressBar.prefWidth(32);
			drawProgressBar(GameScreen.gamegc,1);
			
		}
		
		
		
	
		
		this.getChildren().addAll(menuName,foodPic,progressBar);
	}
	
	public void drawProgressBar(GraphicsContext gc, int maxTime) {
		final long startNanoTime = System.nanoTime();
		
//		int pixel = GameScreen.pixel;
//		int x = GameScreen.draw_origin_x+this.getX()*pixel;
//		int y = GameScreen.draw_origin_y+this.getY()*pixel-14;
		
		AnimationTimer animationTimer = new AnimationTimer() {
			double width;
			@Override
			public void handle(long currentNanoTime) {
				double t = ((currentNanoTime - startNanoTime) / 1000000000.0);
				width = progressBar.getWidth() -(t/maxTime)*progressBar.getWidth();
				
				gc.clearRect(0, 0, progressBar.getWidth(), progressBar.getHeight());
				
				gc.setStroke(Color.GREEN);
				gc.setLineWidth(1);
				
				gc.setFill(Color.WHITE);
				gc.fillRect(0, 0, progressBar.getWidth() , progressBar.getHeight());
				gc.strokeRect(0, 0, progressBar.getWidth(),progressBar.getHeight());
				
				if (width >= 2/3*progressBar.getWidth()) {
					gc.setFill(Color.LIMEGREEN);
				}else if (width < 2/3*progressBar.getWidth() && width >= 1/3*progressBar.getWidth()){
					gc.setFill(Color.YELLOW);
				}else {
					gc.setFill(Color.RED);
				}
				gc.fillRect(0, 0, width, progressBar.getHeight());
				
				if (width >= progressBar.getWidth()) {
					gc.clearRect(0,0, progressBar.getWidth()+0.1,progressBar.getHeight());
					this.stop();
				}
			}
		};
		animationTimer.start();
	}
		

	public void getMenuName(int typeMenu) {
		if (typeMenu == 1) {
			menuName = new Label("Simple Salad");
		}else if (typeMenu == 2) {
			menuName = new Label("Sashimi Salad");
		}else if (typeMenu ==3) {
			menuName = new Label("Fried Fish");
		}
		menuName.setPrefHeight(16);
		menuName.setPrefWidth(64);
	}
	
	
}
