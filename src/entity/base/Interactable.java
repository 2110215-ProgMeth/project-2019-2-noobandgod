package entity.base;

import entity.Player;
import logic.InteractFailedException;

public interface Interactable {
	public abstract boolean interacts(Player e) throws InteractFailedException;
}
