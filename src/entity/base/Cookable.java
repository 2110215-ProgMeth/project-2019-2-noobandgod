package entity.base;

import logic.CookFailedException;

public interface Cookable {
	public abstract boolean cooks() throws CookFailedException;
}
