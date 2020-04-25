package gui;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;

public class IngredientStorageBox extends HBox{
	private Pane ingredientPic;
	private AmountBox amountBox;
	public IngredientStorageBox(String ingredientName) {
		super();
		this.setPrefHeight(128);
		this.setPrefWidth(128);
		this.setPadding(new Insets(8));
		
		Label nameLabel = new Label(ingredientName);
		nameLabel.setFont(new Font(16));
		
	//	this.ingredientItem = new IngredientItem(ingredientName);
		
		Pane ingredientPic = new Pane();
		ingredientPic.setPrefHeight(64);
		ingredientPic.setPrefWidth(64);
		
//		Label priceLabel = new Label("Price per piece: "+ingredientItem.getPrice());
		
		this.amountBox = new AmountBox();

//		this.getChildren().addAll(nameLabel,ingredientPic,priceLabel,amountBox);
		this.setAlignment(Pos.CENTER);
		
		
		
		
		String cssLayout = "-fx-border-color: green;\n" +
                "-fx-border-insets: 2;\n" +
                "-fx-border-width: 1;\n" +
                "-fx-border-style: dashed;\n";
		this.setStyle(cssLayout);
	}
	public AmountBox getAmountBox() {
		return amountBox;
	}
	
	
	
}

	
}
