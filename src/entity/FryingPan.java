package entity;

import entity.base.Entity;
import entity.base.Interactable;
import exception.CookFailedException;
import exception.InteractFailedException;
import javafx.animation.AnimationTimer;
import logic.GameController;
import logic.Sprites;
import screen.GameScreen;

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
				Ingredient ingredient_clone = this.removedEntityOnFryingPan();
				e.setEntityHeld(ingredient_clone);
				e.setHolding(true);
				ingredient_clone.setPlaced(false);
				return true;
			}
		}else {
			if (e.getEntityHeld() instanceof Dish) {
				if (isOnFryingPan()) {
					Dish dish = (Dish) e.getEntityHeld();
					if (dish.check((Ingredient) getOnFryingPanExists())){
						Ingredient ingredient_clone = this.removedEntityOnFryingPan();
						dish.adds(ingredient_clone);
						e.setEntityHeld(dish);
						dish.setPlaced(false);
						return true;
					}
			    }
			}else {
				if (!isOnFryingPan()) {
					if (e.getEntityHeld() instanceof Fish) {
						Fish entity_clone = (Fish) e.removeEntityHeld();
						setOnFryingPanExists(entity_clone);
						setOnFryingPan(true);
						entity_clone.setPlaced(true);
						return true;
					}
				}
			}
		}System.out.println("There is something wrong");
		return false;
		//throw new InteractFailedException("There is something wrong");
	}
	public Ingredient removedEntityOnFryingPan() {
		setOnFryingPan(false);
		Ingredient removedEntity = (Ingredient) getOnFryingPanExists().clone();
		
		getOnFryingPanExists().setDestroyed(true);
		setOnFryingPanExists(null);
		return removedEntity;
	}
	public boolean cooks(Player p) throws CookFailedException{ //throws CookFailedException{
		if (OnFryingPanExists.getState() >= 1) {
			System.out.println("This ingredient has already been cooked");
		}
		if (OnFryingPan && isWorking) {
			setWorking(true);
			drawProgessBar(GameScreen.gamegc, GameController.FRYINGPAN_COOLDOWN);
			final long startNanoTime = System.nanoTime();
			new AnimationTimer() {

			public void handle(long currentNanoTime) {
				double t = ((currentNanoTime - startNanoTime) / 1000000000.0);
				if (t < GameController.FRYINGPAN_COOLDOWN) {
					p.setFreeze(true);
				} else {
					p.setFreeze(false);
					OnFryingPanExists.setState(2);
					System.out.println("Cook completed!");
					setWorking(false);
					stop();
				}
			}
			}.start();
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
