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
		return getY()*3+2;
	}

	public void draw(GraphicsContext gc) {
		int pixel = GameScreen.pixel;
		int x = GameScreen.draw_origin_x + this.getX() * pixel;
		int y = GameScreen.draw_origin_y + this.getY() * pixel;

		if(!isPlaced) {
			if (getState() == 0) {
				gc.drawImage(RenderableHolder.fish_Image, x, y-34);
			}else if (getState() == 1) {
				gc.drawImage(RenderableHolder.fish_sliced_Image, x+15, y-35,32,30);
			} else if (getState() == 2) {
				gc.drawImage(RenderableHolder.fish_fried_Image, x+8, y-37);
			}
		}

	}

	@Override
	public boolean isVisible() {
		return !isDestroyed();
	}
}
