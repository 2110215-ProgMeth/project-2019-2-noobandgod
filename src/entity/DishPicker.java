package entity;

import entity.base.Block;
import entity.base.Entity;
import entity.base.Interactable;
import exception.InteractFailedException;
import logic.Sprites;

public class DishPicker extends Block implements Interactable{
	public boolean interacts(Player e) throws InteractFailedException{
		//dont forget to throw an exception
		if (!e.isHolding()) {
			Dish dish = new Dish();
			e.setDishHeld(dish);
			e.setHolding(true);
			return true;
		}throw new InteractFailedException("Please place donw the carried item before picking up a new dish");
	}
	public char getSymbol() {
		return Sprites.DishPicker;
	}
}
