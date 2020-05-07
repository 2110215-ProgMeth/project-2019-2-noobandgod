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

		if (menumatch.size()!=0) {
			Menu min = menumatch.get(0);
			indexmatch = menuindex.get(0);
			for (int i = 1; i< menumatch.size();i++) {
				if (menumatch.get(i).getTimeLeft()< min.getTimeLeft()) {
					min = menumatch.get(i);
					indexmatch = menuindex.get(i);
				}
			}
			Menu menuremoved;
			try {
				menuremoved = removeOrder(indexmatch);
				OrderBox.sendOrder(menuremoved);
			} catch (RemoveOrderFailedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return false;
			}
			GameController.addCoinCount(menuremoved.price);
			GameController.addScoreCount(menuremoved.getMax_score());
			p.removeEntityHeld();
			return true;
		} else {
			GameController.addScoreCount(-10);
			System.out.println("No menu match with your dish! Penalty -10 points");
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
		if (rand <= 3) {
			return 1;
		} else if (rand <= 6) {
			return 2;
		} else {
			return 3;
		}
	}
	
	public void printTimeLeftOfEachMenu() {
		ArrayList<Double> a = new ArrayList<Double>();
		for (Menu m: getOrders()) {
			a.add(m.getTimeLeft());
		}
		System.out.println(a);
	}

	public static void updateOrderNumber() {
		for (int order = GameController.getOrderManager().getOrders().size()-1;order >=0;order--)
			//ArrayList<Menu> menu_clone = new ArrayList<>();
			if (GameController.getOrderManager().getOrders().get(order).getTimeLeft() == 0) {//when menu is timeup
				GameController.getOrderManager().getOrders().remove(order);
			}//else if (GameController.getOrderManager().getOrders().get(order).isSend()) {
				//GameController.getOrderManager().getOrders().remove(order);
			SimulationManager.getOrderPane().update();
	}
}
//		if (GameController.getOrderManager().getOrders().size() <= 4) {
//			int type = typemenu();
//			if (type ==1) {
//				Menu simpleSalad = new Salad(20,0);
//				GameController.getOrderManager().getOrders().add(simpleSalad);
//			}else if (type ==2) {
//				Menu SashimiSalad = new Salad(20,1);
//				GameController.getOrderManager().getOrders().add(SashimiSalad);
//			}else {
//				Menu friedFish = new FriedFish(20);
//				GameController.getOrderManager().getOrders().add(friedFish);
//			}

	
