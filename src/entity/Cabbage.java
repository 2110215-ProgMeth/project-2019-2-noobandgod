package entity;

import entity.base.Entity;

public class Cabbage extends Ingredient{
	private static int price = 10;
	
	public Cabbage() {
		setState(0);
	}

	public static int getPrice() {
		return price;
	}
	
	
}
