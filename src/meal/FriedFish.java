package meal;

import java.util.ArrayList;

import entity.Fish;
import entity.Ingredient;
import sharedObject.RenderableHolder;

public class FriedFish extends Menu{

	public FriedFish(int timeMax) {
		super(timeMax);
		this.name = "Fried Fish";
		this.menuImage = RenderableHolder.menu_friedfish_Image;
		//set price and max score
		
		//set ingredients
		this.ingredients = new ArrayList<Ingredient>();
		Fish fishfried = new Fish(); fishfried.setState(2);
		this.ingredients.add(fishfried);
	}

}
