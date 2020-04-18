package entity;

import logic.Sprites;

public class FishStorage extends IngredientStorage{
	public boolean interacts(Player e) {
		if(!e.isHolding()) {
			Fish fish = new Fish();
			e.setIngredientHeld(fish);
			e.setHolding(true);
			return true;
		}return false;//throw exception like Ingredient
	}
	public char getSymbol() {
		return Sprites.FishStorage;
	}
}
