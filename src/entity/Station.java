package entity;

import entity.base.Block;
import entity.base.Entity;
import entity.base.Interactable;
import exception.InteractFailedException;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.WritableImage;
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
		if (!e.isHolding()) {
			if (isOnStation()) {
				e.setEntityHeld(getOnStationExists());
				setOnStationExists(null);
				e.setHolding(true);
				setOnStation(false);
				return true;
			}
		}else {
			if (e.getEntityHeld() instanceof Dish) {
				Dish dish = (Dish) e.getEntityHeld();
				if (getOnStationExists() instanceof Ingredient) {
					dish.adds(getOnStationExists());
					setOnStationExists(null);
					e.setEntityHeld(dish);
					setOnStation(false);
					return true;
			    }else if (!isOnStation()) {	    	
			    	Dish entity = (Dish) e.removeEntityHeld();
			    	setOnStationExists(entity);
			    	setOnStation(true);
			    	return true;
			    }
			}else {
				if (!isOnStation()) {
					setOnStationExists(e.removeEntityHeld());
					e.removeEntityHeld();
					setOnStation(true);
					return true;
				}else if (getOnStationExists() instanceof Dish) {
					Dish dish1 = (Dish) getOnStationExists();
					dish1.gathers(e);
					setOnStationExists(dish1);
					setOnStation(true);
					return true;
				}
			}
		}return false;
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
		return getY();
	}

	@Override
	public void draw(GraphicsContext gc) {
		int pixel = GameScreen.pixel;
		int x = GameScreen.draw_origin_x+this.getX()*pixel;
		int y = (GameScreen.draw_origin_y-6)+this.getY()*pixel;
		
		//System.out.println("Drawing Station at ("+getX()+","+getY()+")");
		
		if(!isAnyBlockDownward) {
			gc.drawImage(RenderableHolder.station_infront_Image, x, y);
		} else {
			gc.drawImage(RenderableHolder.station_between_Image, x, y);
		}
		
		if(OnStation) {
			if (OnStationExists instanceof Dish) {
				if (((Dish) OnStationExists).getOnDishExists().size() == 0) {
					if(!isAnyBlockDownward) {
						gc.drawImage(RenderableHolder.dish_ontable_empty_Image, x, y+3);
					} else {
						gc.drawImage(RenderableHolder.dish_ontable_empty_Image, x, y+7);
					}
				}
			}
		}
		
	}

	@Override
	public boolean isVisible() {
		return true;
	}

	
}
