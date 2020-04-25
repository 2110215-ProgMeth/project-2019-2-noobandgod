package entity.base;

import entity.Player;
import test.ConsumeFailedException;
import test.HoldFailedException;

public interface Holdable {
	public abstract boolean holds(Player e) throws HoldFailedException, HoldFailedException;
}
