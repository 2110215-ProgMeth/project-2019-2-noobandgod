package entity;

import logic.CookFailedException;
import logic.HoldFailedException;
import logic.PlaceFailedException;
import logic.Sprites;

public class CuttingBoard extends Equipment{
	private Ingredient OnCuttingBoardExists = null;
	public boolean interacts(Player e) {
		return e.isHolding();
	}
	public boolean places(Player e) throws PlaceFailedException{
		if (interacts(e)){
			if ((!e.getIngredientHeld().equals(null)) && (getOnCuttingBoardExists().equals(null))) {
				setOnCuttingBoardExists(e.getIngredientHeld());
				e.setHolding(false);
				e.setIngredientHeld(null);
				return true;
			}else if ((!getOnCuttingBoardExists().equals(null)) && (!(e.getDishHeld().equals(null)))) {
				e.getDishHeld().adds(getOnCuttingBoardExists());
				setOnCuttingBoardExists(null);
				return true;
			}else if (!e.getIngredientHeld().equals(null) && (!getOnCuttingBoardExists().equals(null))) {
				throw new PlaceFailedException("You can't place a carried ingredient because there is an ingredient on Cutting board");
				//throw an exception
			}
		}throw new PlaceFailedException("You can't place because either there is no ingredient or it is a dish");//throw an exception that that you have nothing to place
	}
	public boolean cooks() throws CookFailedException{
		if (!getOnCuttingBoardExists().equals(null)) {
			getOnCuttingBoardExists().setState(1);
			return true;
		}throw new CookFailedException("There is nothing to be cooked");//throw an exception that there is nothing to be cooked
	}
	public boolean holds(Player e) throws HoldFailedException{
		if (!interacts(e)){
			if (!getOnCuttingBoardExists().equals(null)){
				e.setIngredientHeld(getOnCuttingBoardExists());
				e.setHolding(true);
				setOnCuttingBoardExists(null);
				return true;	//throw an exception that can't hold
			}
		}else {
			if ((!e.getDishHeld().equals(null)) && (!getOnCuttingBoardExists().equals(null))) {
				e.getDishHeld().adds(getOnCuttingBoardExists());
				setOnCuttingBoardExists(null);
				return true;
			}
			//throw an exception
		}throw new HoldFailedException("There is nothing to be hold");
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
