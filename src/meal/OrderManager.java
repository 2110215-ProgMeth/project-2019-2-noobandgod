package meal;

import java.util.ArrayList;

import entity.Dish;
import entity.Player;
import exception.RemoveOrderFailedException;
import gui.OrderBox;
import gui.OrderPane;
import gui.SimulationManager;
import javafx.animation.AnimationTimer;
import javafx.scene.paint.Color;
import logic.GameController;
import screen.GameScreen;
import sharedObject.AudioLoader;

public class OrderManager {
	private ArrayList<Menu> orders;

	public OrderManager() {
		this.orders = new ArrayList<Menu>();
	}

	public boolean addOrder(Menu m) {
		if (orders.size() + 1 <= GameController.MAX_ORDER) {
			orders.add(m);

			System.out.println("Menu has already added");
			return true;
		} else {
			return false;
		}
	}

	public Menu removeOrder(int index) throws RemoveOrderFailedException {
		if (index > orders.size() - 1) {
			throw new RemoveOrderFailedException("Number you inserted exceed orders size");
		} else if (index < 0) {
			throw new RemoveOrderFailedException("Number cannot be negative");
		} else {
			Menu removedMenu = orders.get(index);
			orders.remove(index);

			System.out.println("Menu: " + removedMenu.getName() + " has been removed");
			return removedMenu;
		}
	}

	public void removeOrderOutOfTime() {
		ArrayList<Integer> intarray = new ArrayList<Integer>();
		for (int i = 0; i < orders.size(); i++) {
			if (orders.get(i).getTimeLeft() <= 0) {
				intarray.add(i);
			}
		}

		for (int i = 0; i < intarray.size(); i++) {
			try {
				removeOrder(intarray.get(i));
			} catch (RemoveOrderFailedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public boolean sendOrder(Player p) {
		int indexmatch = -1;
		ArrayList<Menu> menumatch = new ArrayList<Menu>();
		ArrayList<Integer> menuindex = new ArrayList<Integer>();
		for (int i = 0; i < orders.size(); i++) {
			Menu menu = orders.get(i);

			if (menu.isAllIngredients(p.getEntityHeld())) {
				menumatch.add(menu);
				menuindex.add(i);
			}
		}

		if (menumatch.size() != 0) {
			Menu min = menumatch.get(0);
			indexmatch = menuindex.get(0);
			for (int i = 1; i < menumatch.size(); i++) {
				if (menumatch.get(i).getTimeLeft() < min.getTimeLeft()) {
					min = menumatch.get(i);
					indexmatch = menuindex.get(i);
				}
			}
			Menu menuremoved;
			try {
				menuremoved = removeOrder(indexmatch);
				GameController.setSuccessDish(GameController.getSuccessDish() + 1);
				OrderBox.sendOrder(menuremoved);
				AudioLoader.SUCCESS_SEND.play();
			} catch (RemoveOrderFailedException e) {
				// TODO Auto-generated catch block
				AudioLoader.ERROR.play();
				e.printStackTrace();
				return false;
			}
			GameController.addCoinCount(menuremoved.price);
			GameController.addScoreCount(menuremoved.getMax_score());
			p.removeEntityHeld();
			return true;
		} else {
			//in case wrong dish was sent!
			GameController.addScoreCount(-5);
			return false;
		}

	}

	public ArrayList<Menu> getOrders() {
		return orders;
	}

	public static int typemenu() {
		int max = 9;
		int min = 1;
		int range = max - min + 1;
		int rand = (int) (Math.random() * range) + min;
		return rand;
	}

	public void printTimeLeftOfEachMenu() {
		ArrayList<Double> a = new ArrayList<Double>();
		for (Menu m : getOrders()) {
			a.add(m.getTimeLeft());
		}
		System.out.println(a);
	}

	public static void updateOrderNumber() {
		for (int order = GameController.getOrderManager().getOrders().size() - 1; order >= 0; order--)
			if (GameController.getOrderManager().getOrders().get(order).getTimeLeft() == 0) {// when menu is timeup
				GameController.getOrderManager().getOrders().remove(order);
				GameController.setFailedDish(GameController.getFailedDish() + 1);
				GameController.addScoreCount(-5);
			} 
		SimulationManager.getOrderPane().update();
	}

	public static void addMenu() {
		if (((GameController.getOrderManager().getOrders().size() <=( GameController.MAX_ORDER -1 ))&& (GameScreen.gametime % GameController.timeToAddMenu == 0))
				|| GameController.getOrderManager().getOrders().size() == 0) {
			if (GameScreen.gametime > 0) {
				if (GameController.getTimeChecked() != GameScreen.gametime) {
					int type = typemenu();
					if (type >= 1 && type <=3) {
						Menu simpleSalad = new Salad(type*5+60, 0);
						GameController.getOrderManager().getOrders().add(simpleSalad);
					} else if (type >= 4 && type <= 6) {
						Menu SashimiSalad = new Salad((type-3)*5+65, 1);
						GameController.getOrderManager().getOrders().add(SashimiSalad);
					} else {//7 8 9
						Menu friedFish = new FriedFish((type-6)*5 +50);
						GameController.getOrderManager().getOrders().add(friedFish);
					}
					SimulationManager.getOrderPane().update();
					GameController.setTimeChecked(GameScreen.gametime);
				}
			}else if (GameScreen.gametime == 0){
				GameController.getOrderManager().getOrders().clear();
				SimulationManager.getOrderPane().update();
			}
		}
	}
}
