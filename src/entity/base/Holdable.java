package entity.base;

import entity.Player;
import logic.ConsumeFailedException;

public interface Holdable {
	public abstract boolean holds(Player e) throws HoldFailedException;
}
