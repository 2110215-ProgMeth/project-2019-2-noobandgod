package entity;

import logic.Sprites;

public class CuttingBoard extends Equipment{
	private Ingredient OnCuttingBoardExists = null;
	public boolean interacts(Player e) {
		return e.isHolding();
	}
	public boolean places(Player e) {
		if (interacts(e)) {
			if (!e.getIngredientHeld().equals(null))
				setOnCuttingBoardExists(e.getIngredientHeld());
				e.setHolding(false);
				e.setIngredientHeld(null);
				return true;
		}return false;
	}
	public boolean cooks() {
		if (!getOnCuttingBoardExists().equals(null)) {
			getOnCuttingBoardExists().setState(1);
			return true;
		}return false;
	}
	public boolean holds(Player e) {
		if (!interacts(e)){
			e.setIngredientHeld(getOnCuttingBoardExists());
			e.setHolding(true);
			setOnCuttingBoardExists(null);
			return true;
		}return false;
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
