package entity;

import entity.base.Entity;
import javafx.scene.canvas.GraphicsContext;
import screen.GameScreen;
import sharedObject.RenderableHolder;

public class Cabbage extends Ingredient{
	private static int price = 10;
	public Cabbage() {
		setState(0);
		setPlaced(false);
	}

	public static int getPrice() {
		return price;
	}
	public String toString() {
		String result = "CABBAGE";
		result += "\nLocated at ("+this.getX()+","+this.getY()+")";
		result += "\nisPlacedonTable? " + this.isPlaced;
		result += "\nstate: "+this.getState();
		return result;
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
				//gc.drawImage(RenderableHolder.cabbage_Image, x, y-46,64,40);
				
			}
		}
		
	}
	@Override
	public boolean isVisible() {
		return !isDestroyed();
	}
	
	
}
