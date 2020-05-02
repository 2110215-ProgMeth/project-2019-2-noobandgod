package entity;

import entity.base.Entity;

public class Fish extends Ingredient{
	private static int price = 30;
	
	public Fish() {
		setState(0);
	}
	public static int getPrice() {
		return price;
	}
}
