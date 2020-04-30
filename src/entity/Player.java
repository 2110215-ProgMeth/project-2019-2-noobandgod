package entity;

import entity.base.Entity;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import logic.Direction;
import logic.GameController;
import screen.GameScreen;


public class Player extends Entity{
	private boolean isHolding;
	private Ingredient ingredientHeld;
	private Dish dishHeld;
	private Direction faceDirection;
	private int PlayerNumber;
	protected boolean visible;
	
	private static Image testplayer1 = new Image(ClassLoader.getSystemResource("picture/testplayer1.png").toString());
	
	public Player(int playerNumber,int x,int y) {
		setX(x);
		setY(y);
		visible = true;
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
			System.out.println("Player "+getPlayerNumber()+" has moved to ("+getX()+","+getY()+")!");
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

	@Override
	public int getZ() {
		return 103;
	}

	@Override
	public void draw(GraphicsContext gc) {
		int pixel = GameScreen.pixel;
		int x = GameScreen.draw_origin_x+this.getX()*pixel;
		int y = (GameScreen.draw_origin_y)+this.getY()*pixel;
		
		gc.drawImage(testplayer1, x, y);
		
	}

	@Override
	public boolean isVisible() {
		return visible;
	}
	
}
