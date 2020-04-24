package entity.base;

import entity.Player;
import logic.PlaceFailedException;

public interface Placeable {
	public abstract boolean places(Player e) throws PlaceFailedException;
}
