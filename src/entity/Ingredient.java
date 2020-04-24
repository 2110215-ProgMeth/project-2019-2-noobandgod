package entity;

import entity.base.Entity;

public abstract class Ingredient extends Entity {
	private int State;

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
	
	
}
