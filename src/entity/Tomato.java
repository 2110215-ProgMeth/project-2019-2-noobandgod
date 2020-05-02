package entity;

import entity.base.Entity;

public class Tomato extends Ingredient{
	private static int price = 20;
	
	public Tomato() {
		setState(0);
	}
	public char getSymbol() {
		return Sprites.Tomato;
	}
	public static int getPrice() {
		return price;
	}
}
