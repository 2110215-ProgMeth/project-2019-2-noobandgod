package entity.base;

import Exception.ConsumeFailedException;
import entity.Player;

public interface Consumable {
	public abstract boolean consumes(Player e) throws ConsumeFailedException;
}
