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
		cabbage = new Cabbage();
		dish = new Dish();
		
		player1 = new Player(0,0,0);
		
		player2 = new Player(1,0,0);
		player2.setEntityHeld(dish);
		
		player3 = new Player(2,0,0);
		player3.setEntityHeld(cabbage);
		
		
		station1  = new Station();
		
		station2 = new Station();
		station2.setOnStationExists(dish);

		station3 = new Station();
		station3.setOnStationExists(cabbage);

	}
		@Test
	public void testConstructorStation() {
		assertEquals(false,station1.interacts(player1));
		assertEquals(true,station1.interacts(player2));
		assertEquals(true,station1.interacts(player3));
		assertEquals(true,station2.interacts(player1));
		assertEquals(false,station2.interacts(player2));
		assertEquals(true,station2.interacts(player3));
		assertEquals(true,station3.interacts(player1));
		assertEquals(true,station3.interacts(player2));
		assertEquals(false,station3.interacts(player3));
			
	}
	public void testConstructorPlayer() {
		assertEquals(false,player1.isHolding());
		assertEquals(null,player1.getEntityHeld());
		assertEquals(true,player2.isHolding());
		assertEquals(true,player2.getEntityHeld() instanceof Dish);
		assertEquals(false,player3.isHolding());
		assertEquals(true,player3.getEntityHeld() instanceof Cabbage);
	}
	public void testStation1() {
	
	}
}
