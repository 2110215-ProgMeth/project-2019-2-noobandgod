package test;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.Before;
import org.junit.Test;

import entity.Dish;
import meal.Salad;

public class TestSalad {

	Salad salad1;
	Dish dishforsalad1;
	
	@Before
	public void setUp() {
		salad1 = new Salad(30, 1);
		
		dishforsalad1 = new Dish();
		
		
	}
	
	
}
