package entity.base;

import entity.Player;
import exception.PlaceFailedException;

public interface Placeable {
	public abstract boolean places(Player e) throws PlaceFailedException;
}
