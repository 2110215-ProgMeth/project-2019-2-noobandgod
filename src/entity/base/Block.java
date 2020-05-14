package entity.base;

public abstract class Block extends Entity{
	protected boolean isAnyBlockDownward = false;
	
	public abstract char getSymbol();

	public boolean isAnyBlockDownward() {
		return isAnyBlockDownward;
	}

	public void setAnyBlockDownward(boolean isAnyBlockDownward) {
		this.isAnyBlockDownward = isAnyBlockDownward;
	}
}
