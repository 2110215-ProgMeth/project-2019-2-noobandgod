package test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import entity.Cabbage;
import entity.Dish;
import entity.Player;
import entity.Station;
import entity.Tomato;
import exception.InteractFailedException;

public class TestStation {
	Player player1;
	Player player2;
	Player  player3;
	Player player4;
	Station station1;
	Station station2;
	Station station3;
	Station station4;
	Dish dish;
	Dish dish1;
	Dish dish2;
	Cabbage cabbage;
	Tomato tomato;
	public void setUp() throws InteractFailedException{
		cabbage = new Cabbage();
		dish = new Dish();
		dish1 = new Dish();
		tomato = new Tomato();
		
		player1 = new Player(0,0,0);
		
		player2 = new Player(1,0,0);
		player2.setEntityHeld(dish);
		
		player3 = new Player(2,0,0);
		player3.setEntityHeld(cabbage);
		
		player4 = new Player(3,0,0);
		player4.setEntityHeld(tomato);
		
		station1  = new Station();
		
		station2 = new Station();
		station2.setOnStationExists(dish1);

		station3 = new Station();
		station3.setOnStationExists(cabbage);
		
		station4 = new Station();
		station4.setOnStationExists(dish2);
		

			station1.interacts(player2);// nothing and dish

			

		//station1.interacts(player3);
		station2.interacts(player3);// dish and cabbage
		//station2.interacts(player1);
		station3.interacts(player1);// cabbage and nothing
		//station3.interacts(player2);
		station4.interacts(player4);// tomato and dish
		
		
	}
		@Test
	public void testConstructorStation() throws Inter{
		assertEquals(false,station1.interacts(player1));
		assertEquals(true,station1.interacts(player2));
		assertEquals(true,station1.interacts(player3));
		assertEquals(true,station2.interacts(player1));
		assertEquals(false,station2.interacts(player2));
		assertEquals(true,station2.interacts(player3));
		assertEquals(true,station3.interacts(player1));
		assertEquals(true,station3.interacts(player2));
		assertEquals(false,station3.interacts(player3));
		assertEquals(true,station4.interacts(player4));
			
	}
	public void testConstructorPlayer() {
//		assertEquals(false,player1.isHolding());
//		assertEquals(null,player1.getEntityHeld());
//		assertEquals(true,player2.isHolding());
//		assertEquals(true,player2.getEntityHeld() instanceof Dish);
//		assertEquals(false,player3.isHolding());
//		assertEquals(true,player3.getEntityHeld() instanceof Cabbage);
	}
	
	public void testStation() {
		assertEquals(false,player2.isHolding());
		assertEquals(null,player2.getEntityHeld());
		assertEquals(true,station1.getOnStationExists() instanceof Dish);
		
		assertEquals(null,station3.getOnStationExists());
		assertEquals(true,player1.getEntityHeld() instanceof Cabbage);
		assertEquals(true,player1.isHolding());
		
		assertEquals(null,player3.getEntityHeld());
		assertEquals(false,player3.isHolding());
		assertEquals(true,station2.getOnStationExists() instanceof Dish);
	//	assertEquals(true,station2.getOnStationExists());
		
		assertEquals(true,player4.getEntityHeld() instanceof Dish);
		assertEquals(true,player4.isHolding());
		assertEquals(null,station4.getOnStationExists());
		
	}
}
