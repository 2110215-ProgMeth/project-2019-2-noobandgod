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

    public boolean interacts(Player p) throws InteractFailedException{
        if (!p.isHolding()) {
        	System.out.println("Player "+p.getPlayerNumber()+" has taken the dish at DishPicker at ("+this.getX()+","+this.getY()+")");
        	p.addHoldingEntity(new Dish());
            
            return true;
        } else {
        	System.out.println("You can't take more dish, because you hands aren't available!");
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