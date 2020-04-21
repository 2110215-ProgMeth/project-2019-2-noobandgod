package test;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.Before;
import org.junit.Test;

import entity.Cabbage;
import entity.Dish;
import entity.Tomato;
import meal.Salad;

public class TestSalad {

	Salad salad1;
	Dish dishforsalad1;
	
	@Before
	public void setUp() {
		salad1 = new Salad(30, 1);
		
		
		dishforsalad1 = new Dish();
		
		Tomato tomato = new Tomato();
		tomato.setState(1);
		Cabbage cabbage = new Cabbage();
		cabbage.setState(1);
		
		dishforsalad1.adds(tomato);
		dishforsalad1.adds(cabbage);
		
	}
	
	@Test
	public void testisAllIngredients() {
		assertEquals(true, salad1.isAllIngredients(dishforsalad1));
		
		
	}
	
	
}
