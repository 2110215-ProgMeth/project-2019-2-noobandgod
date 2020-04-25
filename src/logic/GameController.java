package logic;

import entity.Player;
import gui.ShopPane;
import gui.SimulationManager;
import meal.OrderManager;

public class GameController {
	private static GameMap gameMap;
	private static int coin_count;
	private static int score_count;
	private static boolean is_timeup;
	public static int MAX_ORDER;
	public static int MAX_TIME;

	private static OrderManager orderManager;
	
	public static void InitializeMap(String[][] map) {
		System.out.println("Initializing Map...");
		
		gameMap = new GameMap(map);
		
		setCoinCount(500);
		setScoreCount(999);
		setIsTimeUp(false);
		
		System.out.println("Successfully Initializing Map!");
	}
	

	public static void movePlayer(Direction dir,Player p) {
		p.move(dir);
	}
	
	public static void printMap( ) {
		gameMap.printMap();
	}
	
	public static GameMap getCurrentGameMap() {
		return gameMap;
	}
	
	public static OrderManager getOrderManager() {
		return orderManager;
	}

	public static void addCoinCount(int coin) {
		coin_count += coin;
		SimulationManager.getDataPane().getScoreMoneyBox().updateMoney();
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

	public static int getCoin_count() {
		return coin_count;
	}
	
	public static int getScore_count() {
		return score_count;
	}
	
	
}
