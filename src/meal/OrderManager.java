package meal;

import java.util.ArrayList;

import Exception.RemoveOrderFailedException;
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
	
	public Menu removeOrder(int index) throws RemoveOrderFailedException{
		if (index > orders.size()-1) {
			throw new RemoveOrderFailedException("Number you inserted exceed orders size");
		} else if (index < 0) {
			throw new RemoveOrderFailedException("Number cannot be negative");		
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
			try {
				removeOrder(intarray.get(i));
			} catch (RemoveOrderFailedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
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
			Menu menuremoved;
			try {
				menuremoved = removeOrder(indexmatch);
			} catch (RemoveOrderFailedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return false;
			}
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
