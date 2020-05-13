package entity.base;

import entity.Player;
import exception.InteractFailedException;

public interface Cookable {
	public abstract boolean cooks(Player p) throws InteractFailedException;
}
