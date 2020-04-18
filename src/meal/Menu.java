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
	
	public abstract boolean isAllIngredients();

	public int getTimeleft() {
		return timeleft;
	}

	public void setTimeleft(int timeleft) {
		this.timeleft = timeleft;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		String a;
		a = "Menu Name: "+this.name+"\n";
		a += "Price: "+this.price+"\n";
		a += "Time left: "+this.timeleft+"\n";
		return a;
	}
	
	
}
