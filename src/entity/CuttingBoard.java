package entity;

import entity.base.Entity;
import entity.base.Interactable;
import exception.CookFailedException;

import exception.InteractFailedException;
import javafx.scene.canvas.GraphicsContext;
import logic.Sprites;
import screen.GameScreen;
import sharedObject.RenderableHolder;

public class CuttingBoard extends Equipment implements Interactable{
	private Ingredient OnCuttingBoardExists ;
	private boolean OnCuttingBoard;
	
	public CuttingBoard() {
		setOnCuttingBoardExists(null);
		setOnCuttingBoard(false);
	}
	
	
	public boolean isOnCuttingBoard() {
		return OnCuttingBoard;
	}
	public void setOnCuttingBoard(boolean onCuttingBoard) {
		OnCuttingBoard = onCuttingBoard;
	}
	
	
	public boolean interacts(Player e) throws InteractFailedException{
		if (!e.isHolding()) {// empty hand
			if (getOnCuttingBoardExists() instanceof Ingredient) {
				e.setEntityHeld(getOnCuttingBoardExists());
				setOnCuttingBoardExists(null);
				e.setHolding(true);
				setOnCuttingBoard(false);
				return true;
			}
		}else {//holding something
			if (e.getEntityHeld() instanceof Dish) {//holding dish
				if (isOnCuttingBoard()) {
					Dish dish = (Dish) e.getEntityHeld();
					if (dish.check((Ingredient) getOnCuttingBoardExists())){
						dish.adds(getOnCuttingBoardExists());
						setOnCuttingBoardExists(null);
						e.setEntityHeld(dish);
						setOnCuttingBoard(false);
						return true;
					}
				}
			}else {//holding ingredient
				if (!isOnCuttingBoard()) {
					setOnCuttingBoardExists(e.getEntityHeld());
					setOnCuttingBoard(true);
					e.setHolding(false);
					e.setEntityHeld(null);
					return true;
				}
			}
		}return false;
	}
	public boolean cooks() throws CookFailedException{
		if (OnCuttingBoard) {
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
			gc.drawImage(RenderableHolder.cuttingboard_infront_Image, x, y-6);
		} else {
			gc.drawImage(RenderableHolder.cuttingboard_between_Image, x, y-6);
		}
		
	}
	@Override
	public boolean isVisible() {
		return true;
	}
	
}
