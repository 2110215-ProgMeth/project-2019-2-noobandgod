package entity;

import entity.base.Block;
import entity.base.Interactable;
import exception.InteractFailedException;
import javafx.scene.canvas.GraphicsContext;
import logic.GameController;
import logic.Sprites;
import screen.GameScreen;
import sharedObject.RenderableHolder;

public class FoodCounter extends Block implements Interactable{

	@Override
	public boolean interacts(Player p) throws InteractFailedException{
		if (p.isHolding()) {
			if(p.getEntityHeld() instanceof Dish) {
				return GameController.getOrderManager().sendOrder(p);
			}throw new InteractFailedException("The carried menu isn't in the list");
		}throw new  InteractFailedException("There is nothing to be delivered");
	}
	
	@Override
	public char getSymbol() {
		return Sprites.FoodCounter;
	}
	
	@Override
	public int getZ() {
		return y*3;
	}
	
	@Override
	public void draw(GraphicsContext gc) {
		int pixel = GameScreen.pixel;
		int X = GameScreen.draw_origin_x+x*pixel;
		int Y = GameScreen.draw_origin_y+y*pixel;
		
		if(!isAnyBlockDownward) {
			gc.drawImage(RenderableHolder.foodcounter_infront_Image, X, Y-6,64,70);
		} else {
			gc.drawImage(RenderableHolder.foodcounter_between_Image, X, Y-6);
		}
	}
	
	@Override
	public boolean isVisible() {
		return true;
	}
}
