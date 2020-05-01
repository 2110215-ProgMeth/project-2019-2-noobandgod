package entity;

import entity.base.Entity;
import entity.base.Updatable;
import input.InputUtility;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import logic.Direction;
import logic.GameController;
import screen.GameScreen;


public class Player extends Entity implements Updatable{
	private boolean isHolding;
	private Ingredient ingredientHeld;
	private Dish dishHeld;
	private Direction faceDirection;
	private int PlayerNumber;
	protected boolean visible;
	
	private static Image player_faceleft = new Image(ClassLoader.getSystemResource("picture/testplayer2.png").toString());
	private static Image player_faceright = new Image(ClassLoader.getSystemResource("picture/testplayer3.png").toString());
	private static Image player_faceup = new Image(ClassLoader.getSystemResource("picture/testplayer4.png").toString());
	private static Image player_facedown = new Image(ClassLoader.getSystemResource("picture/testplayer5.png").toString());
	private static Image player_still_down = new Image(ClassLoader.getSystemResource("picture/player_still_down.png").toString());
	
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
	
//	public getWhereInteract() {
		
//	}
	
	@Override
	public int getZ() {
		return 103;
	}

	@Override
	public void draw(GraphicsContext gc) {
		int pixel = GameScreen.pixel;
		int x = GameScreen.draw_origin_x+this.getX()*pixel;
		int y = (GameScreen.draw_origin_y-16)+this.getY()*pixel;
		
		switch (faceDirection) {
		case LEFT: 
			gc.drawImage(player_faceleft, x, y);
			break;
		case RIGHT:
			gc.drawImage(player_faceright, x, y);
			break;
		case UP:
			gc.drawImage(player_faceup, x, y);
			break;
		case DOWN:
			gc.drawImage(player_facedown, x, y);
			break;
		default:
			gc.drawImage(player_still_down, x, y);
			break;
		}
		
		
	}

	@Override
	public boolean isVisible() {
		return visible;
	}

	@Override
	public void update() {
		if (InputUtility.getKeypressed().contains(KeyCode.W) && this.getPlayerNumber() == 0) {
			this.move(Direction.UP);
		}
		
		if (InputUtility.getKeypressed().contains(KeyCode.S) && this.getPlayerNumber() == 0) {
			this.move(Direction.DOWN);
		}
		
		if (InputUtility.getKeypressed().contains(KeyCode.A) && this.getPlayerNumber() == 0) {
			this.move(Direction.LEFT);
		}
		
		if (InputUtility.getKeypressed().contains(KeyCode.D) && this.getPlayerNumber() == 0) {
			this.move(Direction.RIGHT);
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
	
	public int getPlayerNumber() {
		return PlayerNumber;
	}
}
