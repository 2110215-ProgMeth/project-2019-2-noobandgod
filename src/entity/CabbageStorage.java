package entity;

import exception.InteractFailedException;
import javafx.scene.canvas.GraphicsContext;
import logic.GameController;
import logic.Sprites;
import screen.GameScreen;
import sharedObject.RenderableHolder;

public class CabbageStorage extends IngredientStorage {
	
	public boolean interacts(Player p) {
		if (!isAvailable) {
			System.out.println("CABBAGE is out of stock!");
			return false;
		}	
		if (!p.isHolding()) {
			p.setEntityHeld(new Cabbage());
			GameController.addCabbage_AMOUNT(-1);
			p.setHolding(true);
			System.out.println("Player "+p.getPlayerNumber()+" has pick Cabbage at "+this.getCoordinate());
			return true;
		} else {
			System.out.println("Please place down the carried item before picking up a new caabbage");
			return false;
			//throw new InteractFailedException("Please place donw the carried item before picking up a new caabbage");
		}
	}
	
	public char getSymbol() {
		return Sprites.CabbageStorage;
	}
	
	public String toString() {
		String result = "CABBAGESTORAGE";
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
			gc.drawImage(RenderableHolder.cabbagestorage_infront_Image, x, y);
		} else {
			gc.drawImage(RenderableHolder.cabbagestorage_between_Image, x, y);
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
