package entity;

import entity.base.Entity;

public class Tomato extends Ingredient{
	private static int price = 20;
	
	public Tomato() {
		setState(0);
	}
//	public boolean holds(Player e) {
//		if (!e.isHolding()) {
//			e.setIngredientHeld(this);
//			e.setHolding(true);
//			return true;
//		}	//dont forget that I haven't written about the station where the ingredient lost
//		return false;//I should throw an exception that we can't hold because we are holding
//	}
	public char getSymbol() {
		return Sprites.Tomato;
	}
	public static int getPrice() {
		return price;
	}
}
