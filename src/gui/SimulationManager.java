package gui;

public class SimulationManager {
	private static ShopPane shopPane;
	private static DataPane dataPane;
	
	public static void initializeAllPane() {
		shopPane = new ShopPane(new String[]{"Tomato","Cabbage","Fish"});
		dataPane = new DataPane();
		
	}

	public static ShopPane getShopPane() {
		return shopPane;
	}

	public static DataPane getDataPane() {
		return dataPane;
	}
	
	
}
