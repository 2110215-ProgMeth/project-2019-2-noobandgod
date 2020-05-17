package entity;

import exception.InteractFailedException;
import javafx.scene.canvas.GraphicsContext;
import logic.GameController;
import logic.Sprites;
import screen.GameScreen;
import sharedObject.RenderableHolder;

public class TomatoStorage extends IngredientStorage{
	public boolean interacts(Player e) throws InteractFailedException{
		if (!isAvailable) {
			throw new InteractFailedException("ERROR");
		}
		if (!e.isHolding()) {
			Tomato tomato = new Tomato();
			e.setEntityHeld(tomato);
			e.setHolding(true);
			GameController.addTomato_AMOUNT(-1);
			return true;
		}throw new InteractFailedException("ERROR");
	}
	
	public char getSymbol() {
		return Sprites.TomatoStorage;
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
			gc.drawImage(RenderableHolder.tomatostorage_infront_Image, X, Y-6);
		} else {
			gc.drawImage(RenderableHolder.tomatostorage_between_Image, X, Y-6);
		}
	}
	
	@Override
	public boolean isVisible() {
		return true;
	}

	@Override
	public void update() {
		setAmount(GameController.Tomato_AMOUNT);
		
		if (amount <= 0) {
			setAvailable(false);
		} else {
			setAvailable(true);
		}
	}
}
