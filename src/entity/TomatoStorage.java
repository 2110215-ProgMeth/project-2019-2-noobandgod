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
		return getY()*3;
	}
	@Override
	public void draw(GraphicsContext gc) {
		int pixel = GameScreen.pixel;
		int x = GameScreen.draw_origin_x+this.getX()*pixel;
		int y = GameScreen.draw_origin_y+this.getY()*pixel;
		
		if(!isAnyBlockDownward) {
			gc.drawImage(RenderableHolder.tomatostorage_infront_Image, x, y-6);
		} else {
			gc.drawImage(RenderableHolder.tomatostorage_between_Image, x, y-6);
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
