package entity;

import entity.base.Entity;
import entity.base.Holdable;
import entity.base.Placeable;
import logic.Sprites;

public class Station extends Entity implements Holdable,Placeable{
	private Entity OnStationExists = null;
	public boolean holds(Player e) {
		if (!e.isHolding()) {
			if (getOnStationExists().equals(null)) {
				//throw an exception
				return false;
			}else {
				if (getOnStationExists() instanceof Dish) {
					Dish dish = (Dish) getOnStationExists();
					e.setHolding(true);
					e.setDishHeld(dish);
					return true;
				}else if (getOnStationExists() instanceof Ingredient) {
					e.setHolding(true);
					if (getOnStationExists() instanceof Fish) {
						Fish fish = (Fish) getOnStationExists();
						e.setIngredientHeld(fish);
						return true;
					}else if (getOnStationExists() instanceof Cabbage) {
						Cabbage cabbage = (Cabbage) getOnStationExists();
						e.setIngredientHeld(cabbage);
						return true;
					}else if (getOnStationExists() instanceof Tomato) {
						Tomato tomato = (Tomato) getOnStationExists();
						e.setIngredientHeld(tomato);
						return true;
					}
				}
			}
		}return false;//throw an exception
	}
	public boolean places(Player e) {
		if (e.isHolding()) {
			if (getOnStationExists().equals(null)) {
				if (!e.getDishHeld().equals(null)) {
					setOnStationExists(e.getDishHeld());
					e.setDishHeld(null);
					e.setHolding(false);
					return true;
				}else {
					setOnStationExists(e.getIngredientHeld());
					e.setIngredientHeld(null);
					e.setHolding(false);
					return true;
				}
			}else {
				if (getOnStationExists() instanceof Dish) {
					if (!e.getDishHeld().equals(null)) {
						return false;
						//throw an exception.. dish and dish
					}else {
						//dish on station and ingredient on hand
						Dish dish = (Dish) getOnStationExists();
						dish.gathers(e);
						return true;
					}
				}else if (getOnStationExists() instanceof Ingredient) {
					if (!e.getIngredientHeld().equals(null)) {
						return false;
						//throw an exception.. ingredient and ingredient
					}else {
						//ingredient on station and dish on hand
						Ingredient ingredient = (Ingredient) getOnStationExists();
						e.setDishHeld(e.getDishHeld().adds(ingredient));
						setOnStationExists(null);
						return true;
						//not finished
						}
					}
				}
			}
		}
	public Entity getOnStationExists() {
		return OnStationExists;
	}
	public void setOnStationExists(Entity onStationExists) {
		OnStationExists = onStationExists;
	}
	public char getSymbol() {
		return Sprites.Station;
	}
}
