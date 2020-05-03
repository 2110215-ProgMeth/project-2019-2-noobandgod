package entity;

import exception.InteractFailedException;
import javafx.scene.canvas.GraphicsContext;
import logic.GameController;
import logic.Sprites;
import screen.GameScreen;
import sharedObject.RenderableHolder;

public class TomatoStorage extends IngredientStorage{
	public boolean interacts(Player e) {//throws InteractFailedException{
		if (!isAvailable) {
			System.out.println("TOMATO is out of stock");
			return false;
		}
		if (!e.isHolding()) {
			Tomato tomato = new Tomato();
			e.setEntityHeld(tomato);
			e.setHolding(true);
			GameController.addTomato_AMOUNT(-1);
			return true;
		}System.out.println("Please place down the carried item before picking up a new Tomato");
		return false;
	}
	public char getSymbol() {
		return Sprites.TomatoStorage;
	}
	public String toString() {
		String result = "TOMATOSTORAGE";
		result += "\nLocated at ("+this.getX()+","+this.getY()+")";
		result += "\nStock: "+getAmount();
		result += "\nisAvailable: "+isAvailable;
		return result;
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
		
		if(!isAnyBlockDownward) {
			gc.drawImage(RenderableHolder.cabbagestorage_infront_Image, x, y);//not finish
		} else {
			gc.drawImage(RenderableHolder.cabbagestorage_between_Image, x, y);//not finish
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
