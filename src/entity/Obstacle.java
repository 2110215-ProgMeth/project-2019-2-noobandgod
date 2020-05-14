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
		return getY()*3;
	}

	@Override
	public void draw(GraphicsContext gc) {
		int pixel = GameScreen.pixel;
		int x = GameScreen.draw_origin_x+this.getX()*pixel;
		int y = GameScreen.draw_origin_y+this.getY()*pixel;
		
		gc.drawImage(RenderableHolder.obstacle_Image, x, y-6);
	}

	@Override
	public boolean isVisible() {
		return true;
	}	
}
