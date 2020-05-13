package logic;

import entity.base.Block;

public class Cell {
	private Block block;
	private boolean isBlockEmpty;
	
	public Cell() {
		this.block = null;
		setBlockEmpty(true);
	}
	
	public boolean setBlock(Block b) {
		if (isBlockEmpty) {
			this.block = b;
			this.isBlockEmpty = false;
			return true;
		}
		return false;
	}
	
	public boolean isBlockEmpty() {
		return isBlockEmpty;
	}

	public void setBlockEmpty(boolean isBlockEmpty) {
		this.isBlockEmpty = isBlockEmpty;
	}



	public Block getBlock() {
		return block;
	}


	
	public char getSymbol() {
		if(isBlockEmpty) {
			return 'O';
		} else {
			return block.getSymbol();
		}
	}
	
	
	public String toString() {
		String resultString;
		if(isBlockEmpty) {
			resultString = "This block is SPACE";
		}
		else {
			resultString = "This block is: " + block.getClass().toString();
			resultString += "\nIs there any block below: " + block.isAnyBlockDownward();

		}
		resultString += "\n________________________";
		return resultString;
	}

	
}
