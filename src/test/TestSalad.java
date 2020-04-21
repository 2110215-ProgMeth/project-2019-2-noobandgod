package test;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.Before;
import org.junit.Test;

import entity.Cabbage;
import entity.Dish;
import entity.Fish;
import entity.Tomato;
import meal.Salad;

public class TestSalad {

	Salad simplesalad1;
	Salad sashimisalad1;
	Dish dishforsalad1;
	Dish dishforsalad2;
	Tomato tomatosliced;
	Cabbage cabbagesliced;
	Fish fishsliced;
	Fish fishfried;
	
	@Before
	public void setUp() {
		tomatosliced = new Tomato();
		tomatosliced.setState(1);
		
		cabbagesliced = new Cabbage();
		cabbagesliced.setState(1);
		
		fishsliced = new Fish();
		fishsliced.setState(1);
		
		fishfried = new Fish();
		fishfried.setState(2);
		//-------------------------------------
		
		simplesalad1 = new Salad(30, 0);
		sashimisalad1 = new Salad(22, 1);
		
		//-------------------------------------
		
		dishforsalad1 = new Dish();
		dishforsalad1.adds(tomatosliced);
		dishforsalad1.adds(cabbagesliced);
		
		//------------------------------------
		
		
		dishforsalad2 = new Dish();
		dishforsalad2.adds(tomatosliced);
		dishforsalad2.adds(cabbagesliced);
		dishforsalad2.adds(fishsliced);
		
		
		
		
	}
	@Test
	public void testConstructorSimpleSalad() {
		assertEquals("Simple Salad", simplesalad1.getName());
		assertEquals(0, simplesalad1.getSaladType());
		assertEquals(30, simplesalad1.getTimeleft());
		assertEquals(true, simplesalad1.getIngredients().contains(tomatosliced));
		assertEquals(true, simplesalad1.getIngredients().contains(cabbagesliced));
		assertEquals(false, simplesalad1.getIngredients().contains(new Tomato()));
		assertEquals(false, simplesalad1.getIngredients().contains(fishsliced));
	}
	
	@Test
	public void testConstructorSashimiSalad() {
		assertEquals("Sashimi Salad", sashimisalad1.getName());
		assertEquals(1, sashimisalad1.getSaladType());
		assertEquals(22, sashimisalad1.getTimeleft());
		assertEquals(true, sashimisalad1.getIngredients().contains(tomatosliced));
		assertEquals(true, sashimisalad1.getIngredients().contains(cabbagesliced));
		assertEquals(true, sashimisalad1.getIngredients().contains(fishsliced));
		assertEquals(false, sashimisalad1.getIngredients().contains(new Tomato()));
		assertEquals(false, sashimisalad1.getIngredients().contains(fishfried));
	}
	
	@Test
	public void testisAllIngredientsSimpleSaladTrue() {
		assertEquals(true, simplesalad1.isAllIngredients(dishforsalad1));
		
	}
	
	@Test
	public void testisAllIngredientsSimpleSaladFalse() {
		assertEquals(false, simplesalad1.isAllIngredients(dishforsalad2));
	}
	
	@Test
	public void testisAllIngredientsSashimiSaladTrue() {
		assertEquals(true, sashimisalad1.isAllIngredients(dishforsalad2));
	}
	
	@Test
	public void testisAllIngredientSashimiSaladFalse() {
		assertEquals(false, sashimisalad1.isAllIngredients(dishforsalad1));
	}
	
}
