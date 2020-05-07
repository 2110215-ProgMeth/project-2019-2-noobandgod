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
import meal.OrderManager;
import screen.GameScreen;
import sharedObject.RenderableHolder;

public class OrderBox extends Canvas{
	private static GraphicsContext ordergc;
	private static boolean isSend;
	

	public OrderBox(Menu menu,int orderNumber) {
		this.isSend= false;
		//orderCanvas = new Canvas(80,96);
		ordergc = this.getGraphicsContext2D();
		ordergc.setFill(Color.RED);
		ordergc.setLineWidth(2);
		
		this.setHeight(192);
		this.setWidth(160);
		
		Font font = Font.font(16);
		ordergc.setFont(font);
	
		if (menu.getName().equals("Simple Salad")) {
			ordergc.fillText("Simple Salad",50,12);
			drawProgressBar(3,menu);
			this.setWidth(67);
		}else if (menu.getName().equals("Sashimi Salad")) {
			
			this.setWidth(160);
			
			ordergc.fillText("Sashimi Salad",30,13);
			drawProgressBar(menu.getTimeleft(),menu);
			ordergc.drawImage(menu.getMenuImage(),0,20,155,145);
			
		}else { //fried fish
			
			this.setWidth(160);
			ordergc.fillText("Fried Fish",this.getWidth()/2-30,10);
			drawProgressBar(5,menu);
			
		}
	}
	
	public boolean isSend() {
		return isSend;
	}
	public void drawProgressBar(int maxTime,Menu menu) {
		final long startNanoTime = System.nanoTime();
		final double max_width = this.getWidth();
		final int max_height = 16;
		
		int x = 0;
		int y = (int) this.getHeight() - 18;
		
		AnimationTimer animationTimer = new AnimationTimer() {
			double width;
			@Override
			public void handle(long currentNanoTime) {
				double t = ((currentNanoTime - startNanoTime) / 1000000000.0);
				width =  max_width*(1 -(t/maxTime));
				
				ordergc.clearRect(x, y, max_width, max_height);
				ordergc.setLineWidth(1);				
				ordergc.setFill(Color.WHITE);
				
				
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
				
				int time = (int) t;
				menu.setTimeleft(maxTime - time);
				ordergc.setFill(Color.BLACK);
				ordergc.fillText(""+(maxTime - time), x+getWidth()/2-8, y+12);
				if (t >= maxTime || isSend) {
					ordergc.clearRect(0,0, 160+1,192+1);
					OrderManager.updateOrderNumber();
					this.stop();
				}
			}
		};
		animationTimer.start();
	}
	public static void sendOrder(Menu menu) {
		ordergc.clearRect(0,0, 160+1,192+1);
		isSend= true;
	}
	
}
