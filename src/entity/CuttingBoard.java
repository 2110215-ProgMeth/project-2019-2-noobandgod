package entity;

import entity.base.Entity;
import entity.base.Interactable;
import exception.CookFailedException;

import exception.InteractFailedException;
import javafx.scene.canvas.GraphicsContext;
import logic.Sprites;

public class CuttingBoard extends Equipment implements Interactable{
	private Ingredient OnCuttingBoardExists = null;
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
			if (e.getEntityHeld() instanceof Dish) {
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
			}else {
				if (!isOnCuttingBoard()) {
					setOnCuttingBoardExists(e.getEntityHeld());
					setOnCuttingBoard(true);
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
	@Override
	public int getZ() {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public void draw(GraphicsContext gc) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public boolean isVisible() {
		// TODO Auto-generated method stub
		return false;
	}
	
}
