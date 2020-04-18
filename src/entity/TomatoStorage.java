package entity;

import entity.base.Entity;
import logic.Sprites;

public class TomatoStorage extends IngredientStorage{
	private TomatoStorage TomatoStorage;
	public boolean interacts(Player e) {
		if(!e.isHolding()) {
			Tomato tomato = new Tomato();
			e.setIngredientHeld(tomato);
			e.setHolding(true);
			return true;
		}return false;//throw exception like Ingredient
	}
	public char getSymbol() {
		return Sprites.TomatoStorage;
	}
}
