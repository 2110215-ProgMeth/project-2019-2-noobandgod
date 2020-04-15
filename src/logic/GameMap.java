package logic;

public class GameMap {
	private int width;
	private int height;
	private Cell[][] cellmap;
	
	public GameMap(int row, int column) {
		setHeight(row);
		setWidth(column);
		
		cellmap = new Cell[row][column];
		
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
