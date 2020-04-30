package logic;

import entity.base.Block;
import entity.base.Entity;

public class Cell {
	private Block block;
	private Entity entityOnTop;
	private boolean isBlockEmpty;
	private boolean isOnTop;
	
	public Cell() {
		this.block = null;
		setOnTop(false);
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

	public boolean isOnTop() {
		return isOnTop;
	}

	public void setOnTop(boolean isOnTop) {
		this.isOnTop = isOnTop;
	}

	public void setEntityOnTop(Entity entityOnTop) {
		this.entityOnTop = entityOnTop;
	}

	public Block getBlock() {
		return block;
	}

	public Entity getEntityOnTop() {
		return entityOnTop;
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
			if(isOnTop) {
				resultString += "\nThis block also contains:" + entityOnTop.getClass().toString();
			} else {
				resultString += "\nThis block doesn't contain anything on it";
			}
		}
		resultString += "\n________________________";
		return resultString;
	}

	
}
