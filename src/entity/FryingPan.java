package entity;

import logic.Sprites;

public class FryingPan extends Equipment{
	private Ingredient OnFryingPanExists = null;
	public boolean interacts(Player e) {
		return e.isHolding();
	}
	public boolean places(Player e) {
		if (interacts(e)) {
			if (!e.getIngredientHeld().equals(null) && getOnFryingPanExists().equals(null)) {
				if (e.getIngredientHeld() instanceof Fish )	{
					setOnFryingPanExists(e.getIngredientHeld());
					e.setHolding(false);
					e.setIngredientHeld(null);
					return true;
				}
			}else if (!e.getIngredientHeld().equals(null) && (!getOnFryingPanExists().equals(null))){
				return false;
				//throw an exception.. carry ingredient and ingredient on equipment		
			}else if ((!e.getDishHeld().equals(null)) && (!getOnFryingPanExists().equals(null))) {
				e.getDishHeld().adds(getOnFryingPanExists());
				setOnFryingPanExists(null);
				return true;
			}
		}return false;//throw an exception that that you have nothing to place
	}
	
	public boolean cooks() {
		if (!getOnFryingPanExists().equals(null)) {
				getOnFryingPanExists().setState(2);
				return true;
		}return false;//throw an exception that nothing to be cooked
	}
	public boolean holds(Player e) {
		if (!interacts(e)){
			if (!getOnFryingPanExists().equals(null)){
				e.setIngredientHeld(getOnFryingPanExists());
				e.setHolding(true);
				setOnFryingPanExists(null);
				return true;
			}else {
				return false;
				//throw an exception that there is no ingredient to pick
			}
		}else {
			if ((!e.getDishHeld().equals(null)) && (!getOnFryingPanExists().equals(null))) {
				e.getDishHeld().adds(getOnFryingPanExists());
				setOnFryingPanExists(null);
				return true;
			}return false;
			//throw an exception
		}
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
