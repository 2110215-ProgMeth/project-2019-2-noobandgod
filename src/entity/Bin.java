package entity;

import entity.base.Block;

import entity.base.Entity;
import entity.base.Interactable;
import exception.InteractFailedException;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import logic.Sprites;
import screen.GameScreen;
import sharedObject.RenderableHolder;

public class Bin extends Block implements Interactable{			
	
	public boolean interacts(Player e) throws InteractFailedException{
		if (e.isHolding()) {
			//if player holding something, remove holding entity (throws it into bin)
			Entity entity = e.removeEntityHeld();
			
			if(entity instanceof Dish) {
				System.out.println(((Dish) entity).toString()+" @("+entity.getX()+","+entity.getY()+") has been thrown off!");
			}
			return true; 
			
		}else{
			System.out.println("YOU ARE NOT HOLDING ANYTHING");
			throw new InteractFailedException("There is nothing to be cast");//throw an exception; nothing to be consumed
		}
	}
	public char getSymbol() {
		return Sprites.Bin;
	}
	@Override
	public int getZ() {
		return getY()*3;
	}
	@Override
	public void draw(GraphicsContext gc) {
		int pixel = GameScreen.pixel;
		int x = GameScreen.draw_origin_x+this.getX()*pixel;
		int y = (GameScreen.draw_origin_y-6)+this.getY()*pixel;
		
		if(isAnyBlockDownward) {
			gc.drawImage(RenderableHolder.bin_between_Image, x, y);
		} else {
			gc.drawImage(RenderableHolder.bin_infront_Image, x, y);
		}
		
	}
	@Override
	public boolean isVisible() {
		return true;
	}
	
	public String toString() {
		String result = "BIN";
		result += "\nLocated at ("+this.getX()+","+this.getY()+")";
		return result;
	}
}
