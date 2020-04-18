package logic;

import java.util.ArrayList;

import entity.CabbageStorage;
import entity.Dish;
import entity.FishStorage;
import entity.Ingredient;
import entity.TomatoStorage;
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
					break;
				case "F":
					System.out.println("Bin"+coordinate);
					break;
				case "G":
					System.out.println("Obstacle"+coordinate);
					break;
				case "H":
					System.out.println("FoodCounter"+coordinate);
					break;
				case "I":
					System.out.println("CuttingBoard"+coordinate);
					break;
				case "J":
					System.out.println("FryingPan"+coordinate);
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
		
		System.out.println("   0 1 2 3 4 5 6 7 8 9 (X)");
		System.out.println("(Y)-------------------");
		
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
		
	public boolean setBlock(Entity e,int x,int y) {		
		e.setX(x);
		e.setY(y);
		
		boolean b = cellmap[y][x].setBlock(e);
		return b;
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
	
	
}


