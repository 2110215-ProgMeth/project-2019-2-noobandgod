package gui;


import exception.InvalidIngredientNameException;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;

import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import logic.GameController;

public class IngredientStorageBox extends VBox{
	private Pane ingredientPic;
	private Label amountLabel;
	private IngredientItem ingredientItem;
	private String ingredientName;

	public IngredientStorageBox(String ingredientName) {
		super();
		this.setPrefHeight(80);
		this.setPrefWidth(80);
		
		try {
			setIngredientItem(new IngredientItem(ingredientName));
		} catch (InvalidIngredientNameException e) {
			e.printStackTrace();
		}
		
		setIngredientName(ingredientName);
		
		
		this.ingredientPic = new Pane();
		ingredientPic.setPrefHeight(64);
		ingredientPic.setPrefWidth(64);
		
		
		
		int amount = 0;
		
		
		this.amountLabel = new Label("X "+amount);
		amountLabel.setFont(new Font(16));
		
		this.setAlignment(Pos.CENTER);
		this.getChildren().addAll(ingredientPic,amountLabel);

		
		
		
		
		String cssLayout = "-fx-border-color: green;\n" +
                "-fx-border-insets: 2;\n" +
                "-fx-border-width: 1;\n" +
                "-fx-border-style: dashed;\n";
		this.setStyle(cssLayout);
	}

	public IngredientItem getIngredientItem() {
		return ingredientItem;
	}

	public void setIngredientItem(IngredientItem ingredientItem) {
		this.ingredientItem = ingredientItem;
	}

	public String getIngredientName() {
		return ingredientName;
	}

	public void setIngredientName(String ingredientName) {
		this.ingredientName = ingredientName;
	}

	public Label getAmountLabel() {
		return amountLabel;
	}

	public void setAmountLabel(Label amountLabel) {
		this.amountLabel = amountLabel;
	}
	
	
	
	
	
}


