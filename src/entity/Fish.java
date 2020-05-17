package entity;

import javafx.scene.canvas.GraphicsContext;
import screen.GameScreen;
import sharedObject.RenderableHolder;

public class Fish extends Ingredient{
	public static final int price = 30;
	
	public Fish() {
		setState(0);
		setPlaced(false);
	}
	
	public int getZ() {
		return y*3+2;
	}

	public void draw(GraphicsContext gc) {
		int pixel = GameScreen.pixel;
		int X = GameScreen.draw_origin_x + x * pixel;
		int Y = GameScreen.draw_origin_y + y * pixel;

		if(!isPlaced) {
			if (getState() == 0) {
				gc.drawImage(RenderableHolder.fish_Image, X, Y-34);
			}else if (getState() == 1) {
				gc.drawImage(RenderableHolder.fish_sliced_Image, X+15, Y-35,32,30);
			} else if (getState() == 2) {
				gc.drawImage(RenderableHolder.fish_fried_Image, X+8, Y-37);
			}
		}
	}

	@Override
	public boolean isVisible() {
		return !isDestroyed;
	}
}
