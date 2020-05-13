package entity;

import entity.base.Block;
import entity.base.Interactable;
import exception.InteractFailedException;
import javafx.scene.canvas.GraphicsContext;
import logic.Sprites;
import screen.GameScreen;
import sharedObject.RenderableHolder;

public class DishPicker extends Block implements Interactable{
    
    public boolean interacts(Player p) throws InteractFailedException{
        if (!p.isHolding()) {
        	p.setEntityHeld(new Dish());
            return true;
        } else {
            throw new InteractFailedException("ERROR");
        }
    }

    public char getSymbol() {
        return Sprites.DishPicker;
    }

    public String toString() {
    	String result = "DISHPICKER";
    	result += "\nLocated at ("+this.getX()+","+this.getY()+")";
    	return result;
    }

    @Override
    public int getZ() {
        return getY()*3;
    }
    
    @Override
    public void draw(GraphicsContext gc) {
        int pixel = GameScreen.pixel;
        int x = GameScreen.draw_origin_x+this.getX()*pixel;
        int y = (GameScreen.draw_origin_y-6)+this.getY()*pixel;

        if(isAnyBlockDownward) {
        	gc.drawImage(RenderableHolder.dishpicker_between_Image, x, y);
        } else {
        	gc.drawImage(RenderableHolder.dishpicker_infront_Image, x, y);
        }
    }
    
    @Override
    public boolean isVisible() {
        return true;
    }
   
}