package application;

import java.util.Scanner;

import logic.GameMap;

public class Main{

	public static void main(String[] args) {
		
		String[][] gamemap = CSVParser.readCSV("Book1.csv");
		GameMap map = new GameMap(gamemap);
		
		
		
	}

}
