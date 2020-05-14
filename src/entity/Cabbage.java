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
		return getY()*3+2;
	}
	
	public void draw(GraphicsContext gc) {
		int pixel = GameScreen.pixel;
		int x = GameScreen.draw_origin_x+this.getX()*pixel;
		int y = GameScreen.draw_origin_y+this.getY()*pixel;
		
		if(!isPlaced) {
			if(getState() == 0) {
				gc.drawImage(RenderableHolder.cabbage_Image, x, y-46,64,40);
			}else if (getState() ==1) {//cabbage state1
				gc.drawImage(RenderableHolder.cabbage_sliced_Image, x, y-40,64,40);
				
			}
		}
		
	}
	
	@Override
	public boolean isVisible() {
		return !isDestroyed();
	}
}
