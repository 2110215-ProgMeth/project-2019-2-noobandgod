package entity;

import entity.base.Block;
import entity.base.Entity;
import entity.base.Interactable;
import exception.InteractFailedException;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import logic.Sprites;
import screen.GameScreen;

public class DishPicker extends Block implements Interactable{
	private static Image dishpickerbox = new Image(ClassLoader.getSystemResource("picture/boxwithdishtest.png").toString());
	
	public boolean interacts(Player e) throws InteractFailedException{
		//dont forget to throw an exception
		if (!e.isHolding()) {
			Dish dish = new Dish();
			e.setEntityHeld(dish);
			e.setHolding(true);
			return true;
		}throw new InteractFailedException("Please place donw the carried item before picking up a new dish");
	}
	public char getSymbol() {
		return Sprites.DishPicker;
	}
	
	@Override
	public int getZ() {
		return getY();
	}
	@Override
	public void draw(GraphicsContext gc) {
		int pixel = GameScreen.pixel;
		int x = GameScreen.draw_origin_x+this.getX()*pixel;
		int y = (GameScreen.draw_origin_y-6)+this.getY()*pixel;
		
		gc.drawImage(dishpickerbox, x, y);
	}
	@Override
	public boolean isVisible() {
		return true;
	}
	
	
}
