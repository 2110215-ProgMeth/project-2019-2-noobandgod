package gui;

import java.util.ArrayList;

import javafx.geometry.Insets;
import javafx.scene.layout.VBox;

public class ShopPane extends VBox {
	private ArrayList<IngredientShopBox> ingredientShopBoxs;
	
	public ShopPane(String[] ingredientName) {
		this.setPrefHeight(600);
		this.setPrefWidth(256);
		this.setSpacing(16);
		
		this.ingredientShopBoxs = new ArrayList<IngredientShopBox>();
		for (String ingredient : ingredientName) {
			IngredientShopBox ingredientShopBox = new IngredientShopBox(ingredient);
			this.ingredientShopBoxs.add(ingredientShopBox);
			this.getChildren().add(ingredientShopBox);
		}
		
		
		
	}
}
