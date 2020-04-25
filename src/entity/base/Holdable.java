package entity.base;

import Exception.ConsumeFailedException;
import Exception.HoldFailedException;
import entity.Player;

public interface Holdable {
	public abstract boolean holds(Player e) throws HoldFailedException, HoldFailedException;
}
