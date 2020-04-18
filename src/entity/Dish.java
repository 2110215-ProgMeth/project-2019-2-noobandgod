package entity;

import java.util.ArrayList;

import entity.base.Entity;
import entity.base.Holdable;
import entity.base.Interactable;

public class Dish extends Entity implements Holdable,Interactable{
	private Dish Dish;
	private ArrayList<Ingredient> onDishExists;
	public Dish() {
		this.onDishExists = new ArrayList<Ingredient>();
	}
	public boolean holds(Player e) {
		if (!e.isHolding()) {
			e.setDishHeld(Dish);
			e.setHolding(true);
			return true;
			//dont forget that I haven't written about the station where the ingredeintn lost
		}return false;
	}
	public boolean interacts(Player e) {
		if (e.isHolding()) {
			if (e.getIngredientHeld().getState() >= 1) {
				if (!this.onDishExists.contains(e.getIngredientHeld())){
					onDishExists.add(e.getIngredientHeld());
					return true;
			}//throw an exception a lot in this method
		}	//dont forget that I haven't written about the station where the ingredient lost
		}	return false;
	
	}
	public ArrayList<Ingredient> getOnDishExists() {
		return onDishExists;
	}
	public Dish getSymbol() {
		return Dish;
	}
}