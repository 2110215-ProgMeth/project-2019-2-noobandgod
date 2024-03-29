package entity;

import entity.base.Cookable;
import entity.base.Entity;
import entity.base.Interactable;
import exception.InteractFailedException;
import javafx.animation.AnimationTimer;
import javafx.scene.canvas.GraphicsContext;
import logic.GameController;
import logic.Sprites;
import screen.GameScreen;
import sharedObject.AudioLoader;
import sharedObject.RenderableHolder;

public class CuttingBoard extends Equipment implements Interactable,Cookable{
	private Ingredient OnCuttingBoardExists ;
	private boolean OnCuttingBoard;
	
	public CuttingBoard() {
		setOnCuttingBoardExists(null);
		setOnCuttingBoard(false);
		setWorking(false);
	}
	
	public boolean interacts(Player p) throws  InteractFailedException{//dont forget to setplace
		if (!p.isHolding()) {// empty hand
			if (getOnCuttingBoardExists() instanceof Ingredient) {
				Ingredient entity_clone = this.removedEntityOnCuttingBoard();
				p.setEntityHeld(entity_clone);
				p.setHolding(true);
				((Ingredient) entity_clone).setPlaced(false);
				return true;
			}
		}else {//holding something
			if (p.getEntityHeld() instanceof Dish) {//holding dish
				if (isOnCuttingBoard()) {
					Dish dish = (Dish) p.getEntityHeld();
					if (dish.check((Ingredient) getOnCuttingBoardExists())){
						Ingredient entity_clone = this.removedEntityOnCuttingBoard();
						dish.adds(entity_clone);
						p.setEntityHeld(dish);
						((Dish) dish).setPlaced(false);
						return true;
					}
				}
			}else {//holding ingredient
				if (!isOnCuttingBoard()) {	
					Entity entity_clone = p.removeEntityHeld();
					entity_clone.setX(this.getX()); entity_clone.setY(this.getY());
					RenderableHolder.getInstance().add(entity_clone);
					setOnCuttingBoardExists(entity_clone);
					setOnCuttingBoard(true);
					((Ingredient) entity_clone).setPlaced(true);
					return true;
				}
			}
		}throw new InteractFailedException("ERROR");
	}
	public Ingredient removedEntityOnCuttingBoard() {
		setOnCuttingBoard(false);
		Ingredient removedEntity = (Ingredient) getOnCuttingBoardExists().clone();
		
		getOnCuttingBoardExists().setDestroyed(true);
		
		setOnCuttingBoardExists(null);
		return removedEntity;
	}
	
	public boolean cooks(Player p) throws InteractFailedException{
		if ((!p.isHolding() && !isOnCuttingBoard()) || (!isOnCuttingBoard())){
			throw new InteractFailedException("ERROR");
		}
		if (OnCuttingBoardExists.getState() >= 1) {
			throw new InteractFailedException("ERROR");
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
					//Cook completed
					p.setFreeze(false);
					OnCuttingBoardExists.setState(1);
					setWorking(false);
					stop();
				}
			}
			}.start();
			return true;
		} throw new InteractFailedException("ERROR");
	}
	
	public char getSymbol() {
		return Sprites.CuttingBoard;
	}
	@Override
	public int getZ() {
		return y*3;
	}
	@Override
	public void draw(GraphicsContext gc) {
		int pixel = GameScreen.pixel;
		int X = GameScreen.draw_origin_x+x*pixel;
		int Y = GameScreen.draw_origin_y+y*pixel;
		
		if(!isAnyBlockDownward) {
			gc.drawImage(RenderableHolder.cuttingboard_infront_Image, X, Y-6,64,70);
		} else {
			gc.drawImage(RenderableHolder.cuttingboard_between_Image, X, Y-6);
		} 
		//Please read the code afterwards and edit pls..................
		
		if (OnCuttingBoardExists instanceof Cabbage) {
			 if (((Cabbage) OnCuttingBoardExists).getState() == 0) {
				 if(isAnyBlockDownward) {
					 gc.drawImage(RenderableHolder.cabbage_Image, X-2, Y+5,64,40);
				 } else {
					 gc.drawImage(RenderableHolder.cabbage_Image, X-2, Y,64,40);
				 }
		} else {//cabbage state1
			  gc.drawImage(RenderableHolder.cabbage_sliced_Image, X, Y,64,40);
		}
			 
		 }else if (OnCuttingBoardExists instanceof Tomato) {
			 if (((Tomato) OnCuttingBoardExists).getState() == 0) {
				 if (isAnyBlockDownward) {
					 gc.drawImage(RenderableHolder.tomato_Image, X-2, Y);
				 } else {
					 gc.drawImage(RenderableHolder.tomato_Image, X-2, Y-5,64,40);
				 }
			 }else {//tomato state1
				 if (isAnyBlockDownward) {
					 gc.drawImage(RenderableHolder.tomato_sliced_Image, X+8, Y+5);
				 } else {
					 gc.drawImage(RenderableHolder.tomato_sliced_Image, X+8, Y);
				 }
			 }
			 
		 }else if (OnCuttingBoardExists instanceof Fish) {
			 if (((Fish) OnCuttingBoardExists).getState() == 0) {
				 if (isAnyBlockDownward) {
					 gc.drawImage(RenderableHolder.fish_Image, X, Y+10);
				 } else {
					 gc.drawImage(RenderableHolder.fish_Image, X, Y);
				 }
			 } else if (((Fish) OnCuttingBoardExists).getState() == 1) {
				 if (isAnyBlockDownward) {
					 gc.drawImage(RenderableHolder.fish_sliced_Image, X+6, Y+6,48,32);
				 } else {
					 gc.drawImage(RenderableHolder.fish_sliced_Image, X+6, Y,48,32);
				 }	
			 } else {
				 if (isAnyBlockDownward) {
					 gc.drawImage(RenderableHolder.fish_fried_Image, X+6, Y+6,48,32);
				 } else {
					 gc.drawImage(RenderableHolder.fish_fried_Image, X+6, Y+3,48,32);
				 }	
			 }
		}
	}
		
	@Override
	public boolean isVisible() {
		return true;
	}

	public boolean isOnCuttingBoard() {
		return OnCuttingBoard;
	}
	public void setOnCuttingBoard(boolean onCuttingBoard) {
		OnCuttingBoard = onCuttingBoard;
	}
	
	public Ingredient getOnCuttingBoardExists() {
		return (Ingredient) OnCuttingBoardExists;
	}
	public void setOnCuttingBoardExists(Entity onCuttingBoardExists) {
		OnCuttingBoardExists = (Ingredient) onCuttingBoardExists;
	}
	
	
}
