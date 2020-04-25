package entity.base;

import entity.Player;
import exception.ConsumeFailedException;

public interface Consumable {
	public abstract boolean consumes(Player e) throws ConsumeFailedException;
}
