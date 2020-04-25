package entity.base;

import Exception.InteractFailedException;
import Exception.SendFoodFailedException;
import entity.Player;

public interface Interactable {
	public abstract boolean interacts(Player e) throws InteractFailedException, SendFoodFailedException;
}
