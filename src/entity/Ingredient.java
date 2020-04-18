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
}
