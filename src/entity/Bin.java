package entity;

import entity.base.Consumable;
import entity.base.Entity;
import entity.base.Interactable;
import logic.Sprites;

public class Bin extends Entity implements Consumable,Interactable{
	public boolean interacts(Player e) {
		return e.isHolding();
	}
	public boolean consumes(Player e) {
		if (interacts(e)) {
			e.setIngredientHeld(null);
			e.setHolding(false);
			return true;
		}return false;//throw an exception;
	}
	public char getSymbol() {
		return Sprites.Bin;
	}
}
