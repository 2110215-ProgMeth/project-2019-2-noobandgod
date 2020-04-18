package entity;

import entity.base.Entity;

public class FishStorage extends IngredientStorage{
	private FishStorage FishStorage;
	public boolean interacts(Player e) {
		if(!e.isHolding()) {
			Fish fish = new Fish();
			e.setIngredientHeld(fish);
			e.setHolding(true);
			return true;
		}return false;//throw exception like Ingredient
	}
	public Entity getSymbol() {
		return FishStorage;
	}
}
