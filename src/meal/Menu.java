package meal;

import java.util.ArrayList;

import entity.Ingredient;

public abstract class Menu {
	protected String name;
	protected int price;
	protected int max_score;
	protected ArrayList<Ingredient> ingredients;
	protected int timeleft;
	
	public Menu(int timeleft) {
		setTimeleft(timeleft);
	}
	
	public abstract String toString();
	public abstract String getName();
	public abstract boolean isAllIngredients();

	public int getTimeleft() {
		return timeleft;
	}

	public void setTimeleft(int timeleft) {
		this.timeleft = timeleft;
	}
}
