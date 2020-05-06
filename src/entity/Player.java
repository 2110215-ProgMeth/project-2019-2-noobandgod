package entity;

import entity.base.Entity;
import entity.base.Updatable;
import input.InputUtility;
import javafx.animation.AnimationTimer;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import logic.Direction;
import logic.GameController;
import screen.GameScreen;
import sharedObject.RenderableHolder;

public class Player extends Entity implements Updatable {
	private boolean isHolding;
	private Entity entityHeld;
	private int PlayerNumber;

	private int timeStandStill;
	private boolean isStill;

	private Direction faceDirection;
	private Direction lastwalkDirection;

	private boolean isFreeze;

	public Player(int playerNumber, int x, int y) {
		setX(x);
		setY(y);
		setHolding(false);
		setEntityHeld(null);
		setFaceDirection(Direction.NONE);
		setLastwalkDirection(Direction.NONE);
		setPlayerNumber(playerNumber);
		setTimeStandStill(0);
		setStill(true);
		setFreeze(false);
	}

	public Entity removeEntityHeld() {
		setHolding(false);
		Entity removedEntity = (Entity) getEntityHeld().clone();

		getEntityHeld().setDestroyed(true);
		setEntityHeld(null);

		return removedEntity;
	}

	public void setEntityHeld(Entity entityHeld) {
		if (!(entityHeld == null)) {
			setHolding(true);
			entityHeld.setX(this.getX());
			entityHeld.setY(this.getY());
			this.entityHeld = entityHeld;
			RenderableHolder.getInstance().add(entityHeld);
		} else {
			this.entityHeld = null;
		}
	}

	public boolean move(Direction dir) {
		if (!isFreeze) {
			setFaceDirection(dir);
			int targetx = this.getX();
			int targety = this.getY();

			switch (dir) {
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

			if (GameController.getCurrentGameMap().isMovePossible(this,targetx, targety)) {
				setX(targetx);
				setY(targety);

				if (isHolding) {
					getEntityHeld().setX(targetx);
					getEntityHeld().setY(targety);
				}

				System.out.println("Player " + getPlayerNumber() + " has moved to (" + getX() + "," + getY() + ")!");
				return true;
			} else {
				return false;
			}

		}
		return false;
	}

	public Integer[] getWhereInteract() {
		Direction dir = getFaceDirection();

		int targetx = this.getX();
		int targety = this.getY();

		switch (dir) {
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
		return new Integer[] { targetx, targety };
	}

	@Override
	public int getZ() {
		return getY() * 3 + 1;
	}

	@Override
	public void draw(GraphicsContext gc) {
		int pixel = GameScreen.pixel;
		int x = GameScreen.draw_origin_x + this.getX() * pixel;
		int y = (GameScreen.draw_origin_y - 20) + this.getY() * pixel;

		// System.out.println("Drawing Player at ("+getX()+","+getY()+")");

		if (!isStill) {
			switch (faceDirection) {
			case LEFT:
				gc.drawImage(RenderableHolder.player_walk_left_Image, x, y);
				break;
			case RIGHT:
				gc.drawImage(RenderableHolder.player_walk_right_Image, x, y);
				break;
			case UP:
				gc.drawImage(RenderableHolder.player_walk_up_Image, x, y);
				break;
			case DOWN:
				gc.drawImage(RenderableHolder.player_walk_down_Image, x, y);
				break;
			default:
				gc.drawImage(RenderableHolder.player_still_down_Image, x, y);
				break;
			}
		} else {
			switch (lastwalkDirection) {
			case LEFT:
				gc.drawImage(RenderableHolder.player_still_left_Image, x, y);
				break;
			case RIGHT:
				gc.drawImage(RenderableHolder.player_still_right_Image, x, y);
				break;
			case UP:
				gc.drawImage(RenderableHolder.player_still_up_Image, x, y);
				break;
			case DOWN:
				gc.drawImage(RenderableHolder.player_still_down_Image, x, y);
				break;
			default:
				gc.drawImage(RenderableHolder.player_still_down_Image, x, y);
			}
		}
	}

	@Override
	public boolean isVisible() {
		return true;
	}

	@Override
	public void update() {
		// System.out.println(toString());
		if (getTimeStandStill() > 13) {
			setStill(true);
		} else {
			setStill(false);
		}
		
		//======================================================================================
		//for player 0 
		if (!isFreeze) {
			if (InputUtility.getKeypressed().contains(KeyCode.W) && this.getPlayerNumber() == 0) {
				this.move(Direction.UP);
				setLastwalkDirection(Direction.UP);
				setTimeStandStill(0);

			} else if (InputUtility.getKeypressed().contains(KeyCode.S) && this.getPlayerNumber() == 0) {
				this.move(Direction.DOWN);
				setLastwalkDirection(Direction.DOWN);
				setTimeStandStill(0);

			} else if (InputUtility.getKeypressed().contains(KeyCode.A) && this.getPlayerNumber() == 0) {
				this.move(Direction.LEFT);
				setLastwalkDirection(Direction.LEFT);
				setTimeStandStill(0);

			} else if (InputUtility.getKeypressed().contains(KeyCode.D) && this.getPlayerNumber() == 0) {
				this.move(Direction.RIGHT);
				setLastwalkDirection(Direction.RIGHT);
				setTimeStandStill(0);

			}
		}

		if (!InputUtility.getKeypressed().contains((KeyCode.W)) && !InputUtility.getKeypressed().contains((KeyCode.S))
				&& !InputUtility.getKeypressed().contains((KeyCode.A)) && !InputUtility.getKeypressed().contains((KeyCode.D))
				&& this.getPlayerNumber() == 0) {
			addTimeStandStill();
		}

		if ((InputUtility.getKeypressed().contains((KeyCode.SHIFT))
				|| InputUtility.getKeypressed().contains(KeyCode.CONTROL)) && this.getPlayerNumber() == 0) {
			Integer[] targetcoordinate = getWhereInteract();
			int targetx = targetcoordinate[0];
			int targety = targetcoordinate[1];
			if (!isFreeze) {
				if (InputUtility.getKeypressed().contains((KeyCode.SHIFT))) {
					if (GameController.getCurrentGameMap().interactWithBlockTarget(GameController.getPlayers(0),
							targetx, targety, 0)) {
						System.out.println("Interact completed!");
					} else {
						System.out.println("Interact failed!");
					}
				} else if (InputUtility.getKeypressed().contains((KeyCode.CONTROL))) {
					if (GameController.getCurrentGameMap().interactWithBlockTarget(GameController.getPlayers(0),
							targetx, targety, 1)) {
						
					} else {
						System.out.println("Cook failed!");
					}
				}
			}
		}
		//======================================================================================
		if (!isFreeze) {
			if (InputUtility.getKeypressed().contains(KeyCode.I) && this.getPlayerNumber() == 1) {
				this.move(Direction.UP);
				setLastwalkDirection(Direction.UP);
				setTimeStandStill(0);

			} else if (InputUtility.getKeypressed().contains(KeyCode.K) && this.getPlayerNumber() == 1) {
				this.move(Direction.DOWN);
				setLastwalkDirection(Direction.DOWN);
				setTimeStandStill(0);

			} else if (InputUtility.getKeypressed().contains(KeyCode.J) && this.getPlayerNumber() == 1) {
				this.move(Direction.LEFT);
				setLastwalkDirection(Direction.LEFT);
				setTimeStandStill(0);

			} else if (InputUtility.getKeypressed().contains(KeyCode.L) && this.getPlayerNumber() == 1) {
				this.move(Direction.RIGHT);
				setLastwalkDirection(Direction.RIGHT);
				setTimeStandStill(0);

			}
		}

		if (!InputUtility.getKeypressed().contains((KeyCode.I)) && !InputUtility.getKeypressed().contains((KeyCode.J))
				&& !InputUtility.getKeypressed().contains((KeyCode.K)) && !InputUtility.getKeypressed().contains((KeyCode.L))
				&& this.getPlayerNumber() == 1) {
			addTimeStandStill();
		}

		if ((InputUtility.getKeypressed().contains((KeyCode.ENTER))
				|| InputUtility.getKeypressed().contains(KeyCode.QUOTE)) && this.getPlayerNumber() == 1) {
			Integer[] targetcoordinate = getWhereInteract();
			int targetx = targetcoordinate[0];
			int targety = targetcoordinate[1];
			if (!isFreeze) {
				if (InputUtility.getKeypressed().contains((KeyCode.ENTER))) {
					if (GameController.getCurrentGameMap().interactWithBlockTarget(GameController.getPlayers(1),
							targetx, targety, 0)) {
						System.out.println("Interact completed!");
					} else {
						System.out.println("Interact failed!");
					}
				} else if (InputUtility.getKeypressed().contains((KeyCode.QUOTE))) {
					if (GameController.getCurrentGameMap().interactWithBlockTarget(GameController.getPlayers(1),
							targetx, targety, 1)) {
						
					} else {
						System.out.println("Cook failed!");
					}
				}
			}
		}
		
		
		//======================================================================================
		
	}
	public String toString() {
		String result = "PLAYER NO: " + getPlayerNumber();
		result += "\nHolding someting? " + isHolding();
		result += "\nis still? " + isStill();
		result += "\nStanding at: (" + getX() + "," + getY() + ")";
		return result;
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

	public Entity getEntityHeld() {
		return entityHeld;
	}

	public Direction getFaceDirection() {
		return faceDirection;
	}

	public int getPlayerNumber() {
		return PlayerNumber;
	}

	public Direction getLastwalkDirection() {
		return lastwalkDirection;
	}

	public void setLastwalkDirection(Direction lastwalkDirection) {
		this.lastwalkDirection = lastwalkDirection;
	}

	public int getTimeStandStill() {
		return timeStandStill;
	}

	public void setTimeStandStill(int timeStandStill) {
		this.timeStandStill = timeStandStill;
	}

	public void addTimeStandStill() {
		this.timeStandStill += 1;
	}

	public boolean isStill() {
		return isStill;
	}

	public void setStill(boolean isStill) {
		this.isStill = isStill;
	}

	public boolean isFreeze() {
		return isFreeze;
	}

	public void setFreeze(boolean isFreeze) {
		this.isFreeze = isFreeze;
	}

}
