package test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import entity.Cabbage;
import entity.Dish;
import entity.Player;
import entity.Station;

public class TestStation {
	Player player1;
	Player player2;
	Player  player3;
	Station station1;
	Station station2;
	Station station3;
	Dish dish;
	Cabbage cabbage;
	public void setUp() {
		player1 = new Player(0,0,0);
		player2 = new Player(1,0,0);
		dish = new Dish();
		player2.setEntityHeld(dish);
		station1  = new Station();


	}
		@Test
//		public void testConstructorStation() {
//			assertEquals(null,player1.getEntityHeld());
//	}
		public void testConstructorPlayer() {
			assertEquals(null,player1.getEntityHeld());
			assertEquals(false,player1.isHolding());
		}
}
