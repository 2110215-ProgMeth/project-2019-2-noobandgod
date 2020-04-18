package entity;

import entity.base.Entity;

public class Cabbage extends Ingredient{
	public Cabbage() {
		setState(0);
	}
//	public boolean holds(Player e) {
//		if (!e.isHolding()) {
//			e.setIngredientHeld(this);
//			e.setHolding(true);
//			return true;
//			//dont forget that I haven't written about the station where the ingredeintn lost
//		}return false;//I should throw an exception that we can't hold because we are holding
//	}
	public char getSymbol() {
		return Sprites.Cabbage;
	}
	
}
