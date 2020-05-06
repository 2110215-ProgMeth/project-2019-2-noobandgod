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
import screen.GameScreen;

public class OrderBox extends Canvas{
	private Canvas orderCanvas;
	private GraphicsContext ordergc;
	public OrderBox(int typeMenu) {
		
		orderCanvas = new Canvas(80,96);
		ordergc = orderCanvas.getGraphicsContext2D();
//		if (typeMenu == 1) {//simple salad
//			drawProgressBar(ordergc,3);
//			drawOrderPicture(ordergc,1);
//			
//		}else if (typeMenu==2) {//sashimi salad
//			drawProgressBar(ordergc,4);
//			drawOrderPicture(ordergc,2);
//		}else {				//fried fish
//			drawProgressBar(ordergc,2);
//			drawOrderPicture(ordergc,3);
//		}
//		this.getMenuName(typeMenu);
		
	}
	
	public void drawProgressBar(GraphicsContext gc, int maxTime) {
		final long startNanoTime = System.nanoTime();
		final int max_width = maxTime*16;
		final int max_height = 16;
		AnimationTimer animationTimer = new AnimationTimer() {
			double width;
			@Override
			public void handle(long currentNanoTime) {
				double t = ((currentNanoTime - startNanoTime) / 1000000000.0);
				width = max_width*(1 -(t/maxTime));
				
				gc.clearRect(0, 112, max_width, max_height);
				
				gc.setStroke(Color.GREEN);
				gc.setLineWidth(1);
				
				gc.setFill(Color.WHITE);
				gc.fillRect(0,112, max_width, max_height);
				gc.strokeRect(0, 112, max_width, max_height);
				
				if (width >= 2/3*max_width) {
					gc.setFill(Color.LIMEGREEN);
				}else if (width < 2/3*max_width && width >= 1/3*max_width){
					gc.setFill(Color.YELLOW);
				}else {
					gc.setFill(Color.RED);
				}
				gc.fillRect(0, 112, width, max_height);
				
				if (width >= max_width) {
					gc.clearRect(0,0, max_width,max_height);
					this.stop();
				}
			}
		};
		animationTimer.start();
	}
	public void drawOrderPicture(GraphicsContext gc,int type) {
		if (type == 1) {
			
		}else if (type ==2) {
			
		}else {
			
		}
	}

	public void getMenuName(int typeMenu) {
		ordergc.setFill(Color.BLUE);
		ordergc.setLineWidth(2);
		Font menu = Font.font("Times New Roman", FontWeight.LIGHT, 16);
		ordergc.setFont(menu);
		if (typeMenu == 1) {
			ordergc.fillText("Simple Salad",16,12);
		}else if (typeMenu == 2) {
			ordergc.fillText("Sashimi Salad",16,12);
		}else if (typeMenu ==3) {
			ordergc.fillText("Fried Fish",16,12);
		}
	}
	
	
}
