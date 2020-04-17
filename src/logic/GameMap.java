package logic;

import java.util.ArrayList;

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
	
	public boolean addBlock(Entity e,int x,int y) {
		allEntity.add(e);
		
		
		
		
		
	}
	
	
	
	
	public static void main(String[]args) {
		
	}
}


