package gui;

import logic.GameController;

public class SimulationManager {
	private static ShopPane shopPane;
	private static DataPane dataPane;
	private static OrderPane orderPane;
	
	public static void initializeAllPane() {
		shopPane = new ShopPane(GameController.INGREDIENTS);
		dataPane = new DataPane();
		
	}

	public static ShopPane getShopPane() {
		return shopPane;
	}

	public static DataPane getDataPane() {
		return dataPane;
	}
	public static OrderPane getOrderPane() {
		return orderPane;
	}
	
}
