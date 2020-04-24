package gui;

import java.util.ArrayList;

import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

public class ShopPane extends VBox {
	private ObservableList<IngredientShopBox> ingredientShopBoxs = FXCollections.observableArrayList();
	
	public ShopPane(String[] ingredientName) {
		this.setPrefHeight(600);
		this.setPrefWidth(256);
		this.setSpacing(16);
		
		for (String ingredient : ingredientName) {
			IngredientShopBox ingredientShopBox = new IngredientShopBox(ingredient);
			this.ingredientShopBoxs.add(ingredientShopBox);
			this.getChildren().add(ingredientShopBox);
		}
		
		Label totalpriceLabel = new Label("Total price:  "+"0");
		totalpriceLabel.setFont(new Font(16));
		
		ingredientShopBoxs.addListener(new InvalidationListener() {
			@Override
			public void invalidated(Observable arg0) {
				int price = calculateTotalPrice();
				totalpriceLabel.setText("Total price:  "+price);
			}
		});
		
		
		this.getChildren().add(totalpriceLabel);
	}
	
	public int calculateTotalPrice() {
		int totalmoney = 0;
		for (IngredientShopBox i: this.ingredientShopBoxs) {
			int price = i.getIngredientItem().getPrice();
			int amount = i.getAmountBox().getAmount();
			totalmoney += price*amount;
		}
		return totalmoney;
	}
}
