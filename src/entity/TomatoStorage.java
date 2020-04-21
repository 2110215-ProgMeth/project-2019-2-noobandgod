package entity;

import logic.Sprites;

public class TomatoStorage extends IngredientStorage{
	public boolean interacts(Player e) {
		if (!e.isHolding()) {
			Tomato tomato = new Tomato();
			e.setIngredientHeld(tomato);
			e.setHolding(true);
			return true;
		}return false;//throw an exception
	}
	public char getSymbol() {
		return Sprites.TomatoStorage;
	}
}
