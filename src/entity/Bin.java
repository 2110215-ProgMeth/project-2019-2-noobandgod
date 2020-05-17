package entity;

import entity.base.Block;

import entity.base.Entity;
import entity.base.Interactable;
import exception.InteractFailedException;
import javafx.scene.canvas.GraphicsContext;
import logic.Sprites;
import screen.GameScreen;
import sharedObject.RenderableHolder;

public class Bin extends Block implements Interactable{			
	
	public boolean interacts(Player p) throws InteractFailedException{
		if (p.isHolding()) {
			//if player holding something, remove holding entity (throws it into bin)
			Entity entity = p.removeEntityHeld();
			return true; 
		}else{
			throw new InteractFailedException("ERROR");
		}
	}
	
	public char getSymbol() {
		return Sprites.Bin;
	}
	
	@Override
	public int getZ() {
		return y*3;
	}
	
	@Override
	public void draw(GraphicsContext gc) {
		int pixel = GameScreen.pixel;
		int X = GameScreen.draw_origin_x+x*pixel;
		int Y = (GameScreen.draw_origin_y-6)+y*pixel;
		
		if(isAnyBlockDownward) {
			gc.drawImage(RenderableHolder.bin_between_Image, X, Y);
		} else {
			gc.drawImage(RenderableHolder.bin_infront_Image, X, Y);
		}
		
	}
	
	@Override
	public boolean isVisible() {
		return true;
	}
	
	public String toString() {
		String result = "BIN";
		result += "\nLocated at ("+x+","+y+")";
		return result;
	}
}
