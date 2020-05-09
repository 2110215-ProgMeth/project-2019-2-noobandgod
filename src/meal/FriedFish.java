package meal;

import java.util.ArrayList;

import entity.Fish;
import entity.Ingredient;
import sharedObject.RenderableHolder;

public class FriedFish extends Menu{

	public FriedFish(int timeMax) {
		super(timeMax);
		setName("Fried Fish");
		setMenuImage(RenderableHolder.menu_friedfish_Image);
		setPrice(45);
		setMax_score(30);
		
		//set ingredients
		this.ingredients = new ArrayList<Ingredient>();
		Fish fishfried = new Fish(); fishfried.setState(2);
		this.ingredients.add(fishfried);
	}

}
