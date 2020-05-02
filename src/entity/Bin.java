package entity;

import entity.base.Block;

import entity.base.Entity;
import entity.base.Interactable;
import exception.InteractFailedException;
import logic.Sprites;

public class Bin extends Block implements Interactable{
	public boolean interacts(Player e) throws InteractFailedException{
		if (e.isHolding()) {
			e.setEntityHeld(null);
			e.setHolding(false);
			return true;
		}else{
			throw new InteractFailedException("There is nothing to be cast");//throw an exception; nothing to be consumed
		}
	}
	public char getSymbol() {
		return Sprites.Bin;
	}
}
