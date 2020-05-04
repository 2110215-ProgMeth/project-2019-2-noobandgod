package entity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import entity.base.Block;
import entity.base.Entity;
import entity.base.Interactable;
import exception.InteractFailedException;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.WritableImage;
import logic.GameController;
import logic.Sprites;
import screen.GameScreen;
import sharedObject.RenderableHolder;


public class Station extends Block implements Interactable{

	private Entity OnStationExists;
	private boolean OnStation;
	public Station() {
		setOnStationExists(null);
		setOnStation(false);
	}
	
	
	public boolean isOnStation() {
		return OnStation;
	}


	public void setOnStation(boolean isOnStation) {
		OnStation = isOnStation;
	}


	public boolean interacts(Player e) throws InteractFailedException{
		if (!e.isHolding()) { //if player's hand is available to pick something
			if (isOnStation()) {
				Entity ontableEntity_clone = this.removedEntityOnStation();
				e.setEntityHeld(ontableEntity_clone);
				//set the entity in our hand (isPlaced = false)
				if (ontableEntity_clone instanceof Dish) {
					((Dish) ontableEntity_clone).setPlaced(false);
				} else if (ontableEntity_clone instanceof Ingredient) {
					((Ingredient) ontableEntity_clone).setPlaced(false);
				}
				return true;
			}
		}else {
			//if on player's hand is DISH
			if (e.getEntityHeld() instanceof Dish) {
				Dish dish = (Dish) e.getEntityHeld();
				if (getOnStationExists() instanceof Ingredient) {
					if(dish.check((Ingredient) getOnStationExists())) {
						Entity ontableEntity_clone = this.removedEntityOnStation();
						dish.adds((Ingredient) ontableEntity_clone);
						e.setEntityHeld(dish);
						dish.setPlaced(false);//dish on hand and ingredient on station.I think the ingredient has added to the dish so the setPlae must be used in type of dish
						return true;
					}
			    }else if (!isOnStation()) {	  
			    	//if the station is available -> PLACE THE DISH
			    	dish.setPlaced(true); 
			    	Dish dish1 = (Dish) e.removeEntityHeld();
			    	dish1.setX(this.getX()); 
			    	dish1.setY(this.getY());
			    	RenderableHolder.getInstance().add(dish1);
			    	setOnStationExists(dish1);
			    	setOnStation(true);
			    	dish1.setPlaced(true);
			    	return true;
			    }
			}else {// player's hand is Ingredient
				if (!isOnStation()) {//empty station
					Entity entity_clone = e.removeEntityHeld();
					setOnStationExists((Ingredient)entity_clone);
					setOnStation(true);
					((Ingredient) entity_clone).setPlaced(true);
					return true;
				}else if (getOnStationExists() instanceof Dish) {//It has a dish on station already so it doesn't have to setPlace
					Dish dish1 = (Dish) getOnStationExists();
					if (dish1.check((Ingredient) e.getEntityHeld())) {
						dish1.gathers(e);
						setOnStationExists(dish1);
						return true;
					}
				}	
			}
			
		}return false;
	}
	
	public Entity removedEntityOnStation() {
		setOnStation(false);
		Entity removedEntity = (Entity) getOnStationExists().clone();
		
		getOnStationExists().setDestroyed(true);
		setOnStationExists(null);
		return removedEntity;
	}
	

	public Entity getOnStationExists() {
		return OnStationExists;
	}
	public void setOnStationExists(Entity onStationExists) {
		OnStationExists = onStationExists;
	}
	public char getSymbol() {
		return Sprites.Station;
	}
	
	public String toString() {
		String result = "STATION";
		result += "\nLocated at ("+this.getX()+","+this.getY()+")";
		result += "\nisAnyBlockDownward: "+isAnyBlockDownward;
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
		int y = GameScreen.draw_origin_y+this.getY()*pixel;
		
		//System.out.println("Drawing Station at ("+getX()+","+getY()+")");
		
		if(!isAnyBlockDownward) {
			gc.drawImage(RenderableHolder.station_infront_Image, x, y-6);
		} else {
			gc.drawImage(RenderableHolder.station_between_Image, x, y-6);
		}
		
		if(OnStation) {
			if (OnStationExists instanceof Dish) {//with dish
				if (((Dish) OnStationExists).getOnDishExists().size() == 0) {
					if(!isAnyBlockDownward) {
						gc.drawImage(RenderableHolder.dish_ontable_empty_Image, x, y);
					} else {
						gc.drawImage(RenderableHolder.dish_ontable_empty_Image, x, y);
					}
				}else if (((Dish) OnStationExists).getOnDishExists().size() == 1) {// dish with one ingredient
					if (((Dish) OnStationExists).getOnDishExists().get(0) instanceof Tomato) {//dish with tomato
							//gc.drawImage(RenderableHolder.dish_ontable_empty_Image, x, y+5);
				
					}else if (((Dish) OnStationExists).getOnDishExists().get(0) instanceof Cabbage) {//dish with cabbage
							//gc.drawImage(RenderableHolder.dish_ontable_empty_Image, x, y+5);
					}else if(((Dish) OnStationExists).getOnDishExists().get(0) instanceof Fish) {//dish with fish
						if (((Fish) ((Dish) OnStationExists).getOnDishExists().get(0)).getState()==1){//fish state1
							//gc.drawImage(RenderableHolder.dish_ontable_empty_Image, x, y+5);
						}else {//fish state2
							//gc.drawImage(RenderableHolder.dish_ontable_empty_Image, x, y+5);
						}
					}
				}else if (((Dish) OnStationExists).getOnDishExists().size() == 2) {
						ArrayList<String> ondish = new ArrayList<>();
						for (Ingredient i : ((Dish) OnStationExists).getOnDishExists()) {
							ondish.add(Ingredient.getString(i));
						}Collections.sort(ondish);
						if (ondish.get(0).equals("Cabbage")) {
							if (ondish.get(1).equals("Fish")) {//cabbage and fish both state 1
								//gc.drawImage(RenderableHolder.dish_ontable_empty_Image, x, y+9);
							}else if(ondish.get(1).equals("Tomato")) {//cabbage adn tomato
								//gc.drawImage(RenderableHolder.dish_ontable_empty_Image, x, y+9);
							}
						}else {//Tomato and fish
							//gc.drawImage(RenderableHolder.dish_ontable_empty_Image, x, y+9);
						}
				}else if (((Dish) OnStationExists).getOnDishExists().size() == 3){//sahimmi salad
					//gc.drawImage(RenderableHolder.dish_ontable_empty_Image, x, y+9);
				}
				
			}else if (OnStationExists instanceof Tomato) {//tomato pure
				if (((Tomato) OnStationExists).getState()==0){//tomato state 0
					if (!isAnyBlockDownward) {
						gc.drawImage(RenderableHolder.tomato_Image, x, y-3);
					} else {
						gc.drawImage(RenderableHolder.tomato_Image, x, y-1,64,48);
					}
				}else {//tomato state1
					if(isAnyBlockDownward) {
						gc.drawImage(RenderableHolder.tomato_sliced_Image, x+10, y+5);
					} else {
						gc.drawImage(RenderableHolder.tomato_sliced_Image, x+10, y);
					}	
				}
				
			}else if (OnStationExists instanceof Cabbage) {//cabbage pure
				if (((Cabbage) OnStationExists).getState()==0){//cabbage state 0
					if (!isAnyBlockDownward) {
						gc.drawImage(RenderableHolder.cabbage_Image, x, y-1);
					} else {
						gc.drawImage(RenderableHolder.cabbage_Image, x, y+2,64,48);
					}	
				}else {//cabbage state1
					gc.drawImage(RenderableHolder.cabbage_sliced_Image, x, y+5);
				}
				
			}else if(OnStationExists instanceof Fish) {//pure fish
				if (((Fish) OnStationExists).getState()==0){//fish state 0
					if (!isAnyBlockDownward) {
						gc.drawImage(RenderableHolder.fish_Image, x, y+5);
					} else {
						gc.drawImage(RenderableHolder.fish_Image, x, y+10);
					}
				}else if (((Fish) OnStationExists).getState()==1) {//fish state1
					gc.drawImage(RenderableHolder.fish_sliced_Image, x+5, y+5);
				}else {//fish state2 friedfish
					//gc.drawImage(RenderableHolder.dish_ontable_empty_Image, x, y+5);
				}
			}
		}
		
	}



	@Override
	public boolean isVisible() {
		return true;
	}

	
}
