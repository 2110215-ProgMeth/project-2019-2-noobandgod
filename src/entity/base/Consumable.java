package entity.base;

import entity.Player;
import logic.ConsumeFailedException;

public interface Consumable {
	public abstract boolean consumes(Player e) throws ConsumeFailedException;
}
