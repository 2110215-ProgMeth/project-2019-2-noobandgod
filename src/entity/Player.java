package entity;

import entity.base.Entity;
import logic.Direction;
import logic.GameController;
import sun.awt.www.content.audio.x_aiff;


public class Player extends Entity{
	private boolean isHolding;
	private Ingredient ingredientHeld;
	private Dish dishHeld;
	private Direction faceDirection;
	private int PlayerNumber;
	
	public Player(int playerNumber) {
		setHolding(false);
		setIngredientHeld(null);
		setDishHeld(null);
		setFaceDirection(Direction.NONE);
		setPlayerNumber(playerNumber);
	}
	
	public boolean move(Direction dir) {
		setFaceDirection(dir);
		
		int targetx = this.getX();
		int targety = this.getY();
		
		switch(dir) {
		case LEFT:
			targetx -= 1;
			break;
		case UP:
			targety -= 1;
			break;
		case RIGHT:
			targetx += 1;
			break;
		case DOWN:
			targety += 1;
			break;
		default:
			break;
		}
		
		if(GameController.getCurrentGameMap().isMovePossible(targetx, targety)) {
			setX(targetx); setY(targety);
			return true;
		} else {
			return false;
		}
	}
	
	
	
	public void setHolding(boolean isHolding) {
		this.isHolding = isHolding;
	}
	
	public void setFaceDirection(Direction faceDirection) {
		this.faceDirection = faceDirection;
	}

	public void setPlayerNumber(int playerNumber) {
		this.PlayerNumber = playerNumber;
	}

	public boolean isHolding() {
		return isHolding;
	}
	
	public Ingredient getIngredientHeld() {
		return ingredientHeld;
	}

	public void setIngredientHeld(Ingredient ingredientHeld) {
		this.ingredientHeld = ingredientHeld;
	}

	public Dish getDishHeld() {
		return dishHeld;
	}

	public void setDishHeld(Dish dishHeld) {
		this.dishHeld = dishHeld;
	}

	public Direction getFaceDirection() {
		return faceDirection;
	}
//	public getWhereInteract() {
		
//	}
	public int getPlayerNumber() {
		return PlayerNumber;
	}
	public char getSymbol() {
		return Sprites.Player;
	}
}
