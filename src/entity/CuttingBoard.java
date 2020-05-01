package entity;

import entity.base.Entity;
import exception.CookFailedException;

import exception.InteractFailedException;

import logic.Sprites;

public class CuttingBoard extends Equipment{
	private Ingredient OnCuttingBoardExists = null;
	public boolean interacts(Player e) {
		if (!e.isHolding()) {
			if (getOnCuttingBoardExists() instanceof Ingredient) {
				setOnCuttingBoardExists(null);
				e.setEntityHeld(getOnCuttingBoardExists());
				e.setHolding(true);
				return true;
			}
		}else {
			if (e.getEntityHeld() instanceof Dish) {
				if (!getOnCuttingBoardExists().equals(null)) {
					Dish dish = (Dish) e.getEntityHeld();
					dish.adds(getOnCuttingBoardExists());
					setOnCuttingBoardExists(null);
					return true;
			    }
			}else {
				if (getOnCuttingBoardExists().equals(null)) {
					setOnCuttingBoardExists(e.getEntityHeld());
					e.setEntityHeld(null);
					e.setHolding(false);
					return true;
				}
			}
		}return false;	
	}
	public boolean cooks() throws CookFailedException{
		if (!getOnCuttingBoardExists().equals(null)) {
			getOnCuttingBoardExists().setState(1);
			return true;
		}throw new CookFailedException("There is nothing to be cooked");//throw an exception that there is nothing to be cooked
	}
	public Ingredient getOnCuttingBoardExists() {
		return (Ingredient) OnCuttingBoardExists;
	}
	public void setOnCuttingBoardExists(Entity onCuttingBoardExists) {
		OnCuttingBoardExists = (Ingredient) onCuttingBoardExists;
	}
	public char getSymbol() {
		return Sprites.CuttingBoard;
	}
	
}
