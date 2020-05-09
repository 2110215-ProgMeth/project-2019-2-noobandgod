package logic;

import java.util.ArrayList;
import java.util.Arrays;
import entity.Player;
import gui.SimulationManager;
import meal.FriedFish;
import meal.Menu;
import meal.OrderManager;
import meal.Salad;
import sharedObject.RenderableHolder;

public class GameController {
	private static ArrayList<Player> players;
	
	private static GameMap gameMap;
	
	private static int coin_count;
	private static int score_count;
	
	public static boolean is_timeup;
	
	public static final int CUTTINGBOARD_COOLDOWN = 1;
	public static final int FRYINGPAN_COOLDOWN = 2;
	
	public static int Cabbage_AMOUNT;
	public static int Tomato_AMOUNT;
	public static int Fish_AMOUNT;
	
	public static final String[] INGREDIENTS 
		= new String[] {"Tomato","Cabbage","Fish"};
	public static final int MAX_TIME = 20;
	public final static int MAX_ORDER = 5;
	
	public static OrderManager orderManager;
	private static int successDish;
	private static int failedDish;
	
	public static final int timeToAddMenu = 40;
	
	private static int timeChecked;

	public static void InitializeGame(int numberOfPlayers, String[][] map) {
		InitializeMap(map);
		InitializeIngredient();
		InitializePlayer(numberOfPlayers);
		
		setSuccessDish(0);
		setFailedDish(0);
		setCoinCount(200);
		setScoreCount(100);
		setIsTimeUp(false);
		setTimeChecked(10000);
		orderManager = new OrderManager();
		
		//Add menu testing
		//Menu menu1 = new Salad(60,1);
		//Menu menu2 = new Salad(15,0);
		//Menu menu2 = new Salad(50,1);
		//Menu menu3 = new Salad(20, 1);
		//Menu menu3 = new FriedFish(30);
		//Menu menu4 = new Salad(40,1);
		//Menu menu5 = new Salad(40,1);
		//orderManager.addOrder(menu1); 
		//orderManager.addOrder(menu2); 
		//orderManager.addOrder(menu3);
		//orderManager.addOrder(menu4);
		//orderManager.addOrder(menu5);
		
		System.out.println(orderManager.getOrders());
	}
	
	public static void InitializeMap(String[][] map) {
		System.out.println("Initializing Map...");
		gameMap = new GameMap(map);
		System.out.println("Successfully Initializing Map!");
	}
	
	public static void InitializeIngredient() {
		setTomato_AMOUNT(0);
		setCabbage_AMOUNT(0);
		setFish_AMOUNT(0);
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
			Player player1 = new Player(1,9,5);
			
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

	public static void addTomato_AMOUNT(int tomato_AMOUNT) {
		Tomato_AMOUNT += tomato_AMOUNT;
	}

	public static void addCabbage_AMOUNT(int cabbage_AMOUNT) {
		Cabbage_AMOUNT += cabbage_AMOUNT;
	}
	
	public static void addFish_AMOUNT(int fish_AMOUNT) {
		Fish_AMOUNT += fish_AMOUNT;
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
	
	public static int getAmountofPlayer() {
		return players.size();
	}

	public static boolean isThisIngredientNameValid(String ingredientName) {
		return Arrays.asList(INGREDIENTS).contains(ingredientName);
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


	
	
}
