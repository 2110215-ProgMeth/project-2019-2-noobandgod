package gui;

import exception.InvalidIngredientNameException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import logic.GameController;

public class IngredientStoragePane extends HBox{
	private ObservableList<IngredientStorageBox> ingredientStorageBoxs = FXCollections.observableArrayList();
	
	
	
	public IngredientStoragePane(String[] ingredientName) {
		
		this.setPrefHeight(100);
		this.setPrefWidth(250);
		this.setSpacing(16);
		for (String ingredient : ingredientName) {
			IngredientStorageBox ingredientStorageBox = new IngredientStorageBox(ingredient);
			this.ingredientStorageBoxs.add(ingredientStorageBox);
			this.getChildren().add(ingredientStorageBox);
		}
		
		updateIngredientAmount();
		
	}
	
	public void updateIngredientAmount() {
		for (IngredientStorageBox i: ingredientStorageBoxs) {
			switch (i.getIngredientName()) {
			case "Tomato":
				i.getAmountLabel().setText(Integer.toString(GameController.getTomato_AMOUNT()));
				break;
			case "Cabbage":
				i.getAmountLabel().setText(Integer.toString(GameController.getCabbage_AMOUNT()));
				break;
			case "Fish":
				i.getAmountLabel().setText(Integer.toString(GameController.getFish_AMOUNT()));
				break;
			}
		}
		
		
	}
		
}

