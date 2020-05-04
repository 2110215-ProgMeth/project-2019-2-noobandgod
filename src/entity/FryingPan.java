package entity;

import entity.base.Entity;
import entity.base.Interactable;
import exception.CookFailedException;
import exception.InteractFailedException;
import logic.Sprites;

public class FryingPan extends Equipment implements Interactable{
	private Ingredient OnFryingPanExists;
	private boolean OnFryingPan;
	
	public FryingPan() {
		setOnFryingPan(false);
		setOnFryingPanExists(null);
		setWorking(false);
	}
	
	public boolean isOnFryingPan() {
		return OnFryingPan;
	}
	private void setOnFryingPan(boolean b) {
		OnFryingPan = b;
		
	}
	public boolean interacts(Player e) {//throws InteractFailedException{
		if (!e.isHolding()) {
			if (getOnFryingPanExists() instanceof Ingredient) {
				e.setEntityHeld(getOnFryingPanExists());
				setOnFryingPanExists(null);
				e.setHolding(true);
				setOnFryingPan(false);
				return true;
			}
		}else {
			if (e.getEntityHeld() instanceof Dish) {
				if (isOnFryingPan()) {
					Dish dish = (Dish) e.getEntityHeld();
					if (dish.check((Ingredient) getOnFryingPanExists())){
						dish.adds(getOnFryingPanExists());
						setOnFryingPanExists(null);
						e.setEntityHeld(dish);
						setOnFryingPan(false);
						return true;
					}
			    }
			}else {
				if (!isOnFryingPan()) {
					if (e.getEntityHeld() instanceof Fish) {
						setOnFryingPanExists(e.getEntityHeld());
						setOnFryingPan(true);
						e.setHolding(false);
						e.setEntityHeld(null);
						return true;
					}
				}
			}
		}System.out.println("There is something wrong");
		return false;
		//throw new InteractFailedException("There is something wrong");
	}
	public boolean cooks(Player p) throws CookFailedException{ //throws CookFailedException{
		if (OnFryingPan) {
				getOnFryingPanExists().setState(2);
				return true;
		}System.out.println("There is nothing to be cooked");
		return false;
		//throw new CookFailedException("There is nothing to be cooked");//throw an exception that nothing to be cooked
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
