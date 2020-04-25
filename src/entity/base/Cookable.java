package entity.base;

import test.CookFailedException;

public interface Cookable {
	public abstract boolean cooks() throws CookFailedException;
}
