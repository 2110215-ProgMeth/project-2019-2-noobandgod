package entity;

import entity.base.Entity;
import entity.base.Interactable;
import exception.CookFailedException;
import exception.InteractFailedException;
import javafx.animation.AnimationTimer;
import javafx.scene.canvas.GraphicsContext;
import logic.GameController;
import logic.Sprites;
import screen.GameScreen;
import sharedObject.RenderableHolder;

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
		if (!e.isHolding()) {//holding nothing
			if (getOnFryingPanExists() instanceof Ingredient) {//food on frying pan
				Ingredient ingredient_clone = this.removedEntityOnFryingPan();
				e.setEntityHeld(ingredient_clone);
				e.setHolding(true);
				ingredient_clone.setPlaced(false);
				return true;
			}
		}else {//holding something
			if (e.getEntityHeld() instanceof Dish) {//holding a dish
				if (isOnFryingPan()) {//ingredient on frying pan
					Dish dish = (Dish) e.getEntityHeld();
					if (dish.check((Ingredient) getOnFryingPanExists())){
						Ingredient ingredient_clone = this.removedEntityOnFryingPan();
						dish.adds(ingredient_clone);
						e.setEntityHeld(dish);
						dish.setPlaced(false);
						return true;
					}
			    }
			}else {//holding fish
				if (!isOnFryingPan()) {//nothing on the frying pan
					if (e.getEntityHeld() instanceof Fish) {
						if(((Fish) e.getEntityHeld()).getState() == 1) {
							System.out.println("NO SASHIMI ON PAN");
							return false;
						} else {
							Fish entity_clone = (Fish) e.removeEntityHeld();
							setOnFryingPanExists(entity_clone);
							setOnFryingPan(true);
							entity_clone.setPlaced(true);
							return true;
						}
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
		if (!OnFryingPan){
			return false;
		}
		if (OnFryingPanExists.getState() >= 1) {
			System.out.println("This ingredient has already been cooked");
			return false;
		}
		if (OnFryingPan && !isWorking) {
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

	@Override
	public int getZ() {
		// TODO Auto-generated method stub
		return getY()*3;
	}

	@Override
	public void draw(GraphicsContext gc) {
		int pixel = GameScreen.pixel;
		int x = GameScreen.draw_origin_x+this.getX()*pixel;
		int y = GameScreen.draw_origin_y+this.getY()*pixel;
		
		if(!isAnyBlockDownward) {
			gc.drawImage(RenderableHolder.fryingpan_infront_Image, x, y-6,64,70);
		} else {
			gc.drawImage(RenderableHolder.fryingpan_between_Image, x, y-6);
		} 
		
		if (OnFryingPanExists instanceof Fish) {
			if (((Fish) OnFryingPanExists).getState() == 0) { //raw fish
				if(!isAnyBlockDownward) {
					gc.drawImage(RenderableHolder.fish_Image, x, y);
				} else {
					gc.drawImage(RenderableHolder.fish_Image, x, y+10);
				}
			} else if (((Fish) OnFryingPanExists).getState() == 2){
				if(!isAnyBlockDownward) {
					gc.drawImage(RenderableHolder.fish_fried_Image, x+10, y+7, 40, 28);
				} else {
					gc.drawImage(RenderableHolder.fish_fried_Image, x+10, y+10, 45, 32);
				}
			}
		}
		
	}

	@Override
	public boolean isVisible() {
		return true;
	}
	
}
