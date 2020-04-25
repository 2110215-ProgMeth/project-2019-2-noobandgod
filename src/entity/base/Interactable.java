package entity.base;

import entity.Player;
import test.InteractFailedException;
import test.SendFoodFailedException;

public interface Interactable {
	public abstract boolean interacts(Player e) throws InteractFailedException, SendFoodFailedException;
}
