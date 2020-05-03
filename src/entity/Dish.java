package entity;

import java.util.ArrayList;

import entity.base.Entity;
import entity.base.Interactable;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import screen.GameScreen;
import sharedObject.RenderableHolder;

public class Dish extends Entity {
	private ArrayList<Ingredient> onDishExists;
	
	public Dish() {
		setDestroyed(false);
		this.onDishExists = new ArrayList<Ingredient>();
	}

	public boolean gathers(Player e) { // when the station has a dish and people carry an ingredient
		if (e.isHolding()) {
			if (e.getEntityHeld() instanceof Ingredient ) {
				Ingredient ingredient = (Ingredient) e.getEntityHeld();
				if (ingredient.getState() >= 1) {
					if (!this.onDishExists.contains(ingredient)){
						this.onDishExists.add(ingredient);
						e.removeEntityHeld();
						return true;
					}
				}
			}
		}return false;
	}
	
	public void adds(Entity e) {
		if (e instanceof Fish) {
			Fish fish = (Fish) e;
			this.onDishExists.add(fish);
		}else if (e instanceof Cabbage) {
			Cabbage cabbage = (Cabbage) e;
			this.onDishExists.add(cabbage);
		}else if (e instanceof Tomato) {
			Tomato tomato = (Tomato) e;
			this.onDishExists.add(tomato);
		}
	}
	
	public String toString() {
		String result = "DISH";
		return result;
	}
	
	
	public ArrayList<Ingredient> getOnDishExists() {
		return this.onDishExists;
	}
	
	@Override
	public int getZ() {
		return getY()*3+2;
	}
	@Override
	public void draw(GraphicsContext gc) {
		int pixel = GameScreen.pixel;
		int x = GameScreen.draw_origin_x+this.getX()*pixel;
		int y = (GameScreen.draw_origin_y-30)+this.getY()*pixel;
		
		gc.drawImage(RenderableHolder.dish_ontable_empty_Image, x, y);
		
	}
	@Override
	public boolean isVisible() {
		return !isDestroyed();
	}
}