package logic;

import java.util.ArrayList;
import java.util.Arrays;
import entity.Player;
import meal.OrderManager;
import sharedObject.RenderableHolder;

public class GameController {
	private static ArrayList<Player> players;
	
	private static GameMap gameMap;
	
	private static int coin_count;
	private static int score_count;
	
	public static boolean is_timeup;
	
	public static final int CUTTINGBOARD_COOLDOWN = 2;
	public static final int FRYINGPAN_COOLDOWN = 5;
	
	public static int Cabbage_AMOUNT;
	public static int Tomato_AMOUNT;
	public static int Fish_AMOUNT;
	
	public static final String[] INGREDIENTS 
		= new String[] {"Tomato","Cabbage","Fish"};
	
	public static final int MAX_TIME = 210;
	public static final int MAX_ORDER = 5;
	
	private static OrderManager orderManager;
	private static int successDish;
	private static int failedDish;
	
	public static int timeToAddMenu;
	
	private static int timeChecked;
	
	private static int  almostTimeUpChecked;

	public static void InitializeGame(int numberOfPlayers, String[][] map) {
		InitializeMap(map);
		InitializeIngredient();
		InitializePlayer(numberOfPlayers);
		
		setSuccessDish(0);
		setFailedDish(0);
		setCoinCount(150);
		setScoreCount(0);
		setIsTimeUp(false);
		setAlmostTimeUpChecked(0);
		setTimeChecked(10000);
		orderManager = new OrderManager();
	}
	
	public static void InitializeMap(String[][] map) {
		gameMap = new GameMap(map);
	}
	
	public static void InitializeIngredient() {
		setTomato_AMOUNT(1);
		setCabbage_AMOUNT(1);
		setFish_AMOUNT(1);
	}
	
	public static void InitializePlayer(int numberOfPlayers) {
		if (numberOfPlayers == 1) {
			timeToAddMenu = 20;
			
			players = new ArrayList<Player>();
			Player player0 = new Player(0,1,1);
			
			players.add(player0);
			RenderableHolder.getInstance().add(player0);
		} else if (numberOfPlayers == 2) {
			timeToAddMenu = 16;
			
			players = new ArrayList<Player>();
			Player player0 = new Player(0,1,1);
			Player player1 = new Player(1,9,5);
			
			players.add(player0); RenderableHolder.getInstance().add(player0);
			players.add(player1); RenderableHolder.getInstance().add(player1);
		}
	}

	public static void movePlayer(Direction dir,Player p) {
		p.move(dir);
	}
	
	public static boolean isThisIngredientNameValid(String ingredientName) {
		return Arrays.asList(INGREDIENTS).contains(ingredientName);
	}
	
	public static void printMap( ) {
		gameMap.printMap();
	}
	
	public static int getAmountofPlayer() {
		return players.size();
	}
	
	public static Player getPlayers(int numberPlayer) {
		return players.get(numberPlayer);
	}
	
	public static void addTomato_AMOUNT(int tomato_AMOUNT) {
		Tomato_AMOUNT += tomato_AMOUNT;
	}

	public static void addCabbage_AMOUNT(int cabbage_AMOUNT) {
		Cabbage_AMOUNT += cabbage_AMOUNT;
	}
	
	public static void addFish_AMOUNT(int fish_AMOUNT) {
		Fish_AMOUNT += fish_AMOUNT;
	}
	
	public static void addScoreCount(int score) {
		score_count += score;
	}
	
	public static void addCoinCount(int coin) {
		coin_count += coin;
	}
	
	public static GameMap getCurrentGameMap() {
		return gameMap;
	}
	
	public static OrderManager getOrderManager() {
		return orderManager;
	}

	public static void setCoinCount(int coin) {
		coin_count = coin;
	}
	
	public static void setIsTimeUp(boolean b) {
		is_timeup = b;
	}

	public static int getCoin_count() {
		return coin_count;
	}
	
	public static void setScoreCount(int score) {
		score_count = score;
	}
	
	public static int getScore_count() {
		return score_count;
	}
	
	public static int getTomato_AMOUNT() {
		return Tomato_AMOUNT;
	}

	public static int getCabbage_AMOUNT() {
		return Cabbage_AMOUNT;
	}

	public static int getFish_AMOUNT() {
		return Fish_AMOUNT;
	}
	public static void setCabbage_AMOUNT(int cabbage_AMOUNT) {
		Cabbage_AMOUNT = cabbage_AMOUNT;
	}

	public static void setTomato_AMOUNT(int tomato_AMOUNT) {
		Tomato_AMOUNT = tomato_AMOUNT;
	}

	public static void setFish_AMOUNT(int fish_AMOUNT) {
		Fish_AMOUNT = fish_AMOUNT;
	}
	
	public static int getSuccessDish() {
		return successDish;
	}

	public static void setSuccessDish(int successDish) {
		GameController.successDish = successDish;
	}

	public static int getFailedDish() {
		return failedDish;
	}

	public static void setFailedDish(int failedDish) {
		GameController.failedDish = failedDish;
	}
	
	public static int getTimeChecked() {
		return timeChecked;
	}

	public static void setTimeChecked(int timeChecked) {
		GameController.timeChecked = timeChecked;
	}

	public static int isAlmostTimeUpChecked() {
		return almostTimeUpChecked;
	}

	public static void setAlmostTimeUpChecked(int almostTimeUpChecked) {
		GameController.almostTimeUpChecked = almostTimeUpChecked;
	}
}
