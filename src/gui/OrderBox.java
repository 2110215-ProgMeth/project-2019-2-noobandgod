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

public class OrderBox extends Canvas{
	private Canvas orderCanvas;
	private GraphicsContext ordergc;

	public OrderBox(Menu menu) {
		
		//orderCanvas = new Canvas(80,96);
		ordergc = this.getGraphicsContext2D();
		ordergc.setFill(Color.BLUE);
		ordergc.setLineWidth(2);
		Font font = Font.font("Times New Roman", FontWeight.LIGHT, 16);
		ordergc.setFont(font);
		ordergc.fillText("Simple Salad",16,12);
		if (menu.getName().equals("Simple Salad")) {
			ordergc.fillText("Simple Salad",16,12);
			drawProgressBar(3);
			drawOrderPicture(1);
		}else if (menu.getName().equals("Sahimi Salad")) {
			ordergc.fillText("Sashimi Salad",16,12);
			drawProgressBar(4);
			drawOrderPicture(2);
		}else {			//fried fish
			ordergc.fillText("Fried Fish",16,12);
			drawProgressBar(2);
			drawOrderPicture(3);
		}
		
	}
	
	public void drawProgressBar(int maxTime) {
		final long startNanoTime = System.nanoTime();
		final int max_width = maxTime*16;
		final int max_height = 16;
		AnimationTimer animationTimer = new AnimationTimer() {
			double width;
			@Override
			public void handle(long currentNanoTime) {
				double t = ((currentNanoTime - startNanoTime) / 1000000000.0);
				width = max_width*(1 -(t/maxTime));
				
				ordergc.clearRect(0, 112, max_width, max_height);
				
				ordergc.setStroke(Color.GREEN);
				ordergc.setLineWidth(1);
				
				ordergc.setFill(Color.WHITE);
				ordergc.fillRect(0,112, max_width, max_height);
				ordergc.strokeRect(0, 112, max_width, max_height);
				
				if (width >= 2/3*max_width) {
					ordergc.setFill(Color.LIMEGREEN);
				}else if (width < 2/3*max_width && width >= 1/3*max_width){
					ordergc.setFill(Color.YELLOW);
				}else {
					ordergc.setFill(Color.RED);
				}
				ordergc.fillRect(0, 112, width, max_height);
				
				if (width >= max_width) {
					ordergc.clearRect(0,0, max_width,max_height);
					this.stop();
				}
			}
		};
		animationTimer.start();
	}
	public void drawOrderPicture(int type) {
		if (type == 1) {
			
		}else if (type ==2) {
			
		}else {
			
		}
	}

	
}
