package entity;

import entity.base.Block;
import entity.base.Entity;
import logic.Sprites;

public class Obstacle extends Block{
	public char getSymbol() {
		return Sprites.Obstacle;
	}
}
