package entity;

import entity.base.Entity;
import entity.base.Interactable;
import exception.CookFailedException;

import javafx.animation.AnimationTimer;
import javafx.scene.canvas.GraphicsContext;
import logic.GameController;
import logic.Sprites;
import screen.GameScreen;
import sharedObject.AudioLoader;
import sharedObject.RenderableHolder;

public class CuttingBoard extends Equipment implements Interactable{
	private Ingredient OnCuttingBoardExists ;
	private boolean OnCuttingBoard;
	
	public CuttingBoard() {
		setOnCuttingBoardExists(null);
		setOnCuttingBoard(false);
		setWorking(false);
	}
	
	public boolean isOnCuttingBoard() {
		return OnCuttingBoard;
	}
	public void setOnCuttingBoard(boolean onCuttingBoard) {
		OnCuttingBoard = onCuttingBoard;
	}
	
	public boolean interacts(Player e){//dont forget to setplace
		if (!e.isHolding()) {// empty hand
			if (getOnCuttingBoardExists() instanceof Ingredient) {
				Ingredient entity_clone = this.removedEntityOnCuttingBoard();
				e.setEntityHeld(entity_clone);
				e.setHolding(true);
				((Ingredient) entity_clone).setPlaced(false);
				return true;
			}
		}else {//holding something
			if (e.getEntityHeld() instanceof Dish) {//holding dish
				if (isOnCuttingBoard()) {
					Dish dish = (Dish) e.getEntityHeld();
					if (dish.check((Ingredient) getOnCuttingBoardExists())){
						Ingredient entity_clone = this.removedEntityOnCuttingBoard();
						dish.adds(entity_clone);
						e.setEntityHeld(dish);
						((Dish) dish).setPlaced(false);
						return true;
					}
				}
			}else {//holding ingredient
				if (!isOnCuttingBoard()) {	
					Entity entity_clone = e.removeEntityHeld();
					entity_clone.setX(this.getX()); entity_clone.setY(this.getY());
					RenderableHolder.getInstance().add(entity_clone);
					setOnCuttingBoardExists(entity_clone);
					setOnCuttingBoard(true);
					((Ingredient) entity_clone).setPlaced(true);
					return true;
				}
			}
		}return false;
	}
	public Ingredient removedEntityOnCuttingBoard() {
		setOnCuttingBoard(false);
		Ingredient removedEntity = (Ingredient) getOnCuttingBoardExists().clone();
		
		getOnCuttingBoardExists().setDestroyed(true);
		
		Entity oncuttingBoardEntity = getOnCuttingBoardExists();
		oncuttingBoardEntity = null;
		
		setOnCuttingBoardExists(null);
		return removedEntity;
	}
	
	public boolean cooks(Player p) throws CookFailedException{// throws CookFailedException{
		if ((!p.isHolding() && !isOnCuttingBoard()) || (!isOnCuttingBoard())){
			return false;
		}
		if (OnCuttingBoardExists.getState() >= 1) {
			return false;
		}
		if (OnCuttingBoard && !isWorking) {
			AudioLoader.Cutting.play();
			setWorking(true);
			drawProgessBar(GameScreen.gamegc, GameController.CUTTINGBOARD_COOLDOWN);
			final long startNanoTime = System.nanoTime();
			new AnimationTimer() {

			public void handle(long currentNanoTime) {
				double t = ((currentNanoTime - startNanoTime) / 1000000000.0);
				if (t < GameController.CUTTINGBOARD_COOLDOWN) {
					p.setFreeze(true);
				} else {
					p.setFreeze(false);
					OnCuttingBoardExists.setState(1);
					System.out.println("Cook completed!");
					setWorking(false);
					stop();
				}
			}
			}.start();
			return true;
		}
//		System.out.println("There is nothing to be cooked");
//		return false;
		throw new CookFailedException("There is nothing to be cooked");//throw an exception that there is nothing to be cooked
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
	@Override
	public int getZ() {
		return getY()*3;
	}
	@Override
	public void draw(GraphicsContext gc) {
		int pixel = GameScreen.pixel;
		int x = GameScreen.draw_origin_x+this.getX()*pixel;
		int y = GameScreen.draw_origin_y+this.getY()*pixel;
		
		if(!isAnyBlockDownward) {
			gc.drawImage(RenderableHolder.cuttingboard_infront_Image, x, y-6,64,70);
		} else {
			gc.drawImage(RenderableHolder.cuttingboard_between_Image, x, y-6);
		} 
		//Please read the code afterwards and edit pls..................
		
		if (OnCuttingBoardExists instanceof Cabbage) {
			 if (((Cabbage) OnCuttingBoardExists).getState() == 0) {
				 if(isAnyBlockDownward) {
					 gc.drawImage(RenderableHolder.cabbage_Image, x-2, y+5,64,40);
				 } else {
					 gc.drawImage(RenderableHolder.cabbage_Image, x-2, y,64,40);
				 }
		} else {//cabbage state1
			  gc.drawImage(RenderableHolder.cabbage_sliced_Image, x, y,64,40);
		}
			 
		 }else if (OnCuttingBoardExists instanceof Tomato) {
			 if (((Tomato) OnCuttingBoardExists).getState() == 0) {
				 if (isAnyBlockDownward) {
					 gc.drawImage(RenderableHolder.tomato_Image, x-2, y);
				 } else {
					 gc.drawImage(RenderableHolder.tomato_Image, x-2, y-5,64,40);
				 }
			 }else {//tomato state1
				 if (isAnyBlockDownward) {
					 gc.drawImage(RenderableHolder.tomato_sliced_Image, x+8, y+5);
				 } else {
					 gc.drawImage(RenderableHolder.tomato_sliced_Image, x+8, y);
				 }
			 }
			 
		 }else if (OnCuttingBoardExists instanceof Fish) {
			 if (((Fish) OnCuttingBoardExists).getState() == 0) {
				 if (isAnyBlockDownward) {
					 gc.drawImage(RenderableHolder.fish_Image, x, y+10);
				 } else {
					 gc.drawImage(RenderableHolder.fish_Image, x, y);
				 }
			 } else if (((Fish) OnCuttingBoardExists).getState() == 1) {
				 if (isAnyBlockDownward) {
					 gc.drawImage(RenderableHolder.fish_sliced_Image, x+6, y+6,48,32);
				 } else {
					 gc.drawImage(RenderableHolder.fish_sliced_Image, x+6, y,48,32);
				 }	
			 } else {
				 if (isAnyBlockDownward) {
					 gc.drawImage(RenderableHolder.fish_fried_Image, x+6, y+6,48,32);
				 } else {
					 gc.drawImage(RenderableHolder.fish_fried_Image, x+6, y+3,48,32);
				 }	
			 }
		}
	}
		


	@Override
	public boolean isVisible() {
		return true;
	}
	
}
