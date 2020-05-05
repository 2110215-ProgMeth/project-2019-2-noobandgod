package gui;

import javafx.scene.layout.HBox;
import logic.GameController;

public class OrderPane extends HBox {
	private int orderNumber;

	public OrderPane() {
		setOrderNumber(0);
		this.setPrefHeight(128);
		this.setPrefWidth(500);
		this.setSpacing(16);

		for (int i = 0; i < 5; i++) {
			int type = typeMenu();
			OrderBox order = new OrderBox(type);
			this.getChildren().add(order);
		}
		updateOrderNumber();
	}

	public int typeMenu() {
		int max = 9;
		int min = 1;
		int range = max - min + 1;
		int rand = (int) (Math.random() * range) + min;
		if (rand <= 3) {
			return 1;
		} else if (rand <= 6) {
			return 2;
		} else {
			return 3;
		}
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
