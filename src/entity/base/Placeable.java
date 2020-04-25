package entity.base;

import entity.Player;
import test.PlaceFailedException;

public interface Placeable {
	public abstract boolean places(Player e) throws PlaceFailedException;
}
