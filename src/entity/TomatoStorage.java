package entity;

import exception.InteractFailedException;
import logic.Sprites;

public class TomatoStorage extends IngredientStorage{
	public boolean interacts(Player e) throws InteractFailedException{
		if (!e.isHolding()) {
			Tomato tomato = new Tomato();
			e.setIngredientHeld(tomato);
			e.setHolding(true);
			return true;
		}throw new InteractFailedException("Please place down the carried item before picking up a new caabbage//throw an exception");
	}
	public char getSymbol() {
		return Sprites.TomatoStorage;
	}
}
