package entity;

import entity.base.Consumable;
import entity.base.Entity;
import entity.base.Interactable;
import exception.ConsumeFailedException;
import logic.Sprites;

public class Bin extends Entity implements Consumable,Interactable{
	public boolean interacts(Player e) {
		return e.isHolding();
	}
	public boolean consumes(Player e) throws ConsumeFailedException{
		if (interacts(e)) {
			e.setIngredientHeld(null);
			e.setDishHeld(null);
			e.setHolding(false);
			return true;
		}else{
			throw new ConsumeFailedException("There is nothing to be cast");//throw an exception; nothing to be consumed
		}
	}
	public char getSymbol() {
		return Sprites.Bin;
	}
}
