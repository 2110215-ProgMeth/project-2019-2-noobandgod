package entity;

import entity.base.Entity;

public class Tomato extends Ingredient{
	private Tomato Tomato;
	public Tomato() {
		setState(0);
	}
	public boolean holds(Player e) {
		if (!e.isHolding()) {
			e.setIngredientHeld(Tomato);
			e.setHolding(true);
			return true;
		}	//dont forget that I haven't written about the station where the ingredient lost
		return false;//I should throw an exception that we can't hold because we are holding
	}
	public Entity getSymbol() {
		return Tomato;
	}
}
