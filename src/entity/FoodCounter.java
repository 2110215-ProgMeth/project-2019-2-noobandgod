package entity;

import entity.base.Consumable;
import entity.base.Entity;
import entity.base.Interactable;
import logic.Sprites;
import meal.OrderManager;

public class FoodCounter extends Entity implements Interactable{

	@Override
	public boolean interacts(Player e) {
		// TODO Auto-generated method stub
		if (e.isHolding()) {
			if(!e.getDishHeld().equals(null)) {
				return GameController.getOrderManager.sendOrder(e);
			}
		}
		return false;
	}
	@Override
	public char getSymbol() {
		// TODO Auto-generated method stub
		return Sprites.FoodCounter;
	}

}
