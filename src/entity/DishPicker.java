package entity;

import entity.base.Block;
import entity.base.Entity;
import entity.base.Interactable;
import exception.InteractFailedException;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import logic.Sprites;
import screen.GameScreen;
import sharedObject.RenderableHolder;

public class DishPicker extends Block implements Interactable{
    private static Image dishpickerbox = new Image(ClassLoader.getSystemResource("picture/boxwithdishtest.png").toString());

    public boolean interacts(Player e) throws InteractFailedException{
        if (!e.isHolding()) {
        	System.out.println("Player "+e.getPlayerNumber()+" has taken the dish at DishPicker at ("+this.getX()+","+this.getY()+")");
        	
            Dish dish = new Dish();
            dish.setX(e.getX()); dish.setY(e.getY());
            RenderableHolder.getInstance().add(dish);

            e.setEntityHeld(dish);
            e.setHolding(true);
            return true;
        } else {
            throw new InteractFailedException("Please place donw the carried item before picking up a new dish");
        }
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