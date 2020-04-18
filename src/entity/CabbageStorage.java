package entity;

import entity.base.Entity;
import logic.Sprites;

public class CabbageStorage extends IngredientStorage{
	private CabbageStorage CabbageStorage;
	public boolean interacts(Player e) {
		if(!e.isHolding()) {
			Cabbage cabbage = new Cabbage();
			e.setIngredientHeld(cabbage);
			e.setHolding(true);
			return true;
		}return false;//throw exception like Ingredient
	}
	public char getSymbol() {
		return Sprites.CabbageStorage;
	}
}
