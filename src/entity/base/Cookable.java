package entity.base;

import exception.CookFailedException;

public interface Cookable {
	public abstract boolean cooks() throws CookFailedException;
}
