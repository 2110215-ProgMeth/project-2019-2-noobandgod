package entity;

import entity.base.Entity;
import javafx.scene.canvas.GraphicsContext;
import screen.GameScreen;
import sharedObject.RenderableHolder;

public class Fish extends Ingredient{
	private static int price = 30;
	
	public Fish() {
		setState(0);
	}
	public static int getPrice() {
		return price;
	}

	public String toString() {
		String result = "FISH";
		return result;
	}

	public int getZ() {
		return getY() * 3 + 2;
	}

	public void draw(GraphicsContext gc) {
		int pixel = GameScreen.pixel;
		int x = GameScreen.draw_origin_x + this.getX() * pixel;
		int y = (GameScreen.draw_origin_y - 30) + this.getY() * pixel;

		gc.drawImage(RenderableHolder.dish_ontable_empty_Image, x, y);//still not finish

	}

	@Override
	public boolean isVisible() {
		return !isDestroyed();
	}
}
