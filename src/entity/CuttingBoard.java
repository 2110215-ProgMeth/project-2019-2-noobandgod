package entity;

import logic.Sprites;

public class CuttingBoard extends Equipment{
	private Ingredient OnCuttingBoardExists = null;
	public boolean interacts(Player e) {
		return e.isHolding();
	}
	public boolean places(Player e) {
		if (interacts(e)) {
			if ((!e.getIngredientHeld().equals(null)) && (getOnCuttingBoardExists().equals(null))) {
				setOnCuttingBoardExists(e.getIngredientHeld());
				e.setHolding(false);
				e.setIngredientHeld(null);
				return true;
			}else if ((!getOnCuttingBoardExists().equals(null)) && (!(e.getDishHeld().equals(null)))) {
				e.setDishHeld(e.getDishHeld().adds(getOnCuttingBoardExists()));
				setOnCuttingBoardExists(null);
				return true;
				//throw an exception.. ingredient on cuttingboard and i carry ingredient or dish
			}else if (!e.getIngredientHeld().equals(null) && (!getOnCuttingBoardExists().equals(null))) {
				return false;
			}
		}return false;//throw an exception that that you have nothing to place
	}
	public boolean cooks() {
		if (!getOnCuttingBoardExists().equals(null)) {
			getOnCuttingBoardExists().setState(1);
			return true;
		}return false;//throw an exception that there is nothing to be cooked
	}
	public boolean holds(Player e) {
		if (!interacts(e)){
			if (!getOnCuttingBoardExists().equals(null)){
				e.setIngredientHeld(getOnCuttingBoardExists());
				e.setHolding(true);
				setOnCuttingBoardExists(null);
				return true;
			}else{
				return false;
				//throw an exception that there is no ingredient to pick
			}
		}else {
			return false;
			//throw an exception
		}
	}
	public Ingredient getOnCuttingBoardExists() {
		return OnCuttingBoardExists;
	}
	public void setOnCuttingBoardExists(Ingredient onCuttingBoardExists) {
		OnCuttingBoardExists = onCuttingBoardExists;
	}
	public char getSymbol() {
		return Sprites.CuttingBoard;
	}
	
}
