package entity;


import javafx.scene.canvas.GraphicsContext;
import logic.GameController;
import logic.Sprites;
import screen.GameScreen;
import sharedObject.RenderableHolder;

public class FishStorage extends IngredientStorage{
	public boolean interacts(Player e) {//throws InteractFailedException {
		if (!isAvailable) {
			System.out.println("FISH is out of stock!");
			return false;
		}
		if(!e.isHolding()) {
			Fish fish = new Fish();
			e.setEntityHeld(fish);
			e.setHolding(true);
			GameController.addFish_AMOUNT(-1);
			return true;
		}//System.out.println("Please place down the carried item before picking up a new fish");
		return false;
	}
	public char getSymbol() {
		return Sprites.FishStorage;
	}
	public String toString() {
		String result = "FISHTORAGE";
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
			gc.drawImage(RenderableHolder.fishstorage_infront_Image, x, y);
		} else {
			gc.drawImage(RenderableHolder.fishstorage_between_Image, x, y-6);
		}
		
	}
	@Override
	public boolean isVisible() {
		return true;
	}

	@Override
	public void update() {
		setAmount(GameController.Fish_AMOUNT);
		
		if (amount <= 0) {
			setAvailable(false);
		} else {
			setAvailable(true);
		}
	}
}
