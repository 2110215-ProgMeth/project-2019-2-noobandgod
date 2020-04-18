package entity;

import entity.base.Entity;
import entity.base.Holdable;

public abstract class Ingredient extends Entity implements Holdable{
	private int State;
	public void setState(int state) {
		this.State = state;
	}
	public int getState() {
		return this.State;
	}
}
