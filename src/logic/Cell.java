package logic;

import entity.base.Entity;

public class Cell {
	private Entity block;
	private Entity entityOnTop;
	private boolean isBlockEmpty;
	private boolean isOnTop;
	
	public Cell() {
		setOnTop(false);
		setBlockEmpty(true);
	}
	
	public boolean setBlock(Entity e) {
		if (isBlockEmpty) {
			this.block = e;
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
	
}
