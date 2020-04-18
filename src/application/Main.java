package application;

import java.util.Scanner;

import logic.GameController;
import logic.GameMap;

public class Main{

	public static void main(String[] args) {
		
		String[][] gamemap = CSVParser.readCSV("Book1.csv");
		
		GameController.InitializeMap(gamemap);
			
		GameController.printMap();
		
		GameController.getCurrentGameMap();
		
		
		
	}

}
