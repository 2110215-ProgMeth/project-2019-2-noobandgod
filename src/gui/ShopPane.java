package gui;

import java.util.ArrayList;

import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

public class ShopPane extends VBox {
	private ObservableList<IngredientShopBox> ingredientShopBoxs = FXCollections.observableArrayList();
	private Label totalpriceLabel;
	
	public ShopPane(String[] ingredientName) {
		this.setPrefHeight(600);
		this.setPrefWidth(256);
		this.setSpacing(16);
		
		for (String ingredient : ingredientName) {
			IngredientShopBox ingredientShopBox = new IngredientShopBox(ingredient);
			this.ingredientShopBoxs.add(ingredientShopBox);
			this.getChildren().add(ingredientShopBox);
		}
		
		this.totalpriceLabel = new Label("Total price:  "+"0");
		totalpriceLabel.setFont(new Font(16));
		
		
		
		
		
		
		
		this.getChildren().add(totalpriceLabel);
	}
	
	public void calculateTotalPrice() {
		int totalmoney = 0;
		for (IngredientShopBox i: this.ingredientShopBoxs) {
			int price = i.getIngredientItem().getPrice();
			int amount = i.getAmountBox().getAmount();
			totalmoney += price*amount;
		}
		totalpriceLabel.setText("Total price:  "+totalmoney);
		
	}
}
