package entity;

import entity.base.Block;
import entity.base.Entity;
import entity.base.Holdable;
import entity.base.Placeable;
import exception.HoldFailedException;
import exception.PlaceFailedException;
import logic.Sprites;

public class Station extends Block implements Holdable,Placeable{
	private Entity OnStationExists = null;
	private int stationType; //0 or 1;
	
	public Station(int stationtype) {
		setOnStationExists(null);
		setStationType(stationtype);
	}
	
	public boolean holds(Player e) throws HoldFailedException{
		if (!e.isHolding()) {
			if (getOnStationExists().equals(null)) {
				//throw an exception
				throw new HoldFailedException("You can't hold nothing");
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
		}throw new HoldFailedException("You can't hold because you are holding something");
				//throw an exception
	}
	public boolean places(Player e) throws PlaceFailedException{
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
						throw new PlaceFailedException("You can't place a carried dish on a dish");
						//throw an exception.. dish and dish
					}else {
						//dish on station and ingredient on hand
						Dish dish = (Dish) getOnStationExists();
						dish.gathers(e);
						return true;
					}
				}else if (getOnStationExists() instanceof Ingredient) {
					if (!e.getIngredientHeld().equals(null)) {
						throw new PlaceFailedException("You can't place a carried ingredient on station beacuse there is an ingredient on it");
						//throw an exception.. ingredient and ingredient
					}else {
						//ingredient on station and dish on hand
						Ingredient ingredient = (Ingredient) getOnStationExists();
						e.getDishHeld().adds(ingredient);
						setOnStationExists(null);
						return true;
						//not finished
						}
					}
				}
			}throw new PlaceFailedException("There is nothing to be placed");
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

	public int getStationType() {
		return stationType;
	}

	public void setStationType(int stationType) {
		this.stationType = stationType;
	}
	
	
}
