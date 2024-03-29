package gui;

import javafx.animation.AnimationTimer;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import meal.Menu;
import meal.OrderManager;
import screen.GameScreen;

public class OrderBox extends Canvas {
	private GraphicsContext ordergc;

	public OrderBox(Menu menu) {
		// orderCanvas = new Canvas(80,96);
		ordergc = this.getGraphicsContext2D();
		ordergc.setLineWidth(2);

		this.setHeight(192);
		
		Font font = Font.font(14);
		ordergc.setFont(font);
		
		
		if (menu.getName().equals("Simple Salad")) {
			this.setWidth(120);
			
			ordergc.setFill(Color.WHITE);
			ordergc.fillRect(0, 2, this.getWidth(), 14);
			
			ordergc.setFill(Color.BLACK);
			ordergc.fillText("Simple Salad", this.getWidth() / 2 - 40, 13);
			ordergc.drawImage(menu.getMenuImage(), 0, 20, 120, 145);
			
		} else if (menu.getName().equals("Sashimi Salad")) {
			this.setWidth(150);
			
			ordergc.setFill(Color.WHITE);
			ordergc.fillRect(0, 2, this.getWidth(), 14);
			
			ordergc.setFill(Color.BLACK);
			ordergc.fillText("Sashimi Salad", 30, 13);
			ordergc.drawImage(menu.getMenuImage(), 0, 20, 150, 145);

		} else { // fried fish
			this.setWidth(110);
			
			ordergc.setFill(Color.WHITE);
			ordergc.fillRect(0, 2, this.getWidth(), 14);
			
			ordergc.setFill(Color.BLACK);
			ordergc.fillText("Fried Fish", this.getWidth() / 2 - 30, 13);
			ordergc.drawImage(menu.getMenuImage(), 0, 20, 110, 145);

		}
		
		drawProgressBar(menu.getTimeMax(), menu, menu.getTimeLeft());
		
	}

	public void drawProgressBar(int maxTime, Menu menu, double TimeLeft) {
		final long startNanoTime = System.nanoTime();
		final double max_width = this.getWidth();
		final int max_height = 16;

		int x = 0;
		int y = (int) this.getHeight() - 18;
		AnimationTimer animationTimer = new AnimationTimer() {
			double width;

			@Override
			public void handle(long currentNanoTime) {
				double t = (currentNanoTime - startNanoTime) / 1000000000.0;
				width = max_width * ((TimeLeft - t) / maxTime);
				ordergc.clearRect(x, y, max_width, max_height);
				ordergc.setLineWidth(1);
				ordergc.setFill(Color.WHITE);

				if (width >= 0.67 * max_width) {
					ordergc.setStroke(Color.GREEN);
					ordergc.setFill(Color.LIMEGREEN);
				} else if (width < 0.67 * max_width && width >= 0.33 * max_width) {
					ordergc.setStroke(Color.ORANGE);
					ordergc.setFill(Color.ORANGE);
				} else {
					ordergc.setStroke(Color.RED);
					ordergc.setFill(Color.RED);
				}
				ordergc.strokeRect(x, y, max_width, max_height);
				ordergc.fillRect(x, y, width, max_height);

				double time = Math.round(t*10)/10.0;
				menu.setTimeLeft(TimeLeft - time);
				ordergc.setFill(Color.BLACK);
				ordergc.fillText("" + Math.round((TimeLeft - time)*10)/10.0, x + getWidth() / 2 - 8, y + 12);
				if (t >= TimeLeft || menu.isSend()) {
					this.stop();
					ordergc.clearRect(0, 0, 160 + 1, 192 + 1);
					OrderManager.updateOrderNumber();
				}
				if (GameScreen.gametime == 0) {
					ordergc.clearRect(0, 0, 160 + 1, 192 + 1);
					OrderManager.updateOrderNumber();
				}
			}
		};
		animationTimer.start();
	}

	public static void sendOrder(Menu menu) {
		menu.setSend(true);
	}

}
