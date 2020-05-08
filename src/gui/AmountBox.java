package gui;


import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import logic.GameController;

public class AmountBox extends HBox {
	private int amount;
	private Label amountBuy;
	private Button addButton;
	private Button removeButton;
	
	public AmountBox() {
		super();
		this.setPrefHeight(32);
		this.setPrefWidth(128);
		
		
		Label amountLabel = new Label("X ");
		amountLabel.setFont(new Font(16));
		
		this.amount = 0;
		this.amountBuy = new Label("0  ");
		amountBuy.setFont(new Font(16));
		//---------------------------------------------------------------------
		this.addButton = new Button("+");
		addButton.setPrefWidth(16);
		
		addButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				addAmount(1);
			}
		});
		//---------------------------------------------------------------------
		this.removeButton = new Button("-");
		removeButton.setPrefWidth(16);
		removeButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				addAmount(-1);
			}
		});
		//---------------------------------------------------------------------
		this.getChildren().addAll(amountLabel,amountBuy,addButton,removeButton);	
		this.setAlignment(Pos.CENTER);
	}
	
	public void addAmount(int n) {
		if ((this.amount + n) >= 0) {
			this.amount += n;
			String amountString = Integer.toString(this.amount);
			this.amountBuy.setText(amountString+"  ");
			SimulationManager.getShopPane().calculateTotalPrice();
		} else {
			System.out.println("amount can't be lower than zero!");
		}
		
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
		this.amountBuy.setText("0  ");
	}
	
	public void update() {
		if(amount == 0) {
			addButton.setStyle("-fx-font-size: 14px; -fx-background-color: limegreen; -fx-text-fill: white; -fx-font-weight: bold;");
			removeButton.setStyle("-fx-font-size: 14px; -fx-background-color: grey; -fx-text-fill: black; -fx-font-weight: bold;");
		} else {
			addButton.setStyle("-fx-font-size: 14px; -fx-background-color: limegreen; -fx-text-fill: white; -fx-font-weight: bold;");
			removeButton.setStyle("-fx-font-size: 14px; -fx-background-color: red; -fx-text-fill: white; -fx-font-weight: bold;");
		}
	}
	
	
	
}
