package gui;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import sharedObject.RenderableHolder;

public class DataPane2 extends Canvas{
		private static int width = 800;
		private static int height = 96;
		private static GraphicsContext datagc;
	
	public DataPane2() {
		this.setWidth(width);
		this.setHeight(height);
		
		datagc = this.getGraphicsContext2D();
		drawBackground(datagc);
	
	}
	
	public void drawBackground(GraphicsContext gc) {
		gc.drawImage(RenderableHolder.datapane_bg_Image, 0, 0, this.getWidth(), this.getHeight());
		
	}
}
