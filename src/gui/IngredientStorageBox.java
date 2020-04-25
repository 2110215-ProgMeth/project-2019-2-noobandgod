package gui;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;

import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

public class IngredientStorageBox extends VBox{
	private Pane ingredientPic;
	private int cabbageAmount =0;
	private int tomatoAmount=0;
	private int fishAmount=0;

	public IngredientStorageBox(String ingredient) {
		super();
		this.setPrefHeight(80);
		this.setPrefWidth(80);
		
		
	//	this.ingredientItem = new IngredientItem(ingredientName);
		
		Pane ingredientPic = new Pane();
		ingredientPic.setPrefHeight(64);
		ingredientPic.setPrefWidth(64);
		int amount=0;
		if (ingredient.equals("Fish")) {
			amount = getFishAmount();
		}else if (ingredient.equals("Tomato")) {
			amount = getTomatoAmount();
		}else if (ingredient.equals("Cabbage")) {
			amount = getCabbageAmount();
		}
		Label amountLabel = new Label("X "+amount);
		amountLabel.setFont(new Font(16));
		
//		Label priceLabel = new Label("Price per piece: "+ingredientItem.getPrice());
		amountLabel.setAlignment(Pos.CENTER);
		this.getChildren().addAll(ingredientPic,amountLabel);

		
		
		
		
		String cssLayout = "-fx-border-color: green;\n" +
                "-fx-border-insets: 2;\n" +
                "-fx-border-width: 1;\n" +
                "-fx-border-style: dashed;\n";
		this.setStyle(cssLayout);
	}
	public int getTomatoAmount() {
		return tomatoAmount;
	}
	public void setTomatoAmount(int tomatoAmount) {
		this.tomatoAmount = tomatoAmount;
	}
	public int getCabbageAmount() {
		return cabbageAmount;
	}
	public void setCabbageAmount(int cabbageAmount) {
		this.cabbageAmount = cabbageAmount;
	}
	public int getFishAmount() {
		return fishAmount;
	}
	public void setFishamount(int fishamount) {
		this.fishAmount = fishamount;
	}
	
	
	
}


