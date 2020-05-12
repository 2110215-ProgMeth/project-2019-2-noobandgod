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
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import logic.GameController;
import sharedObject.AudioLoader;
import sharedObject.RenderableHolder;

public class ShopPane extends StackPane {
	private ObservableList<IngredientShopBox> ingredientShopBoxs = FXCollections.observableArrayList();
	private Label totalpriceLabel;
	private int totalpay;
	private Button buyButton;
	
	private static int width = 190;
	private static int height = 596;
	
	public ShopPane(String[] ingredientName) {
		this.setPrefHeight(height); this.setPrefWidth(width);
		
		//-------------------------------------------------
		//Background
		Canvas bg = new Canvas(width,height);
		GraphicsContext bggc = bg.getGraphicsContext2D();
		bggc.drawImage(RenderableHolder.shoppane_bg_Image, 0, 0, width, height);
		
		this.getChildren().add(bg);
		//-------------------------------------------------
		VBox mainBox = new VBox(5);
		
		Label shopLabel = new Label("Shop");
		shopLabel.setFont(Font.font("Verdana", FontWeight.BOLD, 20));
		shopLabel.setTextFill(Color.PALEGOLDENROD);
		mainBox.getChildren().add(shopLabel);
		
		//-------------------------------------------------
		for (String ingredient : ingredientName) {
			IngredientShopBox ingredientShopBox = new IngredientShopBox(ingredient);
			this.ingredientShopBoxs.add(ingredientShopBox);
			mainBox.getChildren().add(ingredientShopBox);
		}
		//-------------------------------------------------
		this.totalpriceLabel = new Label("Total price:  "+"0");
		totalpriceLabel.setTextFill(Color.WHITE);
		totalpriceLabel.setFont(new Font(20));
		//-------------------------------------------------
		this.buyButton = new Button("Buy");
		buyButton.setPrefWidth(96);
		buyButton.setPrefHeight(30);
		
		
		buyButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				if (GameController.getCoin_count() - totalpay >= 0) {
					AudioLoader.BUTTON_CLICK.play();
					GameController.addCoinCount(-totalpay); //pay money
					addIngredientFromBuying();
					resetShop();				
				} else {
					AudioLoader.ERROR.play();
					System.out.println("Your money is not enough");
				}
				
				
			}
		});
		
		
		mainBox.setAlignment(Pos.CENTER);
		mainBox.getChildren().addAll(totalpriceLabel,buyButton);
		
		this.getChildren().add(mainBox);
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
	
	public void resetShop() {
		for (IngredientShopBox i: this.ingredientShopBoxs) {
			i.getAmountBox().setAmount(0);	
		}
		setTotalpay(0);
		totalpriceLabel.setText("Total price:  "+"0");
	}
	
	public void addIngredientFromBuying() {
		for (IngredientShopBox i: this.ingredientShopBoxs) {
			switch (i.getIngredientName()) {
			case "Tomato":
				GameController.addTomato_AMOUNT(i.getAmountBox().getAmount());
				break;
			case "Cabbage":
				GameController.addCabbage_AMOUNT(i.getAmountBox().getAmount());
				break;
			case "Fish":
				GameController.addFish_AMOUNT(i.getAmountBox().getAmount());
				break;
			}
		}	
				
	}
	
	public void setTotalpay(int totalpay) {
		this.totalpay = totalpay;
	}
	
	public void update() {
		int money = GameController.getCoin_count();
		if (totalpay == 0) {
			totalpriceLabel.setTextFill(Color.WHITE);
			buyButton.setStyle("-fx-background-color: white; -fx-text-fill: black; -fx-font-weight: bold;");
		} else if (money <= totalpay) {
			totalpriceLabel.setTextFill(Color.PINK);
			buyButton.setStyle("-fx-background-color: grey; -fx-text-fill: black; -fx-font-weight: bold;");
			
		} else {
			totalpriceLabel.setTextFill(Color.LIMEGREEN);
			buyButton.setStyle("-fx-background-color: limegreen; -fx-text-fill: darkgreen; -fx-font-weight: bold;");
		}
		
		for (IngredientShopBox a: ingredientShopBoxs) {
			a.getAmountBox().update();
		}
		
	}
	
	
	
}
