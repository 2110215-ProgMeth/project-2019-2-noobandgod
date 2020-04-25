package entity.base;

import entity.Player;
import exception.ConsumeFailedException;
import exception.HoldFailedException;

public interface Holdable {
	public abstract boolean holds(Player e) throws HoldFailedException, HoldFailedException;
}
