package entity;

import logic.Sprites;

public class FryingPan extends Equipment{
	private Ingredient OnFryingPanExists = null;
	public boolean interacts(Player e) {
		return e.isHolding();
	}
	public boolean places(Player e) {
		if (interacts(e)) {
			if (!e.getIngredientHeld().equals(null))
				setOnFryingPanExists(e.getIngredientHeld());
				e.setHolding(false);
				e.setIngredientHeld(null);
				return true;
		}return false;
	}
	public boolean cooks() {
		if (!getOnFryingPanExists().equals(null)) {
			getOnFryingPanExists().setState(2);
			return true;
		}return false;
	}
	public boolean holds(Player e) {
		if (!interacts(e)){
			e.setIngredientHeld(getOnFryingPanExists());
			e.setHolding(true);
			setOnFryingPanExists(null);
			return true;
		}return false;
	}
	public Ingredient getOnFryingPanExists() {
		return OnFryingPanExists;
	}

	public void setOnFryingPanExists(Ingredient onFryingPanExists) {
		OnFryingPanExists = onFryingPanExists;
	}
	public char getSymbol() {
		return Sprites.FryingPan;
	}
	
}
