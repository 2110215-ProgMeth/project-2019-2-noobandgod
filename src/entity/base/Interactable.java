package entity.base;

import entity.Player;
import exception.InteractFailedException;

public interface Interactable {
	public abstract boolean interacts(Player p) throws InteractFailedException;
}
