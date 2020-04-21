package meal;

import java.util.ArrayList;

import entity.Fish;
import entity.Ingredient;

public class FriedFish extends Menu{

	public FriedFish(int timeleft) {
		super(timeleft);
		this.name = "Fried Fish";
		
		//set price and max score
		
		//set ingredients
		this.ingredients = new ArrayList<Ingredient>();
		Fish fishfried = new Fish(); fishfried.setState(2);
		this.ingredients.add(fishfried);
	}

}
