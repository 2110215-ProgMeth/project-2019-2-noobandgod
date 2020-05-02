package entity;

import entity.base.Block;
import entity.base.Consumable;
import entity.base.Entity;
import entity.base.Interactable;
import exception.ConsumeFailedException;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import logic.Sprites;
import screen.GameScreen;

public class Bin extends Block implements Consumable,Interactable{
	private static Image bintest = new Image(ClassLoader.getSystemResource("picture/bintest.png").toString());
	
	public boolean interacts(Player e) {
		return e.isHolding();
	}
	public boolean consumes(Player e) throws ConsumeFailedException{
		if (interacts(e)) {
			e.setEntityHeld(null);
			e.setHolding(false);
			return true;
		}else{
			throw new ConsumeFailedException("There is nothing to be cast");//throw an exception; nothing to be consumed
		}
	}
	public char getSymbol() {
		return Sprites.Bin;
	}
	@Override
	public int getZ() {
		return getY()*3;
	}
	@Override
	public void draw(GraphicsContext gc) {
		int pixel = GameScreen.pixel;
		int x = GameScreen.draw_origin_x+this.getX()*pixel;
		int y = (GameScreen.draw_origin_y)+this.getY()*pixel;
		
		gc.drawImage(bintest, x, y);
		
	}
	@Override
	public boolean isVisible() {
		return true;
	}
}
