package entity;

import javafx.scene.canvas.GraphicsContext;
import screen.GameScreen;
import sharedObject.RenderableHolder;

public class Tomato extends Ingredient{
	private static int price = 20;
	
	public Tomato() {
		setState(0);
		setPlaced(false);
	}
	
	public static int getPrice() {
		return price;
	}
	public String toString() {
		String result = "TOMATO";
		return result;
	}

	public int getZ() {
		return getY() * 3 + 2;
	}

	public void draw(GraphicsContext gc) {
		int pixel = GameScreen.pixel;
		int x = GameScreen.draw_origin_x + this.getX() * pixel;
		int y = GameScreen.draw_origin_y + this.getY() * pixel;

		if(!isPlaced) {
			if (getState() == 0) {
				gc.drawImage(RenderableHolder.tomato_Image, x, y-50);
			}else if (getState() == 1) {
				gc.drawImage(RenderableHolder.tomato_sliced_Image, x+10, y-40);
			}
		}

	}

	@Override
	public boolean isVisible() {
		return !isDestroyed();
	}
}
