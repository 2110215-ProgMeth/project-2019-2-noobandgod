package entity;

import entity.base.Block;
import javafx.scene.canvas.GraphicsContext;
import logic.Sprites;
import screen.GameScreen;
import sharedObject.RenderableHolder;

public class Obstacle extends Block{
	public char getSymbol() {
		return Sprites.Obstacle;
	}

	@Override
	public int getZ() {
		return y*3;
	}

	@Override
	public void draw(GraphicsContext gc) {
		int pixel = GameScreen.pixel;
		int X = GameScreen.draw_origin_x+x*pixel;
		int Y = GameScreen.draw_origin_y+y*pixel;
		
		gc.drawImage(RenderableHolder.obstacle_Image, X, Y-6);
	}

	@Override
	public boolean isVisible() {
		return true;
	}	
}
