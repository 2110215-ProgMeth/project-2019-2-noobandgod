package entity;

import javafx.scene.canvas.GraphicsContext;
import screen.GameScreen;
import sharedObject.RenderableHolder;

public class Cabbage extends Ingredient{
	public static final int price = 10;
	
	public Cabbage() {
		setState(0);
		setPlaced(false);
	}
	
	public int getZ() {
		return y*3+2;
	}
	
	public void draw(GraphicsContext gc) {
		int pixel = GameScreen.pixel;
		int X = GameScreen.draw_origin_x+x*pixel;
		int Y = GameScreen.draw_origin_y+y*pixel;
		
		if(!isPlaced) {
			if(getState() == 0) {
				gc.drawImage(RenderableHolder.cabbage_Image, X, Y-46,64,40);
			}else if (getState() ==1) {//cabbage state1
				gc.drawImage(RenderableHolder.cabbage_sliced_Image, X, Y-40,64,40);
			}
		}
	}
	
	@Override
	public boolean isVisible() {
		return !isDestroyed;
	}
}
