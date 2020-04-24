package entity.base;

import entity.Player;
import logic.ConsumeFailedException;
import logic.HoldFailedException;

public interface Holdable {
	public abstract boolean holds(Player e) throws HoldFailedException, HoldFailedException;
}
