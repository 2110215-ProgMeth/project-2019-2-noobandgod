package logic;

import java.util.ArrayList;
import java.util.Arrays;
import entity.Player;
import gui.SimulationManager;
import meal.OrderManager;
import sharedObject.RenderableHolder;

public class GameController {
	private static ArrayList<Player> players;
	
	private static GameMap gameMap;
	
	private static int coin_count;
	private static int score_count;
	
	private static boolean is_timeup;
	
	public static int MAX_ORDER;
	public static int MAX_TIME;

	public static final int CUTTINGBOARD_COOLDOWN = 1;
	
	public static int Cabbage_AMOUNT;
	public static int Tomato_AMOUNT;
	public static int Fish_AMOUNT;
	
	public static final String[] INGREDIENTS 
		= new String[] {"Tomato","Cabbage","Fish"};
	
	public static OrderManager orderManager;
	
	public static void InitializeGame(int numberOfPlayers, String[][] map) {
		InitializeMap(map);
		InitializeIngredient();
		InitializePlayer(numberOfPlayers);
		
		setCoinCount(500);
		setScoreCount(999);
		setIsTimeUp(false);
		
		orderManager = new OrderManager();
	}
	
	
	public static void InitializeMap(String[][] map) {
		System.out.println("Initializing Map...");
		gameMap = new GameMap(map);
		System.out.println("Successfully Initializing Map!");
	}
	
	public static void InitializeIngredient() {
		setTomato_AMOUNT(1);
		setCabbage_AMOUNT(2);
		setFish_AMOUNT(3);
	}
	
	public static void InitializePlayer(int numberOfPlayers) {
		if (numberOfPlayers == 1) {
			players = new ArrayList<Player>();
			Player player0 = new Player(0,1,1);
			
			players.add(player0);
			RenderableHolder.getInstance().add(player0);
		} else if (numberOfPlayers == 2) {
			players = new ArrayList<Player>();
			Player player0 = new Player(0,1,1);
			Player player1 = new Player(1,8,2);
			
			players.add(player0); RenderableHolder.getInstance().add(player0);
			players.add(player1); RenderableHolder.getInstance().add(player1);
		}
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
		SimulationManager.getDataPane().getScoreMoneyBox().updateScore();
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

	public static void addTomato_AMOUNT(int tomato_AMOUNT) {
		Tomato_AMOUNT += tomato_AMOUNT;
		SimulationManager.getDataPane().getIngredientStoragePane().updateIngredientAmount();
	}

	public static void addCabbage_AMOUNT(int cabbage_AMOUNT) {
		Cabbage_AMOUNT += cabbage_AMOUNT;
		SimulationManager.getDataPane().getIngredientStoragePane().updateIngredientAmount();
	}
	
	public static void addFish_AMOUNT(int fish_AMOUNT) {
		Fish_AMOUNT += fish_AMOUNT;
		SimulationManager.getDataPane().getIngredientStoragePane().updateIngredientAmount();
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
	
	public static Player getPlayers(int numberPlayer) {
		return players.get(numberPlayer);
	}

	public static boolean isThisIngredientNameValid(String ingredientName) {
		return Arrays.asList(INGREDIENTS).contains(ingredientName);
	}
	
	
	
}
