package logic;

import entity.Player;
import gui.ShopPane;
import meal.OrderManager;

public class GameController {
	private static GameMap gameMap;
	private static int coin_count;
	private static int score_count;
	private static boolean is_timeup;
	public static int MAX_ORDER;
	private static OrderManager orderManager;
	private static ShopPane shopPane;
	
	public static void InitializeMap(String[][] map) {
		System.out.println("Initializing Map...");
		
		gameMap = new GameMap(map);
		shopPane = new ShopPane(new String[]{"Tomato","Cabbage","Fish"});
		
		setCoinCount(0);
		setScoreCount(0);
		setIsTimeUp(false);
		
		System.out.println("Successfully Initializing Map!");
	}
	
	public static void InitializeShopPane(String[] ingredients) {
		shopPane = new ShopPane(ingredients);
	}
	
	
	public static void movePlayer(Direction dir,Player p) {
		p.move(dir);
	}
	
	public static void printMap( ) {
		gameMap.printMap();
	}
	
	public static ShopPane getShopPane() {
		return shopPane;
	}

	public static GameMap getCurrentGameMap() {
		return gameMap;
	}
	
	public static OrderManager getOrderManager() {
		return orderManager;
	}

	public static void addCoinCount(int coin) {
		coin_count += coin;
	}
	
	public static void setCoinCount(int coin) {
		coin_count = coin;
	}
	
	public static void addScoreCount(int score) {
		score_count += score;
	}
	
	public static void setScoreCount(int score) {
		score_count = score;
	}
	
	public static void setIsTimeUp(boolean b) {
		is_timeup = b;
	}
}
