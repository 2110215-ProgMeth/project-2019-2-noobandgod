package entity.base;

import entity.Player;
import exception.SendFoodFailedException;

public interface Interactable {
	public abstract boolean interacts(Player e) throws  SendFoodFailedException;
}
