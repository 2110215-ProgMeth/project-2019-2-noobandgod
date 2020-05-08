package gui;

import logic.GameController;
import meal.Menu;

public class SimulationManager {
	private static ShopPane shopPane;
	private static DataPane dataPane;
	private static OrderPane orderPane;
	
	public static void initializeAllPane() {
		shopPane = new ShopPane(GameController.INGREDIENTS);
		dataPane = new DataPane();
		orderPane = new OrderPane();
	}

	public static OrderPane getOrderPane() {
		return orderPane;
	}

	public static ShopPane getShopPane() {
		return shopPane;
	}

	public static DataPane getDataPane() {
		return dataPane;
	}
	
	public static void updatePane() {
		shopPane.update();
		dataPane.update();
	}
	
}
