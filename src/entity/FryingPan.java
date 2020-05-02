package entity;

import entity.base.Entity;
import entity.base.Interactable;
import exception.CookFailedException;
import exception.InteractFailedException;
import logic.Sprites;

public class FryingPan extends Equipment implements Interactable{
	private Ingredient OnFryingPanExists = null;
	public boolean interacts(Player e) throws InteractFailedException{
		if (!e.isHolding()) {
			if (getOnFryingPanExists() instanceof Ingredient) {
				setOnFryingPanExists(null);
				e.setEntityHeld(getOnFryingPanExists());
				e.setHolding(true);
				return true;
			}
		}else {
			if (e.getEntityHeld() instanceof Dish) {
				if (!getOnFryingPanExists().equals(null)) {
					Dish dish = (Dish) e.getEntityHeld();
					dish.adds(getOnFryingPanExists());
					setOnFryingPanExists(null);
					e.setEntityHeld(dish);
					return true;
			    }
			}else {
				if (getOnFryingPanExists().equals(null)) {
					if (e.getEntityHeld() instanceof Fish) {
						setOnFryingPanExists(e.getEntityHeld());
						e.removeEntityHeld();
						return true;
					}
				}
			}
		}throw new InteractFailedException("There is something wrong");
	}
	public boolean cooks() throws CookFailedException{
		if (!getOnFryingPanExists().equals(null)) {
				getOnFryingPanExists().setState(2);
				return true;
		}throw new CookFailedException("There is nothing to be cooked");//throw an exception that nothing to be cooked
	}
	public Ingredient getOnFryingPanExists() {
		return OnFryingPanExists;
	}

	public void setOnFryingPanExists(Entity onFryingPanExists) {
		OnFryingPanExists =(Ingredient) onFryingPanExists;
	}
	public char getSymbol() {
		return Sprites.FryingPan;
	}
	
}
