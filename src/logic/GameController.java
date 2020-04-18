package logic;

public class GameController {
	private static GameMap gameMap;
	private static int coin_count;
	private static int score_count;
	private static boolean is_timeup;
	
	public static void InitializeMap(String[][] map) {
		System.out.println("Initializing Map...");
		
		gameMap = new GameMap(map);
		setCoinCount(0);
		setScoreCount(0);
		setIsTimeUp(false);
		
		System.out.println("Successfully Initializing Map!");
	}
	
	public static void printMap( ) {
		gameMap.printMap();
	}
	
	public static GameMap getCurrentGameMap() {
		return gameMap;
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
