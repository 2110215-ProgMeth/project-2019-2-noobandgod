package entity;

import java.util.ArrayList;
import java.util.Collections;

import entity.base.Block;
import entity.base.Entity;
import entity.base.Interactable;
import exception.InteractFailedException;
import javafx.scene.canvas.GraphicsContext;
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
	
	public boolean interacts(Player p) throws InteractFailedException{
		if (!p.isHolding()) { //if player's hand is available to pick something
			if (isOnStation()) {
				Entity ontableEntity_clone = this.removedEntityOnStation();
				p.setEntityHeld(ontableEntity_clone);
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
			if (p.getEntityHeld() instanceof Dish) {
				Dish dish = (Dish) p.getEntityHeld();
				if (getOnStationExists() instanceof Ingredient) {
					if(dish.check((Ingredient) getOnStationExists())) {
						Entity ontableEntity_clone = this.removedEntityOnStation();
						dish.adds((Ingredient) ontableEntity_clone);
						p.setEntityHeld(dish);
						dish.setPlaced(false);//dish on hand and ingredient on station.I think the ingredient has added to the dish so the setPlae must be used in type of dish
						return true;
					}
			    }else if (!isOnStation()) {	  
			    	//if the station is available -> PLACE THE DISH
			    	dish.setPlaced(true); 
			    	Dish dish1 = (Dish) p.removeEntityHeld();
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
					if (((Ingredient) p.getEntityHeld()).getState() == 0) {
						Entity entity_clone = p.removeEntityHeld();
						entity_clone.setX(this.getX());
						entity_clone.setY(this.getY());
						RenderableHolder.getInstance().add(entity_clone);
						setOnStationExists((Ingredient)entity_clone);
						setOnStation(true);
						((Ingredient) entity_clone).setPlaced(true);
						return true;
					} else {
						throw new InteractFailedException("ERROR");
					}
				
				} else if (getOnStationExists() instanceof Dish) {//It has a dish on station already so it doesn't have to setPlace
					Dish dish1 = (Dish) getOnStationExists();
					if (dish1.check((Ingredient) p.getEntityHeld())) {
						dish1.gathers(p);
						setOnStationExists(dish1);
						return true;
					}
				}	
			}
			
		}throw new InteractFailedException("ERROR");
	}
	
	public Entity removedEntityOnStation() {
		setOnStation(false);
		Entity removedEntity = (Entity) getOnStationExists().clone();
		
		getOnStationExists().setDestroyed(true);
		
		Entity onstationEntity = getOnStationExists();
		onstationEntity = null;
		
		setOnStationExists(null);
		return removedEntity;
	}
	
	public String toString() {
		String result = "STATION";
		result += "\nLocated at ("+x+","+y+")";
		result += "\nisAnyBlockDownward: "+isAnyBlockDownward;
		return result;
	}

	public char getSymbol() {
		return Sprites.Station;
	}
	
	@Override
	public int getZ() {
		return y*3;
	}

	@Override
	public void draw(GraphicsContext gc) {
		int pixel = GameScreen.pixel;
		int X = GameScreen.draw_origin_x+x*pixel;
		int Y = GameScreen.draw_origin_y+y*pixel;
		
		if(!isAnyBlockDownward) {
			gc.drawImage(RenderableHolder.station_infront_Image, X, Y-6);
		} else {
			gc.drawImage(RenderableHolder.station_between_Image, X, Y-6);
		}
		
		if(OnStation) {
			if (OnStationExists instanceof Dish) {//with dish
				if (((Dish) OnStationExists).getOnDishExists().size() == 0) { //empty dish
					if(!isAnyBlockDownward) {
						gc.drawImage(RenderableHolder.dish_ontable_empty_Image, X, Y-4);
					} else {
						gc.drawImage(RenderableHolder.dish_ontable_empty_Image, X, Y);
					}
				}
				
				if (((Dish) OnStationExists).getOnDishExists().size() == 1) {// dish with one ingredient
					if(!isAnyBlockDownward) {
						gc.drawImage(RenderableHolder.dish_ontable_empty_Image, X, Y-4);
					} else {
						gc.drawImage(RenderableHolder.dish_ontable_empty_Image, X, Y);
					}
					
					if (((Dish) OnStationExists).getOnDishExists().get(0) instanceof Tomato) {//dish with sliced tomato
						gc.drawImage(RenderableHolder.tomato_sliced_Image, X+10, Y-2);
							
					}else if (((Dish) OnStationExists).getOnDishExists().get(0) instanceof Cabbage) {//dish with cabbage
						gc.drawImage(RenderableHolder.cabbage_sliced_Image, X, Y+5);
					
					}else if(((Dish) OnStationExists).getOnDishExists().get(0) instanceof Fish) {//dish with fish
						if (((Fish) ((Dish) OnStationExists).getOnDishExists().get(0)).getState() == 1){//fish state1
							gc.drawImage(RenderableHolder.fish_sliced_Image, X+12, Y+3, 42, 28);
							
						}else if (((Fish) ((Dish) OnStationExists).getOnDishExists().get(0)).getState() == 2){//fish state2
							if(isAnyBlockDownward) {
								gc.drawImage(RenderableHolder.fish_fried_Image, X+10, Y+3, 45, 35);
							} else {
								gc.drawImage(RenderableHolder.fish_fried_Image, X+10, Y+1, 45, 35);
							}
							
						}
					}
				}else if (((Dish) OnStationExists).getOnDishExists().size() == 2) {
						ArrayList<String> ondish = new ArrayList<>();
						for (Ingredient i : ((Dish) OnStationExists).getOnDishExists()) {
							ondish.add(Ingredient.getString(i));
						}Collections.sort(ondish);
						if (ondish.get(0).equals("Cabbage")) {
							if (ondish.get(1).equals("Fish")) {//cabbage and fish both state 1
								if(!isAnyBlockDownward) {
									gc.drawImage(RenderableHolder.dish_ontable_empty_Image, X, Y-4);
								} else {
									gc.drawImage(RenderableHolder.dish_ontable_empty_Image, X, Y);
								}
								gc.drawImage(RenderableHolder.cabbage_sliced_Image, X, Y+5, 64, 31);
								gc.drawImage(RenderableHolder.fish_sliced_Image, X+15, Y+2, 34, 20);
								
							}else if(ondish.get(1).equals("Tomato")) {//cabbage add tomato (sliced) = simple salad
								if(isAnyBlockDownward) {
									gc.drawImage(RenderableHolder.dish_ontable_simplesalad_Image, X, Y-3);
								} else {
									gc.drawImage(RenderableHolder.dish_ontable_simplesalad_Image, X, Y-8, 64, 50);
								}
								
							}
						}else { //Tomato and fish sliced
							if(!isAnyBlockDownward) {
								gc.drawImage(RenderableHolder.dish_ontable_empty_Image, X, Y-4);
								gc.drawImage(RenderableHolder.tomato_sliced_Image, X+5, Y, 32, 20);
								gc.drawImage(RenderableHolder.fish_sliced_Image, X+24, Y+10, 32, 20);
							} else {
								gc.drawImage(RenderableHolder.dish_ontable_empty_Image, X, Y);
								gc.drawImage(RenderableHolder.tomato_sliced_Image, X+5, Y+3, 32, 20);
								gc.drawImage(RenderableHolder.fish_sliced_Image, X+24, Y+13, 32, 20);
							}
							
						}
				}else if (((Dish) OnStationExists).getOnDishExists().size() == 3){//sashimi salad
					if(isAnyBlockDownward) {
						gc.drawImage(RenderableHolder.dish_ontable_sashimisalad_Image, X, Y-3);
					} else {
						gc.drawImage(RenderableHolder.dish_ontable_sashimisalad_Image, X, Y-8, 64, 50);
					}
				}
				
			//Note that you can't place cooked ingredient on station without dish!	
				
			}else if (OnStationExists instanceof Tomato) {//tomato pure
				if (((Tomato) OnStationExists).getState() == 0){//tomato state 0
					if (!isAnyBlockDownward) {
						gc.drawImage(RenderableHolder.tomato_Image, X, Y-3);
					} else {
						gc.drawImage(RenderableHolder.tomato_Image, X, Y-1,64,48);
					}
				}
				
			}else if (OnStationExists instanceof Cabbage) {//cabbage pure
				if (((Cabbage) OnStationExists).getState()==0){//cabbage state 0
					if (!isAnyBlockDownward) {
						gc.drawImage(RenderableHolder.cabbage_Image, X, Y-1);
					} else {
						gc.drawImage(RenderableHolder.cabbage_Image, X, Y+2,64,48);
					}
				}
				
			}else if(OnStationExists instanceof Fish) {//pure fish
				if (((Fish) OnStationExists).getState()==0){//fish state 0
					if (!isAnyBlockDownward) {
						gc.drawImage(RenderableHolder.fish_Image, X, Y+5);
					} else {
						gc.drawImage(RenderableHolder.fish_Image, X, Y+10);
					}
				}
			}
		}
	}

	@Override
	public boolean isVisible() {
		return true;
	}
	
	public boolean isOnStation() {
		return OnStation;
	}

	public void setOnStation(boolean isOnStation) {
		OnStation = isOnStation;
	}
	
	public Entity getOnStationExists() {
		return OnStationExists;
	}
	public void setOnStationExists(Entity onStationExists) {
		OnStationExists = onStationExists;
	}
	
}
