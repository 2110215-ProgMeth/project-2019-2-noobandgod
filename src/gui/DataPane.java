package gui;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import logic.GameController;
import sharedObject.RenderableHolder;
import sun.jvm.hotspot.gc.shared.GCCause;

public class DataPane extends Canvas{
		private static int width = 800;
		private static int height = 96;
		private static GraphicsContext datagc;
		private static int score;
		private static int money;
	
	public DataPane() {
		this.setWidth(width);
		this.setHeight(height);
		
		datagc = this.getGraphicsContext2D();
	
	}
	
	public void update() {
		datagc.clearRect(0, 0, this.getWidth(), this.getHeight());
		drawBackground(datagc);
		score = GameController.getScore_count();
		money = GameController.getCoin_count();
		drawScoreandMoney(datagc);
	}
	
	public void drawBackground(GraphicsContext gc) {
		gc.drawImage(RenderableHolder.datapane_bg_Image, 0, 0, this.getWidth(), this.getHeight());
	}
	
	public void drawScoreandMoney(GraphicsContext gc) {
		gc.setFill(Color.WHITESMOKE);
		gc.setFont(new Font(28));
		gc.fillText(Integer.toString(score), 82, 68);
		gc.fillText(Integer.toString(money), 276, 68);
	}

}
