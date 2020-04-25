package entity;

import Exception.InteractFailedException;
import logic.Sprites;

public class CabbageStorage extends IngredientStorage {
	public boolean interacts(Player e) throws InteractFailedException{
		if (!e.isHolding()) {
			Cabbage cabbage = new Cabbage();
			e.setIngredientHeld(cabbage);
			e.setHolding(true);
			return true;
		}else{
			throw new InteractFailedException("Please place donw the carried item before picking up a new caabbage");
		}
	}
	public char getSymbol() {
		return Sprites.CabbageStorage;
	}
}
