package gui;


import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;

public class AmountBox extends HBox {
	private int amount;
	private Label amountBuy;
	
	public AmountBox() {
		super();
		this.setPrefHeight(32);
		
		
		Label amountLabel = new Label("  amount: ");
		amountLabel.setFont(new Font(20));
		
		this.amount = 0;
		this.amountBuy = new Label("0");
		amountBuy.setFont(new Font(20));
		//---------------------------------------------------------------------
		Button addButton = new Button("+");
		addButton.setPrefWidth(16);
		addButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				addAmount(1);
			}
		});
		//---------------------------------------------------------------------
		Button removeButton = new Button("-");
		removeButton.setPrefWidth(16);
		removeButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				addAmount(-1);
			}
		});
		
		this.getChildren().addAll(amountLabel,amountBuy,addButton,removeButton);	
		
	}
	
	public void addAmount(int n) {
		this.amount += n;
		String amountString = Integer.toString(this.amount);
		this.amountBuy.setText(amountString);
	}
}
