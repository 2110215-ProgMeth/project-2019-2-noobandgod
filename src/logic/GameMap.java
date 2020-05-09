package logic;

import application.CSVParser;
import entity.Bin;
import entity.CabbageStorage;
import entity.CuttingBoard;
import entity.Dish;
import entity.DishPicker;
import entity.Equipment;
import entity.FishStorage;
import entity.FoodCounter;
import entity.FryingPan;
import entity.Ingredient;
import entity.Obstacle;
import entity.Player;
import entity.Station;
import entity.TomatoStorage;
import entity.base.Block;
import entity.base.Cookable;
import entity.base.Entity;
import entity.base.Interactable;
import exception.CookFailedException;
import exception.InteractFailedException;
import exception.SendFoodFailedException;
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
					//System.out.println("Station"+coordinate);
					setBlock(new Station(), j, i);
					break;
					
				case "B":
					//System.out.println("TomatoStorage"+coordinate);
					setBlock(new TomatoStorage(), j, i);
					break;
				case "C":
					//System.out.println("CabbageStorage"+coordinate);
					setBlock(new CabbageStorage(), j, i);
					break;
				case "D":
					//System.out.println("FishStorage"+coordinate);
					setBlock(new FishStorage(), j, i);
					break;
				case "E":
					//System.out.println("DishPicker"+coordinate);
					setBlock(new DishPicker(), j, i);
					break;
				case "F":
					//System.out.println("Bin"+coordinate);
					setBlock(new Bin(), j, i);
					break;
				case "G":
					//System.out.println("Obstacle"+coordinate);
					setBlock(new Obstacle(), j, i);
					break;
				case "H":
					//System.out.println("FoodCounter"+coordinate);
					setBlock(new FoodCounter(), j, i);
					break;
				case "I":
					//System.out.println("CuttingBoard"+coordinate);
					setBlock(new CuttingBoard(), j, i);
					break;
				case "J":
					//System.out.println("FryingPan"+coordinate);
					setBlock(new FryingPan(), j, i);
					break;
				case "O":
					//System.out.println("SPACE"+coordinate);
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
	
	public boolean isMovePossible(Player p,int targetx, int targety) {
		//System.out.println("target x: "+targetx+" ,target y: "+targety);
		
		if (targetx < 0 || targetx > width-1 || targety < 0 || targety > height-1) {
			//out of bound -> return false
			return false;
		} 
		
		if(!cellmap[targety][targetx].isBlockEmpty()) {
			return false;
		}
		
		if (GameController.getAmountofPlayer() == 2) {
			if(p.getPlayerNumber() == 0) {
				if (targetx == GameController.getPlayers(1).getX() && targety == GameController.getPlayers(1).getY()) {
					return false;
				} else {
					return true;
				}
			} else if (p.getPlayerNumber() == 1) {
				if (targetx == GameController.getPlayers(0).getX() && targety == GameController.getPlayers(0).getY()) {
					return false;
				} else {
					return true;
				}
			} else {
				return false;
			}
		} else if (GameController.getAmountofPlayer() == 1) {
			return true;
		} else {
			return false;
		}
	}
	
	public boolean isInteractPossible(Player p,int targetx, int targety) {
		System.out.println("You are interacting @("+targetx+","+targety+")");
		
		if (targetx < 0 || targetx > width-1 || targety < 0 || targety > height-1) {
			//out of bound -> return false
			System.out.println("Out of bound interacting");
			return false;
		} 
		
		if (cellmap[targety][targetx].isBlockEmpty()) {
			//if no block -> no interact
			System.out.println("There is no block you wished to interact");
			return false;
		}
		
		if (cellmap[targety][targetx].getBlock() instanceof Interactable) {
			return true;
		} else {
			return false;
		}
	}
	
	public boolean interactWithBlockTarget(Player p,int targetx, int targety, int interactType) {
		
		if (interactWithAnotherPlayer(p, targetx, targety)) {
			if (p.getPlayerNumber() == 0) {
				Interactable player = (Interactable) GameController.getPlayers(1);
				try {
					if(player.interacts(p)) {
						return true;
					} else {
						return false;
					}
				} catch (InteractFailedException | SendFoodFailedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} else if (p.getPlayerNumber() == 1) {
				Interactable player = (Interactable) GameController.getPlayers(0);
				try {
					if(player.interacts(p)) {
						return true;
					} else {
						return false;
					}
				} catch (InteractFailedException | SendFoodFailedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}	
			}
		}
		
		if(isInteractPossible(p, targetx, targety)) {
			Block target = cellmap[targety][targetx].getBlock();

			if(interactType == 0) {
				Interactable t = (Interactable) target;
				try {
					if(t.interacts(p)) {
						return true;
					} else
						return false;
				} catch (InteractFailedException | SendFoodFailedException e) {
					e.printStackTrace();
					return false;
				}
			} 
			
			else if (interactType == 1) {
				if (target instanceof Cookable) {
					Cookable t = (Cookable) target;
					try {
						if(t.cooks(p)) {
							return true;
						} else
							return false;
					} catch (CookFailedException e) {
						e.printStackTrace();
						return false;
					}
				} else {
					System.out.println("THIS IS NOT EQUIPMENT");
					return false;
				}
			}
			//interactType dosn't match!
			return false;
		}
		else {
			return false; //if interact is not possible
			}
	}
	
	public boolean interactWithAnotherPlayer(Player p, int targetx, int targety) {
		if (GameController.getAmountofPlayer() == 2) {
			if(p.getPlayerNumber() == 0) {
				if(targetx == GameController.getPlayers(1).getX() && targety == GameController.getPlayers(1).getY()) {
					return true;
				}
			} else if (p.getPlayerNumber() == 1) {
				if(targetx == GameController.getPlayers(0).getX() && targety == GameController.getPlayers(0).getY()) {
					return true;
				}
			} else {
				return false;
			}
		} else {
			return false;
		}
		return false;
	}

	
	public void updateIsAnyBlockDownward() {
		for (int i = 0; i < height-1 ; i++) {
			for (int j = 0; j < width; j++) {
				if (!cellmap[i+1][j].isBlockEmpty() && !cellmap[i][j].isBlockEmpty() && !(cellmap[i+1][j].getBlock() instanceof Obstacle)) {
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


