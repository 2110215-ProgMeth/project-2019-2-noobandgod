package entity;

import entity.base.Entity;

public class Fish extends Ingredient{
	private static int price = 30;
	
	public Fish() {
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
		return Sprites.Fish;
	}
	public static int getPrice() {
		return price;
	}
}
