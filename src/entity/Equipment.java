package entity;

import entity.base.Block;
import entity.base.Cookable;
import entity.base.Interactable;
import javafx.animation.AnimationTimer;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import screen.GameScreen;

public abstract class Equipment extends Block implements Interactable,Cookable{
	protected boolean isWorking;
	
	public void drawProgessBar(GraphicsContext gc, int maxTime) {
		final long startNanoTime = System.nanoTime();
		
		int pixel = GameScreen.pixel;
		int X = GameScreen.draw_origin_x+x*pixel;
		int Y = GameScreen.draw_origin_y+y*pixel-14;
		
		double maxwidth = 64;
		double maxheight = 10;
		
		AnimationTimer animationTimer = new AnimationTimer() {
			double width = 0;
			@Override
			public void handle(long currentNanoTime) {
				double t = ((currentNanoTime - startNanoTime) / 1000000000.0);
				width = (t/maxTime)*maxwidth;
				
				gc.clearRect(X, Y, maxwidth, maxheight);
				
				gc.setStroke(Color.GREEN);
				gc.setLineWidth(1);
				
				gc.setFill(Color.WHITE);
				gc.fillRect(X, Y, maxwidth , maxheight);
				gc.strokeRect(X, Y, maxwidth, maxheight);
				
				gc.setFill(Color.LIMEGREEN);
				gc.fillRect(X, Y, width, maxheight);
				
				if (width >= maxwidth) {
					gc.clearRect(X, Y, maxwidth+0.1, maxheight);
					this.stop();
				}
			}
		};
		animationTimer.start();
		
	}
	public boolean isWorking() {
		return isWorking;
	}

	public void setWorking(boolean isWorking) {
		this.isWorking = isWorking;
	}

}
