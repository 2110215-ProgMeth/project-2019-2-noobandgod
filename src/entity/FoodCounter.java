package entity;

import entity.base.Block;
import entity.base.Consumable;
import entity.base.Entity;
import entity.base.Interactable;
import exception.InteractFailedException;
import exception.SendFoodFailedException;
import logic.GameController;
import logic.Sprites;
import meal.OrderManager;

public class FoodCounter extends Block implements Interactable{

	@Override
	public boolean interacts(Player e) throws SendFoodFailedException,InteractFailedException{
		// TODO Auto-generated method stub
		if (e.isHolding()) {
			if(e.getEntityHeld() instanceof Dish) {
				return GameController.getOrderManager().sendOrder(e);
			}throw new SendFoodFailedException("The carried menu isn't is in the list");
		}throw new InteractFailedException("There is nothing to be delivered");
	}
	@Override
	public char getSymbol() {
		// TODO Auto-generated method stub
		return Sprites.FoodCounter;
	}

}
