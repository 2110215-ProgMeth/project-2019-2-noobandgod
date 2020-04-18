package logic;

public class GameController {
	private static GameMap gameMap;
	private static int coin_count;
	private static int score_count;
	
	public static void InitializeMap(String[][] map) {
		gameMap = new GameMap(map);
	}
	
	public static void printMap( ) {
		gameMap.printMap();
	}
	
	public static GameMap getCurrentGameMap() {
		return gameMap;
	}
	
}
