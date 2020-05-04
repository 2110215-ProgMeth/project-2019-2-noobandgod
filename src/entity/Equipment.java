package entity;

import entity.base.Block;
import entity.base.Cookable;
import entity.base.Entity;
import entity.base.Interactable;
import javafx.animation.AnimationTimer;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import screen.GameScreen;

public abstract class Equipment extends Block implements Interactable,Cookable{
	//maybe we will add the interface updatable
	protected boolean isWorking;
	
	//not used yet
	public void drawProgessBar(GraphicsContext gc) {
		int pixel = GameScreen.pixel;
		int x = GameScreen.draw_origin_x+this.getX()*pixel;
		int y = GameScreen.draw_origin_y+this.getY()*pixel-7;
		
		final long startNanoTime = System.nanoTime();
		AnimationTimer animationTimer = new AnimationTimer() {
			@Override
			public void handle(long currentNanoTime) {
				double t = ((currentNanoTime - startNanoTime) / 1000000000.0);
				int maxwidth = GameScreen.pixel;
				int width = (int) (t/5)*maxwidth;
				int height = 5;
				
				
				gc.setFill(Color.WHITE);
				gc.fillRect(0, 0, width, height);
				
				
			}
		};
		
	}
}
