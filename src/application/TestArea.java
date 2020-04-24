package application;

import logic.GameController;

public class TestArea {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[][] gamemap = CSVParser.readCSV("Book1.csv");
		
		GameController.InitializeMap(gamemap);
			
		GameController.printMap();
		
		GameController.getCurrentGameMap();
	}

}
