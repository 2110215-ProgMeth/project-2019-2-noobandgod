package entity;

import exception.InteractFailedException;
import logic.Sprites;

public class FishStorage extends IngredientStorage{
	public boolean interacts(Player e)throws InteractFailedException {
		if(!e.isHolding()) {
			Fish fish = new Fish();
			e.setEntityHeld(fish);
			e.setHolding(true);
			return true;
		}throw new InteractFailedException("Please place donw the carried item before picking up new fish");//throw exception like Ingredient
	}
	public char getSymbol() {
		return Sprites.FishStorage;
	}
}
