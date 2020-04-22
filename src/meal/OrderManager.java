package meal;

import java.util.ArrayList;

import entity.Dish;
import entity.Player;
import logic.GameController;

public class OrderManager {
	private ArrayList<Menu> orders;
	
	public OrderManager() {
		this.orders = new ArrayList<Menu>();
	}
	
	public boolean addOrder(Menu m) {
		if (orders.size()+1 <= GameController.MAX_ORDER) {
			orders.add(m);
		
			System.out.println("Menu has already added");
			return true;
		} else {
			return false;
		}
	}
	
	public Menu removeOrder(int index) {
		if (index > orders.size()-1) {
			System.out.println("Number you inserted exceed orders size");
			return null; //may be throw some exception here
		} else if (index < 0) {
			System.out.println("Number cannot be negative");
			return null;
			
		} else {
			Menu removedMenu = orders.get(index);
			orders.remove(index);
			
			System.out.println("Menu: "+removedMenu.getName()+" has been removed");
			return removedMenu;
		}
	}
	
	public void removeOrderOutOfTime() {
		ArrayList<Integer> intarray = new ArrayList<Integer>();
		for (int i=0 ; i<orders.size() ; i++) {
			if (orders.get(i).getTimeleft() <= 0) {
				intarray.add(i);
			}
		}
		
		for (int i=0; i<intarray.size(); i++) {
			removeOrder(intarray.get(i));
		}
	}
	
	public boolean sendOrder(Player p) {
		boolean anymatch = false;
		int indexmatch = -1;
		
		for (int i=0 ; i<orders.size(); i++) {
			Menu menu = orders.get(i);
			
			if (menu.isAllIngredients(p.getDishHeld())) {
				indexmatch = i;
				anymatch = true;
				break;	
			}
		}
		
		if(anymatch) {
			Menu menuremoved = removeOrder(indexmatch);
			GameController.addCoinCount(menuremoved.price);
			GameController.addScoreCount(menuremoved.getMax_score());
			p.setDishHeld(null);
			return true;
		} else {
			GameController.addScoreCount(-10);
			System.out.println("No menu match with your dish! Penalty -10 points");
			return false;	
		}
		
	}
	
}
