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
import sharedObject.RenderableHolder;


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
				String coordinate = " @("+j+","+i+")";
				
				//setting blocks from excel 
				switch (map[i][j]) {
				case "A":
					System.out.println("Station"+coordinate);
					setBlock(new Station(), j, i);
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
		
		updateIsAnyBlockDownward();
		addAllBlocktoRenderableHolder();
		
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
				System.out.println("("+colunumber+","+rownumber+")");
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
		//System.out.println("target x: "+targetx+" ,target y: "+targety);
		
		if (targetx < 0 || targetx > width-1 || targety < 0 || targety > height-1) {
			//out of bound -> return false
			return false;
		} 
		
		if (cellmap[targety][targetx].isBlockEmpty()) {
			//if target block is empty (space) -> return true
			return true;
		} else {
			return false;
		}
	}
	
	public void updateIsAnyBlockDownward() {
		for (int i = 0; i < height-1 ; i++) {
			for (int j = 0; j < width; j++) {
				if (!cellmap[i+1][j].isBlockEmpty() && !cellmap[i][j].isBlockEmpty()) {
					//if tihs block is not empty and below block is also not empty
					//so this block (isanyblockdownward = true) )(used for rendering image)
					cellmap[i][j].getBlock().setAnyBlockDownward(true);
					//cellmap[i][j].getBlock().setImage();
					
				} else if (!cellmap[i][j].isBlockEmpty()) {
					cellmap[i][j].getBlock().setAnyBlockDownward(false);
				}
			}
		}
	}
	
	public void addAllBlocktoRenderableHolder() {
		for(Cell[] row: cellmap) {
			for(Cell c:row) {
				if (!c.isBlockEmpty()) {
					RenderableHolder.getInstance().add(c.getBlock());
				}
			}
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
	
}


