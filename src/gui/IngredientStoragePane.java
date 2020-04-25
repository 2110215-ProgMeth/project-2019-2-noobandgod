package gui;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.layout.HBox;



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
		}
		
	}

