package entity;

import entity.base.Consumable;
import entity.base.Entity;
import entity.base.Interactable;
import logic.Sprites;

public class FoodCounter extends Entity implements Interactable,Consumable{
	
	public int check() {
		
	}
	@Override
	public boolean interacts(Player e) {
		// TODO Auto-generated method stub
		if (e.isHolding()) {
			if(!e.getDishHeld().equals(null));
		}
		return false;
	}
	@Override
	public char getSymbol() {
		// TODO Auto-generated method stub
		return Sprites.FoodCounter;
	}

}
