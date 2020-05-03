package entity;

import entity.base.Entity;

public abstract class Ingredient extends Entity {
	protected int State;
	protected boolean isPlaced;

	public void setState(int state) {
		this.State = state;
	}
	public int getState() {
		return this.State;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Ingredient other = (Ingredient) obj;
		if (State != other.State)
			return false;
		return true;
	}
	public boolean isPlaced() {
		return isPlaced;
	}
	public void setPlaced(boolean isPlaced) {
		this.isPlaced = isPlaced;
	}
	public static String getString(Ingredient i) {
		if (i instanceof Cabbage) {
			return "Cabbage";
		}else if (i instanceof Tomato) {
			return "Tomato";
		}else {
			return "Fish";
		}
	}
	
}
