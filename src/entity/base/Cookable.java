package entity.base;

import Exception.CookFailedException;

public interface Cookable {
	public abstract boolean cooks() throws CookFailedException;
}
