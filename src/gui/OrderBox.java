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
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import logic.GameController;
import meal.Menu;
import screen.GameScreen;
import sharedObject.RenderableHolder;

public class OrderBox extends Canvas{
	private Canvas orderCanvas;
	private GraphicsContext ordergc;

	public OrderBox(Menu menu) {
		
		//orderCanvas = new Canvas(80,96);
		ordergc = this.getGraphicsContext2D();
		ordergc.setFill(Color.RED);
		ordergc.setLineWidth(2);
		
		this.setHeight(160);
		this.setWidth(160);
		
		//Font font = Font.font("Times New Roman", FontWeight.LIGHT, 16);
		//ordergc.setFont(font);
		//ordergc.fillText("Simple Salad",16,12);
		if (menu.getName().equals("Simple Salad")) {
			ordergc.fillText("Simple Salad",50,12);
			drawProgressBar(3);
			this.setWidth(67);
		}else if (menu.getName().equals("Sashimi Salad")) {
			
			this.setWidth(160);
			ordergc.fillText("Sashimi Salad",30,10);
			drawProgressBar(menu.getTimeleft());
			ordergc.drawImage(menu.getMenuImage(),0,20);
			
		}else { //fried fish
			
			this.setWidth(160);
			ordergc.fillText("Fried Fish",this.getWidth()/2-30,10);
			drawProgressBar(5);
			
		}
		
	}
	
	public void drawProgressBar(int maxTime) {
		final long startNanoTime = System.nanoTime();
		final double max_width = this.getWidth();
		final int max_height = 8;
		
		int x = 0;
		int y = (int) this.getHeight() - 8;
		
		AnimationTimer animationTimer = new AnimationTimer() {
			double width;
			@Override
			public void handle(long currentNanoTime) {
				double t = ((currentNanoTime - startNanoTime) / 1000000000.0);
				width =  max_width*(1 -(t/maxTime));
				
				ordergc.clearRect(x, y, max_width, max_height);
				ordergc.setLineWidth(1);				
				ordergc.setFill(Color.WHITE);

				
				//System.out.println(width <= 0.67*max_width);
				if (width >= 0.67*max_width) {
					ordergc.setStroke(Color.GREEN);
					ordergc.setFill(Color.LIMEGREEN);
				}else if (width < 0.67*max_width && width >= 0.33*max_width){
					ordergc.setStroke(Color.ORANGE);
					ordergc.setFill(Color.ORANGE);
				}else {
					ordergc.setStroke(Color.RED);
					ordergc.setFill(Color.RED);
				}
				ordergc.strokeRect(x, y, max_width, max_height);
				ordergc.fillRect(x, y, width, max_height);
				
				if (t >= maxTime) {
					//ordergc.clearRect(0,0, max_width+1,max_height+1);
					//ordergc.clearRect(50, 12, max_width, max_height+);
					this.stop();
				}
			}
		};
		animationTimer.start();
	}
	
}
