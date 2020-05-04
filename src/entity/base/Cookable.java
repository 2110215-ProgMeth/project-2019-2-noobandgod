package entity.base;

import entity.Player;
import exception.CookFailedException;

public interface Cookable {
	public abstract boolean cooks(Player p);

	public abstract boolean isCookable(Player p) throws CookFailedException;
}
