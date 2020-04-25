package gui;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

public class IngredientShopBox extends VBox{
	private Pane ingredientPic;
	private AmountBox amountBox;
	private IngredientItem ingredientItem;
	private String ingredientName;
	
	public IngredientShopBox(String ingredientName) {
		super();
		setIngredientName(ingredientName);
		
		this.setPrefHeight(128);
		this.setPrefWidth(128);
		this.setPadding(new Insets(8));
		
		Label nameLabel = new Label(ingredientName);
		nameLabel.setFont(new Font(16));
		
		this.ingredientItem = new IngredientItem(ingredientName);
		
		Pane ingredientPic = new Pane();
		ingredientPic.setPrefHeight(64);
		ingredientPic.setPrefWidth(64);
		
		Label priceLabel = new Label("Price per piece: "+ingredientItem.getPrice());
		
		this.amountBox = new AmountBox();

		this.getChildren().addAll(nameLabel,ingredientPic,priceLabel,amountBox);
		this.setAlignment(Pos.CENTER);
		
		
		
		
		String cssLayout = "-fx-border-color: green;\n" +
                "-fx-border-insets: 2;\n" +
                "-fx-border-width: 1;\n" +
                "-fx-border-style: dashed;\n";
		this.setStyle(cssLayout);
	}

	public IngredientItem getIngredientItem() {
		return ingredientItem;
	}

	public AmountBox getAmountBox() {
		return amountBox;
	}

	public void setIngredientName(String ingredientName) {
		this.ingredientName = ingredientName;
	}
	
	
	
}
