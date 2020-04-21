package meal;

import java.util.ArrayList;

import entity.Cabbage;
import entity.Dish;
import entity.Fish;
import entity.FishStorage;
import entity.Ingredient;
import entity.Tomato;
import sun.tools.tree.ThisExpression;

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
			
			Tomato tomato = new Tomato();
			tomato.setState(1);
			
			Cabbage cabbage = new Cabbage();
			cabbage.setState(1);
			
			this.ingredients.add(tomato); this.ingredients.add(cabbage);
			
		} else if (saladType == 1) {
			setSaladType(saladType);
			this.name = "Sashimi Salad";
			//set price and max_score
			//set ingredients
			
			this.ingredients = new ArrayList<Ingredient>();
			
			Tomato tomato = new Tomato();
			tomato.setState(1);
			
			Cabbage cabbage = new Cabbage();
			cabbage.setState(1);
			
			Fish fish = new Fish();
			fish.setState(1);
			
			this.ingredients.add(tomato); this.ingredients.add(cabbage); this.ingredients.add(fish);
			
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
