package entity;

import exception.InteractFailedException;
import javafx.scene.canvas.GraphicsContext;
import logic.GameController;
import logic.Sprites;
import screen.GameScreen;
import sharedObject.RenderableHolder;

public class CabbageStorage extends IngredientStorage {
	
	public boolean interacts(Player p) throws InteractFailedException{
		if (!isAvailable) {
			throw new InteractFailedException("CABBAGE is out of stock!");
		}	
		if (!p.isHolding()) {
			p.setEntityHeld(new Cabbage());
			GameController.addCabbage_AMOUNT(-1);
			return true;
		} else {
			throw new InteractFailedException("ERROR");
		}
	}
	
	public char getSymbol() {
		return Sprites.CabbageStorage;
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
		
		if(!isAnyBlockDownward) {
			gc.drawImage(RenderableHolder.cabbagestorage_infront_Image, X, Y);
		} else {
			gc.drawImage(RenderableHolder.cabbagestorage_between_Image, X, Y);
		}
		
	}
	@Override
	public boolean isVisible() {
		return true;
	}

	@Override
	public void update() {
		setAmount(GameController.Cabbage_AMOUNT);
		
		if (amount <= 0) {
			setAvailable(false);
		} else {
			setAvailable(true);
		}
	}
}
