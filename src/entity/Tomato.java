package entity;

import javafx.scene.canvas.GraphicsContext;
import screen.GameScreen;
import sharedObject.RenderableHolder;

public class Tomato extends Ingredient{
	public static final int price = 20;
	
	public Tomato() {
		setState(0);
		setPlaced(false);
	}
	
	public int getZ() {
		return y * 3 + 2;
	}

	public void draw(GraphicsContext gc) {
		int pixel = GameScreen.pixel;
		int X = GameScreen.draw_origin_x + x * pixel;
		int Y = GameScreen.draw_origin_y + y * pixel;

		if(!isPlaced) {
			if (getState() == 0) {
				gc.drawImage(RenderableHolder.tomato_Image, X, Y-50);
			}else if (getState() == 1) {
				gc.drawImage(RenderableHolder.tomato_sliced_Image, X+10, Y-40);
			}
		}

	}

	@Override
	public boolean isVisible() {
		return !isDestroyed;
	}
}
