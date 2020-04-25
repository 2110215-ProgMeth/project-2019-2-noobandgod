package entity.base;

import Exception.PlaceFailedException;
import entity.Player;

public interface Placeable {
	public abstract boolean places(Player e) throws PlaceFailedException;
}
