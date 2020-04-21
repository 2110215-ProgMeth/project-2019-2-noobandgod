package entity;

import entity.base.Entity;
import logic.Direction;


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
