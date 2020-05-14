package gui;

import entity.Cabbage;
import entity.Fish;
import entity.Tomato;

public class IngredientItem {
	private String ingredientName;
	private int price;
	
	public IngredientItem(String ingredientName){
		switch(ingredientName) {
		case "Tomato" :		price = Tomato.price;	break;
		case "Cabbage" : 	price = Cabbage.price;  break;
		case "Fish" : 		price = Fish.price;		break;
		}
		setIngredientName(ingredientName);
	}

	public String getIngredientName() {
		return ingredientName;
	}

	public void setIngredientName(String ingredientName) {
		this.ingredientName = ingredientName;
	}

	public int getPrice() {
		return price;
	}
	
	
}
