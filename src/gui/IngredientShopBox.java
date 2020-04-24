package gui;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

public class IngredientShopBox extends VBox{
	private Pane ingredientPic;
	
	public IngredientShopBox(String ingredientName) {
		super();
		this.setPrefHeight(128);
		this.setPrefWidth(128);
		this.setPadding(new Insets(8));
		
		Label nameLabel = new Label(ingredientName);
		
		IngredientItem ingredientItem = new IngredientItem(ingredientName);
		//Pane ingredientPic = new Pane();
		//ingredientPic.setPrefHeight(64);
		//ingredientPic.setPrefWidth(64);
		
		Label priceLabel = new Label("Price per piece: "+ingredientItem.getPrice());
		
		AmountBox amountBox = new AmountBox();

		this.getChildren().addAll(nameLabel,priceLabel,amountBox);
		this.setAlignment(Pos.CENTER);
		
		
		
		
		String cssLayout = "-fx-border-color: red;\n" +
                "-fx-border-insets: 2;\n" +
                "-fx-border-width: 1;\n" +
                "-fx-border-style: dashed;\n";
		this.setStyle(cssLayout);
	}
	
}
