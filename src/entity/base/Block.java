package entity.base;

import javafx.scene.image.Image;

public abstract class Block extends Entity{
	protected boolean isAnyBlockDownward = false;
	protected Image image;
	
	public abstract char getSymbol();

	public boolean isAnyBlockDownward() {
		return isAnyBlockDownward;
	}

	public void setAnyBlockDownward(boolean isAnyBlockDownward) {
		this.isAnyBlockDownward = isAnyBlockDownward;
	}

	public Image getImage() {
		return image;
	}
	
	public abstract void setImage();

	
	
	
}
