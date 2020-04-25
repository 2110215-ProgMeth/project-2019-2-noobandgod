package entity;

import logic.Sprites;
import test.CookFailedException;
import test.HoldFailedException;
import test.PlaceFailedException;

public class FryingPan extends Equipment{
	private Ingredient OnFryingPanExists = null;
	public boolean interacts(Player e) {
		return e.isHolding();
	}
	public boolean places(Player e) throws PlaceFailedException{
		if (interacts(e)) {
			if ((!e.getIngredientHeld().equals(null)) && (getOnFryingPanExists().equals(null))) {
				if (e.getIngredientHeld() instanceof Fish )	{
					setOnFryingPanExists(e.getIngredientHeld());
					e.setHolding(false);
					e.setIngredientHeld(null);
					return true;
				}
			}else if (!e.getIngredientHeld().equals(null) && (!getOnFryingPanExists().equals(null))){
				throw new PlaceFailedException("You can't place a carried ingredient because there is an ingredient on Frying pan");
				//throw an exception
				//throw an exception.. carry ingredient and ingredient on equipment		
			}else if ((!e.getDishHeld().equals(null)) && (!getOnFryingPanExists().equals(null))) {
				e.getDishHeld().adds(getOnFryingPanExists());
				setOnFryingPanExists(null);
				return true;
			}throw new PlaceFailedException("You can't place a dish on a frying pan");
		}throw new PlaceFailedException("You can't place because you are holding nothing");//throw an exception that that you have nothing to place
	}
	
	public boolean cooks() throws CookFailedException{
		if (!getOnFryingPanExists().equals(null)) {
				getOnFryingPanExists().setState(2);
				return true;
		}throw new CookFailedException("There is nothing to be cooked");//throw an exception that nothing to be cooked
	}
	public boolean holds(Player e) throws HoldFailedException{
		if (!interacts(e)){
			if (!getOnFryingPanExists().equals(null)){
				e.setIngredientHeld(getOnFryingPanExists());
				e.setHolding(true);
				setOnFryingPanExists(null);
				return true;
				//throw an exception that there is no ingredient to pick
			}
		}else {
			if ((!e.getDishHeld().equals(null)) && (!getOnFryingPanExists().equals(null))) {
				e.getDishHeld().adds(getOnFryingPanExists());
				setOnFryingPanExists(null);
				return true;
			}
			//throw an exception
		}throw new HoldFailedException("There is nothing to be hold");
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
