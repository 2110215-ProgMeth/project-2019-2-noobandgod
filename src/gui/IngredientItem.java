package gui;

import entity.Cabbage;
import entity.Fish;
import entity.Tomato;
import exception.InvalidIngredientNameException;

public class IngredientItem {
	private String ingredientName;
	private String url;
	private int price;
	
	public IngredientItem(String ingredientName) throws InvalidIngredientNameException{
		switch(ingredientName) {
		case "Tomato" :		url = "Tomato.png"; 	price = Tomato.getPrice();	break;
		case "Cabbage" : 	url = "Cabbage.png"; 	price = Cabbage.getPrice(); break;
		case "Fish" : 		url = "Fish.png"; 		price = Fish.getPrice();	break;
		default: 
			throw new InvalidIngredientNameException("ERROR: There is no ingredientName "+ingredientName+" in this game");
		}
		setIngredientName(ingredientName);
	}

	public String getIngredientName() {
		return ingredientName;
	}

	public void setIngredientName(String ingredientName) {
		this.ingredientName = ingredientName;
	}

	public String getUrl() {
		return url;
	}

	public int getPrice() {
		return price;
	}
	
	
}
