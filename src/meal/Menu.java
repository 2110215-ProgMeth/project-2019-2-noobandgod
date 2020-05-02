package meal;

import java.util.ArrayList;

import entity.Dish;
import entity.Ingredient;
import entity.base.Entity;

public abstract class Menu {
	protected String name;
	protected int price;
	protected int max_score;
	protected ArrayList<Ingredient> ingredients;
	protected int timeleft;
	
	public Menu(int timeleft) {
		setTimeleft(timeleft);
	}
	
	public boolean isAllIngredients(Entity e) {
		Dish d = (Dish) e;
		ArrayList<Ingredient> ondish = d.getOnDishExists();
		
		int numberingredients = this.ingredients.size();
		
		boolean[] checklist = new boolean[numberingredients];
		for (int i=0; i<checklist.length; i++) {
			checklist[i] = false;
		}
		
		if(ondish.size() > numberingredients) {
			System.out.println("Too many ingredients on the dish!");
			return false;
		} else if (ondish.size() < numberingredients) {
			System.out.println("Not enough ingredients");
			return false;
		} else {
			
			for (int i=0; i<numberingredients; i++) {
				for(int j=0; j<numberingredients; j++) {
					if (ondish.get(j).equals(this.ingredients.get(i))) {
						checklist[i] = true;
						break;
					}
				}
			}
		
		for (int i=0; i<checklist.length; i++) {
			if (checklist[i] != true) {
				return false;
			}	
		}
		System.out.println("Ingrdrients Matched");
		return true;	
			
		}
	}

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
	
	public ArrayList<Ingredient> getIngredients() {
		return ingredients;
	}
	
	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getMax_score() {
		return max_score;
	}

	public void setMax_score(int max_score) {
		this.max_score = max_score;
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
