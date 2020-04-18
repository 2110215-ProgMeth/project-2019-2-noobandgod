package entity;

import entity.base.Entity;
import entity.base.Interactable;
import logic.Sprites;

public class DishPicker extends Entity implements Interactable{
	private DishPicker DishPicker;
	public boolean interacts(Player e) {
		//dont forget to throw an exception
		if (!e.isHolding()) {
			Dish dish = new Dish();
			e.setDishHeld(dish);
			e.setHolding(true);
			return true;
		}return false;
	}
	public char getSymbol() {
		return Sprites.DishPicker;
	}
}
