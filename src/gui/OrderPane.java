package gui;

import java.util.ArrayList;

import javafx.scene.layout.HBox;
import logic.GameController;
import meal.Menu;
import meal.OrderManager;
public class OrderPane extends HBox {
	public OrderPane() {
		this.setPrefHeight(192);
		this.setPrefWidth(800);
		this.setSpacing(6);
		for (Menu menu : GameController.getOrderManager().getOrders()) {
			OrderBox order = new OrderBox(menu);
			this.getChildren().add(order);
		}
	}
	
	public void update() {
		this.getChildren().clear();
		System.out.println("UPDATING ORDERPANE!");
		
		for (Menu food : GameController.getOrderManager().getOrders()) {
				OrderBox order = new OrderBox(food);
				this.getChildren().add(order);
		}
	}

}
