package application;

import java.util.Scanner;

public class Main{

	public static void main(String[] args) {
		
		String[][] gamemap = CSVParser.readCSV("Book1.csv");
		System.out.println(gamemap.toString());
		
		
	}

}
