package gui;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;

public class IngredientStoragePane extends HBox{
	//private ObservableList<IngredientShopBox> ingredientShopBoxs = FXCollections.observableArrayList();
	private Label totalpriceLabel;
	
	public IngredientStoragePane(String[] ingredientName) {
		this.setPrefHeight(100);
		this.setPrefWidth(250);
		this.setSpacing(16);
		
	}
}
//		
//		for (String ingredient : ingredientName) {
//			IngredientShopBox ingredientShopBox = new IngredientShopBox(ingredient);
//			this.ingredientShopBoxs.add(ingredientShopBox);
//			this.getChildren().add(ingredientShopBox);
//		}
//		
//		this.totalpriceLabel = new Label("Total price:  "+"0");
//		totalpriceLabel.setFont(new Font(16));
//		
//		
//		
//		
//		
//		
//		
//		this.getChildren().add(totalpriceLabel);
//	}
//	
//	public void calculateTotalPrice() {
//		int totalmoney = 0;
//		for (IngredientShopBox i: this.ingredientShopBoxs) {
//			int price = i.getIngredientItem().getPrice();
//			int amount = i.getAmountBox().getAmount();
//			totalmoney += price*amount;
//		}
//		totalpriceLabel.setText("Total price:  "+totalmoney);
//		
//	}
//}
//
//}
