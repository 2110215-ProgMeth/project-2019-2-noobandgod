package logic;

import application.CSVParser;
import entity.Bin;
import entity.CabbageStorage;
import entity.CuttingBoard;
import entity.Dish;
import entity.DishPicker;
import entity.FishStorage;
import entity.FoodCounter;
import entity.FryingPan;
import entity.Ingredient;
import entity.Obstacle;
import entity.Station;
import entity.TomatoStorage;
import entity.base.Block;
import entity.base.Entity;


public class GameMap {
	private int width;
	private int height;
	private Cell[][] cellmap;

	public GameMap(String [][] map) {
		int row = map.length;
		int column = map[0].length;
		setHeight(row);
		setWidth(column);
		
		
		cellmap = new Cell[row][column];
		for(int i=0; i<row; i++) {
			for(int j=0; j<column; j++) {
				
				cellmap[i][j] = new Cell(); 
				String coordinate = " @("+i+","+j+")";
				
				//setting blocks from excel 
				switch (map[i][j]) {
				case "A":
					System.out.println("Station"+coordinate);
					setBlock(new Station(0), j, i);
					break;
					
				case "B":
					System.out.println("TomatoStorage"+coordinate);
					setBlock(new TomatoStorage(), j, i);
					break;
				case "C":
					System.out.println("CabbageStorage"+coordinate);
					setBlock(new CabbageStorage(), j, i);
					break;
				case "D":
					System.out.println("FishStorage"+coordinate);
					setBlock(new FishStorage(), j, i);
					break;
				case "E":
					System.out.println("DishPicker"+coordinate);
					setBlock(new DishPicker(), j, i);
					break;
				case "F":
					System.out.println("Bin"+coordinate);
					setBlock(new Bin(), j, i);
					break;
				case "G":
					System.out.println("Obstacle"+coordinate);
					setBlock(new Obstacle(), j, i);
					break;
				case "H":
					System.out.println("FoodCounter"+coordinate);
					setBlock(new FoodCounter(), j, i);
					break;
				case "I":
					System.out.println("CuttingBoard"+coordinate);
					setBlock(new CuttingBoard(), j, i);
					break;
				case "J":
					System.out.println("FryingPan"+coordinate);
					setBlock(new FryingPan(), j, i);
					break;
				case "O":
					System.out.println("SPACE"+coordinate);
					
					break;
				
				default:
					System.out.println("Error: Placing Block"+coordinate);
					break;
				}
					
			}
		}
	}
	
	public void printMap() {
		
		System.out.println("   0 1 2 3 4 5 6 7 8 9 10 (X)");
		System.out.println("(Y)----------------------");
		
		int rownumber = 0;
		for(Cell[] row: cellmap) {
			String rowstring = rownumber+" |";
			for(Cell c:row) {
				rowstring += c.getSymbol()+" ";
			}
			System.out.println(rowstring);
			rownumber += 1;
		}
	}
	
	public void printEachCell() {
		int rownumber = 0;
		for(Cell[] row: cellmap) {
			int colunumber = 0;
			for(Cell c:row) {
				System.out.println("("+rownumber+","+colunumber+")");
				System.out.println(c.toString());
				colunumber++;
			}
			rownumber += 1;
		}
	}
		
	public boolean setBlock(Block b,int x,int y) {		
		b.setX(x);
		b.setY(y);
		
		boolean bool = cellmap[y][x].setBlock(b);
		return bool;
	}
	
	
	public Entity getBlock(int x,int y) {
		return cellmap[y][x].getBlock();
	}
	
	public boolean placeEntityOnBlock(Entity e,int x,int y) {
		Cell cell = cellmap[y][x];
		if (!cell.isOnTop()) {
			if(e instanceof Dish) {
				cell.setEntityOnTop(e);
				return true;
			} else if (e instanceof Ingredient) {
				//check ว่า ingredient ผ่านกระบวนการ cook แล้วรึยัง ถ้าผ่านแล้ววางไม่ได้**
				cell.setEntityOnTop(e);
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
		
	}

	
	public Entity removeEntityOnBlock(int x,int y) {
		if (cellmap[x][y].isOnTop()) {
			Cell cell = cellmap[y][x];
			Entity e = cell.getEntityOnTop();
			cell.setEntityOnTop(null);
			cell.setOnTop(false);
			return e;
		} else {
			return null;
		}
	}
	
	public boolean isMovePossible(int targetx, int targety) {
		if (targetx < 0 || targetx > width || targety < 0 || targety > height) {
			//out of bound -> return false
			return false;
		} else if (cellmap[targety][targetx].isBlockEmpty()) {
			//if target block is empty (space) -> return true
			return true;
		} else {
			return false;
		}
	}
	
	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}
	
	public Cell[][] getCellmap() {
		return cellmap;
	}

	public static void main (String[]args) {
		String[][] gamemap = CSVParser.readCSV("Book1.csv");
		GameController.InitializeMap(gamemap);
		
		GameController.getCurrentGameMap().printMap();
		GameController.getCurrentGameMap().printEachCell();
	}
	
	
}


