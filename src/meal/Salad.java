package meal;

import java.util.ArrayList;

import entity.Cabbage;
import entity.Fish;
import entity.Ingredient;
import entity.Tomato;
import sharedObject.RenderableHolder;

public class Salad extends Menu{
	protected int saladType;

	public Salad(int timeMax,int saladType) {
		super(timeMax);
		if (saladType == 0) {
			setSaladType(saladType);
			setName("Simple Salad");
			setMenuImage(RenderableHolder.menu_simplesalad_Image);
			setPrice(50);
			setMax_score(40);
			
			//set ingredients
			this.ingredients = new ArrayList<Ingredient>();
			Tomato tomatosliced = new Tomato(); tomatosliced.setState(1);
			Cabbage cabbagesliced = new Cabbage(); cabbagesliced.setState(1);
			this.ingredients.add(tomatosliced); this.ingredients.add(cabbagesliced);
			
		} else if (saladType == 1) {
			setSaladType(saladType);
			setName("Sashimi Salad");
			setMenuImage(RenderableHolder.menu_sashimisalad_Image);
			setPrice(90);
			setMax_score(60);
			
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
