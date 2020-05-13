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
	public boolean interacts(Player e) throws InteractFailedException{
		if (e.isHolding()) {
			if(e.getEntityHeld() instanceof Dish) {
				return GameController.getOrderManager().sendOrder(e);
			}throw new InteractFailedException("The carried menu isn't is in the list");
		}throw new  InteractFailedException("There is nothing to be delivered");
	}
	
	@Override
	public char getSymbol() {
		// TODO Auto-generated method stub
		return Sprites.FoodCounter;
	}
	
	@Override
	public int getZ() {
		return getY()*3;
	}
	
	@Override
	public void draw(GraphicsContext gc) {
		int pixel = GameScreen.pixel;
		int x = GameScreen.draw_origin_x+this.getX()*pixel;
		int y = GameScreen.draw_origin_y+this.getY()*pixel;
		
		if(!isAnyBlockDownward) {
			gc.drawImage(RenderableHolder.foodcounter_infront_Image, x, y-6,64,70);
		} else {
			gc.drawImage(RenderableHolder.foodcounter_between_Image, x, y-6);
		}
	}
	
	@Override
	public boolean isVisible() {
		return true;
	}
}
