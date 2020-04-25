package gui;

import java.util.ArrayList;

import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import logic.GameController;

public class ShopPane extends VBox {
	private ObservableList<IngredientShopBox> ingredientShopBoxs = FXCollections.observableArrayList();
	private Label totalpriceLabel;
	private int totalpay;
	
	public ShopPane(String[] ingredientName) {
		this.setPrefHeight(600);
		this.setPrefWidth(196);
		this.setSpacing(16);
		
		Label shopLabel = new Label("Shop");
		shopLabel.setFont(new Font(20));
		this.getChildren().add(shopLabel);
		
		
		for (String ingredient : ingredientName) {
			IngredientShopBox ingredientShopBox = new IngredientShopBox(ingredient);
			this.ingredientShopBoxs.add(ingredientShopBox);
			this.getChildren().add(ingredientShopBox);
		}
		
		this.totalpriceLabel = new Label("Total price:  "+"0");
		totalpriceLabel.setFont(new Font(16));
		
		Button buyButton = new Button("Buy");
		buyButton.setPrefWidth(64);
		
		
		buyButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				int money = GameController.getCoin_count();
				System.out.println("Your money is: "+money);
				System.out.println("Your have to pay: "+totalpay);
				
				if (money - totalpay >= 0) {
					GameController.addCoinCount(-totalpay);
					
					System.out.println("Your money is: "+GameController.getCoin_count());
					//add ingredient to ingredient storage! 
					
					resetAmount();
					
				} else {
					System.out.println("Your money is not enough");
				}
				
				
			}
		});
		
		
		this.setAlignment(Pos.CENTER);
		this.getChildren().addAll(totalpriceLabel,buyButton);
	}
	
	public void calculateTotalPrice() {
		int totalmoney = 0;
		for (IngredientShopBox i: this.ingredientShopBoxs) {
			int price = i.getIngredientItem().getPrice();
			int amount = i.getAmountBox().getAmount();
			totalmoney += price*amount;
		}
		setTotalpay(totalmoney);
		totalpriceLabel.setText("Total price:  "+totalpay);
	}
	
	public void resetAmount() {
		for (IngredientShopBox i: this.ingredientShopBoxs) {
			i.getAmountBox().setAmount(0);	
		}
		setTotalpay(0);
		totalpriceLabel.setText("Total price:  "+"0");
	}
	

	public void setTotalpay(int totalpay) {
		this.totalpay = totalpay;
	}
	
	
	
}
