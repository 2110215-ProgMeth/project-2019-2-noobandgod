package meal;

import java.util.ArrayList;

import entity.Cabbage;
import entity.Dish;
import entity.Fish;
import entity.FishStorage;
import entity.Ingredient;
import entity.Tomato;
import sharedObject.RenderableHolder;

public class Salad extends Menu{
	protected int saladType;

	public Salad(int timeleft,int saladType) {
		super(timeleft);
		if (saladType == 0) {
			setSaladType(saladType);
			this.name = "Simple Salad";
			
			//set price and max_score
			
			//set ingredients
			this.ingredients = new ArrayList<Ingredient>();
			Tomato tomatosliced = new Tomato(); tomatosliced.setState(1);
			Cabbage cabbagesliced = new Cabbage(); cabbagesliced.setState(1);
			this.ingredients.add(tomatosliced); this.ingredients.add(cabbagesliced);
			
		} else if (saladType == 1) {
			setSaladType(saladType);
			this.name = "Sashimi Salad";
			this.menuImage = RenderableHolder.menu_sashimisalad_Image;
			
			//set price and max_score
			
			//set ingredients
			this.ingredients = new ArrayList<Ingredient>();
			Tomato tomatosliced = new Tomato(); tomatosliced.setState(1);
			Cabbage cabbagesliced = new Cabbage(); cabbagesliced.setState(1);
			Fish fishsliced = new Fish(); fishsliced.setState(1);
			this.ingredients.add(tomatosliced); this.ingredients.add(cabbagesliced); this.ingredients.add(fishsliced);
			
		} else {
			System.out.println("saladType ERROR!!");
		}
		
	}

	public int getSaladType() {
		return saladType;
	}

	public void setSaladType(int saladType) {
		this.saladType = saladType;
	}
	
	

	
	
}
