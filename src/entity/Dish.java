package entity;

import java.util.ArrayList;

import entity.base.Entity;
import entity.base.Holdable;
import entity.base.Interactable;

public class Dish extends Entity implements Holdable{
	private ArrayList<Ingredient> onDishExists;
	public Dish() {
		this.onDishExists = new ArrayList<Ingredient>();
	}
	public boolean holds(Player e) {
		if (!e.isHolding()) {
			e.setDishHeld(this);
			e.setHolding(true);
			return true;
			//dont forget that I haven't written about the station where the ingredeintn lost
		}return false;
	}
	public boolean gathers(Player e) {
		if (e.isHolding()) {
			if ((!e.getIngredientHeld().equals(null)) && e.getIngredientHeld().getState() >= 1) {
				if (!this.onDishExists.contains(e.getIngredientHeld())){
					this.onDishExists.add(e.getIngredientHeld());
					e.setIngredientHeld(null);
					e.setHolding(false);
					return true;
			}//throw an exception a lot in this method
		}	//dont forget that I haven't written about the station where the ingredient lost
		}	return false;
	
	}
	public ArrayList<Ingredient> getOnDishExists() {
		return this.onDishExists;
	}
	public char getSymbol() {
		return Sprites.Dish;
	}
}