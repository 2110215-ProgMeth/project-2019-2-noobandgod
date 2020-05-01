package entity;

import java.util.ArrayList;

import entity.base.Entity;
import entity.base.Holdable;
import entity.base.Interactable;

public class Dish extends Entity {//implements Holdable{
	private ArrayList<Ingredient> onDishExists;
	public Dish() {
		this.onDishExists = new ArrayList<Ingredient>();
	}
//	public boolean holds(Player e) {
//		if (!e.isHolding()) {
//			e.setDishHeld(this);
//			e.setHolding(true);
//			return true;
//			//don't forget that I haven't written about the station where the ingredient lost
//		}return false;
//	}
	public boolean gathers(Player e) { // when the station has a dish and people carry an ingredient
		if (e.isHolding()) {
			if (e.getEntityHeld() instanceof Ingredient ) {
				Ingredient ingredient = (Ingredient) e.getEntityHeld();
				if (ingredient.getState() >= 1) {
					if (!this.onDishExists.contains(ingredient)){
						this.onDishExists.add(ingredient);
						e.setEntityHeld(null);
						e.setHolding(false);
						return true;
					}//throw an exception a lot in this method
				}
			}
		}return false;
	}
	public void adds(Ingredient e) {
		if (e instanceof Fish) {
			Fish fish = (Fish) e;
			this.onDishExists.add(fish);
		}else if (e instanceof Cabbage) {
			Cabbage cabbage = (Cabbage) e;
			this.onDishExists.add(cabbage);
		}else if (e instanceof Tomato) {
			Tomato tomato = (Tomato) e;
			this.onDishExists.add(tomato);
		}
	}
	public ArrayList<Ingredient> getOnDishExists() {
		return this.onDishExists;
	}
}