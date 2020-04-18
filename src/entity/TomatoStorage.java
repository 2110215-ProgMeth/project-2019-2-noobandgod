package entity;

import entity.base.Entity;

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
	public Entity getSymbol() {
		return TomatoStorage;
	}
}
