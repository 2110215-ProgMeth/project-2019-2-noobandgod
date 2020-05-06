package gui;

import javafx.scene.layout.HBox;
import logic.GameController;
import meal.Menu;
import meal.OrderManager;

public class OrderPane extends HBox {
	private int orderNumber;
	public OrderPane() {
		this.setPrefHeight(128);
		this.setPrefWidth(800);
		//this.setSpacing(16);
		//setOrderNumber(0);
		for (Menu menu : GameController.getOrderManager().getOrders()) {
			OrderBox order = new OrderBox(menu);
			this.getChildren().add(order);
		}
		//updateOrderNumber();
	}

	public void updateOrderNumber() {
	
		
	}

	public int getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(int orderNumber) {
		this.orderNumber = orderNumber;
	}

}
