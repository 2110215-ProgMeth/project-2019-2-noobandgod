package entity;

import entity.base.Block;
import entity.base.Interactable;
import entity.base.Updatable;

public abstract class IngredientStorage extends Block implements Interactable, Updatable {
	protected int amount;
	protected boolean isAvailable;

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public boolean isAvailable() {
		return isAvailable;
	}

	public void setAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}
	
}
