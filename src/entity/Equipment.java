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
	public void drawProgessBar(GraphicsContext gc, int maxTime) {
		final long startNanoTime = System.nanoTime();
		
		int pixel = GameScreen.pixel;
		int x = GameScreen.draw_origin_x+this.getX()*pixel;
		int y = GameScreen.draw_origin_y+this.getY()*pixel-7;
		
		double maxwidth = 64;
		double maxheight = 5;
		
		AnimationTimer animationTimer = new AnimationTimer() {
			double width = 0;
			@Override
			public void handle(long currentNanoTime) {
				double t = ((currentNanoTime - startNanoTime) / 1000000000.0);
				width = (t/maxTime)*maxwidth;
				
				gc.clearRect(x, y, maxwidth, maxheight);
				
				gc.setFill(Color.ALICEBLUE);
				gc.fillRect(x, y, maxwidth , maxheight);
				
				gc.setFill(Color.GREEN);
				gc.fillRect(x, y, width, maxheight);
				
				if (width >= maxwidth) {
					gc.clearRect(x, y, maxwidth+0.1, maxheight);
					this.stop();
				}
			}
		};
		animationTimer.start();
		
	}
}
