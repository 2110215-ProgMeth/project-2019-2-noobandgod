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
			}else {
				if (getOnStationExists() instanceof Dish) {
					Dish dish = (Dish) OnStationExists;
					e.setHolding(true);
					e.setDishHeld(dish);
					return true;
				}else if ()
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
