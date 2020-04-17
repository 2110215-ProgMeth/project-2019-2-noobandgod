package logic;

public class GameMap {
	private int width;
	private int height;
	private Cell[][] cellmap;
	
	public GameMap(int row, int column) {
		setHeight(row);
		setWidth(column);
		
		cellmap = new Cell[row][column];
		for(int i=0; i<row; i++) {
			for(int j=0; j<column; j++) {
				cellmap[i][j] = new Cell(); 
			}
		}
	}
	
	public GameMap(String [][] map) {
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
	
	
	
	public static void main(String[]args) {
		
	}
}


