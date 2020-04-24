package entity.base;

import entity.Player;
import logic.InteractFailedException;
import logic.SendFoodFailedException;

public interface Interactable {
	public abstract boolean interacts(Player e) throws InteractFailedException, SendFoodFailedException;
}
