package entity;

import entity.base.Entity;
import logic.Direction;


public class Player {
	
	private boolean isHolding;
	private Entity entityHeld;
	private Direction faceDirection;
	private int PlayerNumber;
	
	public Player(int playerNumber) {
		setHolding(false);
		setFaceDirection(Direction.NONE);
		setPlayerNumber(playerNumber);
	}
	
	public void setHolding(boolean isHolding) {
		this.isHolding = isHolding;
	}

	public void setEntityHeld(Entity entityHeld) {
		this.entityHeld = entityHeld;
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

	public Entity getEntityHeld() {
		return entityHeld;
	}

	public Direction getFaceDirection() {
		return faceDirection;
	}

	public int getPlayerNumber() {
		return PlayerNumber;
	}
}
