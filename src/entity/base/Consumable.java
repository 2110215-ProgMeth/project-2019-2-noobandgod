package entity.base;

import entity.Player;
import test.ConsumeFailedException;

public interface Consumable {
	public abstract boolean consumes(Player e) throws ConsumeFailedException;
}
