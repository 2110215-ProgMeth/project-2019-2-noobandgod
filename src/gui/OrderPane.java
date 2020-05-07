package gui;

import java.util.ArrayList;

import javafx.scene.layout.HBox;
import logic.GameController;
import meal.Menu;
import meal.OrderManager;
public class OrderPane extends HBox {
	public OrderPane() {
		this.setPrefHeight(165);
		this.setPrefWidth(800);
		this.setSpacing(4);
		for (Menu menu : GameController.getOrderManager().getOrders()) {
			OrderBox order = new OrderBox(menu);
			this.getChildren().add(order);
		}
	}
	public static void update() {
			ArrayList<Menu> menu = new ArrayList<>();
			for (Menu food : GameController.getOrderManager().getOrders()) {
				menu.add(food);
			}
			this.getChildren().removeAll();
			for (Menu clone_menu : menu) {
				OrderBox order = new OrderBox(clone_menu);
				this.getChildren().add(order);
			}
	}
	public void updateOrderNumber() {
		getChildren().removeAll();
		
		
	}

}
