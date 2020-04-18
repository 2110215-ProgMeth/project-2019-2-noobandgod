package entity;

import logic.Sprites;

public class CabbageStorage extends IngredientStorage{
	public boolean interacts(Player e) {
		if (!e.isHolding()) {
			Cabbage cabbage = new Cabbage();
			e.setIngredientHeld(cabbage);
			e.setHolding(true);
			return true;
		}return false;
	}
	public char getSymbol() {
		return Sprites.CabbageStorage;
	}
}
