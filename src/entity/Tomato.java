package entity;

import entity.base.Entity;
import javafx.scene.canvas.GraphicsContext;
import screen.GameScreen;
import sharedObject.RenderableHolder;

public class Tomato extends Ingredient{
	private static int price = 20;
	
	public Tomato() {
		setState(0);
	}
	public char getSymbol() {
		return Sprites.Tomato;
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
			}
		}

	}

	@Override
	public boolean isVisible() {
		return !isDestroyed();
	}
}
