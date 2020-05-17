package entity;

import java.util.ArrayList;
import java.util.Collections;

import entity.base.Entity;
import javafx.scene.canvas.GraphicsContext;
import screen.GameScreen;
import sharedObject.RenderableHolder;

public class Dish extends Entity {
	private ArrayList<Ingredient> onDishExists;
	private boolean isPlaced;
	
	public Dish() {
		setPlaced(false);
		setDestroyed(false);
		this.onDishExists = new ArrayList<Ingredient>();
	}

	public boolean gathers(Player p) { // when the station has a dish and people carry an ingredient
		if (p.isHolding()) {
			if (p.getEntityHeld() instanceof Ingredient ) {
				Ingredient ingredient = (Ingredient) p.getEntityHeld();
				if (ingredient.getState() >= 1) {
					if (!this.onDishExists.contains(ingredient)){
						this.onDishExists.add(ingredient);
						p.removeEntityHeld();
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
	
	public boolean check(Ingredient i) {
		if (i.getState() < 1) {
			//System.out.println("You can't place raw ingredient on a dish!");
			return false;
		}
		if (i instanceof Fish) {//check fish which is different from other types
			if (((Fish) i).getState()==2 && getOnDishExists().size()==0) {
				return true;
			}else if (((Fish) i).getState()==2 && getOnDishExists().size()>=1) {
				return false;
			}
		}
		for (Ingredient ingredient: getOnDishExists()) {//check if this ingredient's type is in the dish.If it is,return false;
			if((i instanceof Tomato && ingredient instanceof Tomato) || 
				(i instanceof Cabbage && ingredient instanceof Cabbage) ||
				(i instanceof Fish && ingredient instanceof Fish)) {
				return false;
			}
		}
		return true;
	}
	
	public String toString() {
		String result = "DISH";
		result += "\nLocated at ("+x+","+y+")";
		result += "\nisPlacedonTable? " + this.isPlaced;
		return result;
	}
	
	
	@Override
	public int getZ() {
		return y*3+2;
	}
	@Override
	public void draw(GraphicsContext gc) {
		int pixel = GameScreen.pixel;
		int X = GameScreen.draw_origin_x+this.getX()*pixel;
		int Y = GameScreen.draw_origin_y+this.getY()*pixel;
		
		if(!isPlaced) {
			if(onDishExists.size() == 0) {
				gc.drawImage(RenderableHolder.dish_onhead_empty_Image, X, Y-30);
			}

			if (onDishExists.size() == 1) {// dish with one ingredient
				gc.drawImage(RenderableHolder.dish_onhead_empty_Image, X, Y-30);
				
				if ((onDishExists.get(0) instanceof Tomato)) { //dish with sliced tomato
					gc.drawImage(RenderableHolder.tomato_sliced_Image, X+12, Y-42, 40, 32);
			
				}else if ((onDishExists.get(0) instanceof Cabbage)) { //dish with sliced cabbage
					gc.drawImage(RenderableHolder.cabbage_sliced_Image, X, Y-30);
					
				}else if((onDishExists.get(0) instanceof Fish)) {//dish with fish
					if (((Fish) onDishExists.get(0)).getState() == 1){//fish state1
						gc.drawImage(RenderableHolder.fish_sliced_Image, X+11, Y-38, 42, 28);
						
					} else  if (((Fish) onDishExists.get(0)).getState() == 2){//fish state2
						gc.drawImage(RenderableHolder.fish_fried_Image, X+11, Y-35, 45, 30);
					}
				}
			} else if (onDishExists.size() == 2) {
					ArrayList<String> ondish = new ArrayList<>();
					for (Ingredient i : onDishExists) {
						ondish.add(Ingredient.getString(i));
					}Collections.sort(ondish);
					if (ondish.get(0).equals("Cabbage")) {
						if (ondish.get(1).equals("Fish")) {//cabbage and fish both state 1
							gc.drawImage(RenderableHolder.dish_onhead_empty_Image, X, Y-30);
							gc.drawImage(RenderableHolder.cabbage_sliced_Image, X, Y-30);
							gc.drawImage(RenderableHolder.fish_sliced_Image, X+15, Y-35, 32, 20);
							
						} else if(ondish.get(1).equals("Tomato")) {//cabbage add tomato = simplesalad
							gc.drawImage(RenderableHolder.dish_onhead_simplesalad_Image, X, Y-35);
						}
						
						} else { //Tomato and fish sliced
							gc.drawImage(RenderableHolder.dish_onhead_empty_Image, X, Y-30);
							gc.drawImage(RenderableHolder.tomato_sliced_Image, X+2, Y-37, 32, 20);
							gc.drawImage(RenderableHolder.fish_sliced_Image, X+22, Y-30, 32, 20);
						}
					
			} else if (onDishExists.size() == 3){ //sashimi salad
				gc.drawImage(RenderableHolder.dish_onhead_sashimisalad_Image, X, Y-35);
			}
		}
		
	}
	@Override
	public boolean isVisible() {
		return !isDestroyed;
	}
	
	public boolean isPlaced() {
		return isPlaced;
	}

	public void setPlaced(boolean isPlaced) {
		this.isPlaced = isPlaced;
	}
	
	public ArrayList<Ingredient> getOnDishExists() {
		return this.onDishExists;
	}

}