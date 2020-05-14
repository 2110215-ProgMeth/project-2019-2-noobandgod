package entity.base;

import sharedObject.IRenderable;

public abstract class Entity implements IRenderable,Cloneable {
	protected int x;
	protected int y;
	protected boolean isDestroyed;

	@Override
	public Object clone() {
		try {
			return super.clone();
		} catch (CloneNotSupportedException e) {
			throw new InternalError("can't clone");
		}
	}
	
	public String getCoordinate() {
		return "("+this.getX()+","+this.getY()+")";
	}
	
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public boolean isDestroyed() {
		return isDestroyed;
	}
	public void setDestroyed(boolean isDestroyed) {
		this.isDestroyed = isDestroyed;
	}
}
