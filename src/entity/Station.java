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
					Dish dish = (Dish) OnStationExists;
					e.setHolding(true);
					e.setDishHeld(dish);
					return true;
				}else if (getOnStationExists() instanceof Ingredient) {
					e.setHolding(true);
					if (getOnStationExists() instanceof Fish) {
						Fish fish = (Fish) OnStationExists;
						e.setIngredientHeld(fish);
						return true;
					}else if (getOnStationExists() instanceof Cabbage) {
						Cabbage cabbage = (Cabbage) OnStationExists;
						e.setIngredientHeld(cabbage);
						return true;
					}else if (getOnStationExists() instanceof Tomato) {
						Tomato tomato = (Tomato) OnStationExists;
						e.setIngredientHeld(tomato);
						return true;
					}
				}
			}
		}return false;
	}
	public boolean places(Player e) {
		
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
