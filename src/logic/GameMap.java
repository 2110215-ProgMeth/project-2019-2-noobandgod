package logic;

import java.util.ArrayList;

import entity.Dish;
import entity.Ingredient;
import entity.base.Entity;


public class GameMap {
	private int width;
	private int height;
	private Cell[][] cellmap;

	private ArrayList<Entity> allEntity;
	
	
	public GameMap(String [][] map) {
		allEntity = new ArrayList<Entity>();
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
					break;
				case "C":
					System.out.println("CabbageStorage"+coordinate);
					break;
				case "D":
					System.out.println("FishStorage"+coordinate);
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
	
	public boolean setBlock(Entity e,int x,int y) {
		allEntity.add(e);
		
		e.setX(x);
		e.setY(y);
		
		boolean b = cellmap[y][x].setBlock(e);
		return b;
	}
	
	public boolean placeEntityOnBlock(Entity e,int x,int y) {
		Cell cell = cellmap[y][x];
		if (!cell.isOnTop()) {
			if(e instanceof Dish) {
				cell.setEntityOnTop(e);
				return true;
			} else if (e instanceof Ingredient) {
				//check ว่า ingredient ผ่านกระบวนการ cook แล้วรึยัง ถ้าผ่านแล้ววางไม่ได้
				cell.setEntityOnTop(e);
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
		
	}
	
	public Entity getBlock(int x,int y) {
		return cellmap[y][x].getBlock();
	}
	
	public Entity removeEntityOnBlock(int x,int y) {
		if (cellmap[y][x].isOnTop()) {
			Entity e = cellmap[y][x].
			
			
		} else {
			
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


