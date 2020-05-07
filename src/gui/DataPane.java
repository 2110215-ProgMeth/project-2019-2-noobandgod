package gui;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import logic.GameController;
import sharedObject.RenderableHolder;

public class DataPane extends Canvas{
		private static int width = 800;
		private static int height = 96;
		private static GraphicsContext datagc;
		private static int score;
		private static int money;
		private static int Tomato_amount;
		private static int Cabbage_amount;
		private static int Fish_amount;

	public DataPane() {
		this.setWidth(width);
		this.setHeight(height);
		
		datagc = this.getGraphicsContext2D();
	
	}
	
	public void update() {
		datagc.clearRect(0, 0, this.getWidth(), this.getHeight()); //don't remove this line
		drawBackground(datagc);
		
		score = GameController.getScore_count();
		money = GameController.getCoin_count();
		Tomato_amount = GameController.getTomato_AMOUNT();
		Cabbage_amount = GameController.getCabbage_AMOUNT();
		Fish_amount = GameController.getFish_AMOUNT();
		
		drawScoreandMoney(datagc);
		drawIngredientAmount(datagc);
	}
	
	public void drawBackground(GraphicsContext gc) {
		gc.drawImage(RenderableHolder.datapane_bg_Image, 0, 0, this.getWidth(), this.getHeight());
	}
	
	public void drawScoreandMoney(GraphicsContext gc) {
		gc.setFill(Color.WHITESMOKE);
		gc.setFont(new Font(28));
		
		//Score
		if (0 <= score && score <= 9) {
			gc.fillText(Integer.toString(score), 90, 68);
		} else if (10 <= score && score <= 99) {
			gc.fillText(Integer.toString(score), 82, 68);
		} else if (100 <= score && score <= 999) {
			gc.fillText(Integer.toString(score), 74, 68);
		} else if (1000 <= score && score <= 9999) {
			gc.fillText(Integer.toString(score), 66, 68);
		} else if (10000 <= score && score <= 99999) {
			gc.fillText(Integer.toString(score), 58, 68);
		}
		
		//Money
		if (0 <= money && money <= 9) {
			gc.fillText(Integer.toString(money), 285, 68);
		} else if (10 <= money && money <= 99){
			gc.fillText(Integer.toString(money), 277, 68);
		} else if (100 <= money && money <= 999) {
			gc.fillText(Integer.toString(money), 268, 68);
		} else if (1000 <= money && money <= 9999) {
			gc.fillText(Integer.toString(money), 260, 68);
		} else if (10000 <= money && money <= 99999) {
			gc.fillText(Integer.toString(money), 252, 68);
		}
	}
	
	public void drawIngredientAmount(GraphicsContext gc) {
		//Tomato
		if (Tomato_amount == 0) {
			gc.drawImage(RenderableHolder.crate_tomato_empty_Image, 410, 20, 53, 48);
		} else {
			gc.drawImage(RenderableHolder.crate_tomato_Image, 410, 20, 53, 48);
		}
		
		if(0 <= Tomato_amount && Tomato_amount <= 9) {
			gc.setFill(Color.LIGHTPINK);
			if (Tomato_amount == 0) {
				gc.setFill(Color.RED);
			}
			gc.setFont(new Font(45));
			gc.fillText(Integer.toString(Tomato_amount), 482, 61);
		} else if (10 <= Tomato_amount && Tomato_amount <= 99) {
			gc.setFill(Color.LIGHTPINK);
			gc.setFont(new Font(35));
			gc.fillText(Integer.toString(Tomato_amount), 476, 58);
		}
		
		//Cabbage
		if(Cabbage_amount == 0) {
			gc.drawImage(RenderableHolder.crate_cabbage_empty_Image, 543, 20, 53, 48);
		} else {
			gc.drawImage(RenderableHolder.crate_cabbage_Image, 543, 20, 53, 48);	
		}
		
		if(0 <= Cabbage_amount && Cabbage_amount <= 9) {
			gc.setFill(Color.LIME);
			if (Cabbage_amount == 0) {
				gc.setFill(Color.RED);
			}
			gc.setFont(new Font(45));
			gc.fillText(Integer.toString(Cabbage_amount), 615, 61);
		} else if (10 <= Cabbage_amount && Cabbage_amount <= 99) {
			gc.setFill(Color.LIME);
			gc.setFont(new Font(35));
			gc.fillText(Integer.toString(Cabbage_amount), 609, 58);
		}
		
		//Fish
		if(Fish_amount == 0) {
			gc.drawImage(RenderableHolder.crate_fish_empty_Image, 675, 20, 53, 48);
		} else {
			gc.drawImage(RenderableHolder.crate_fish_Image, 675, 20, 53, 48);
		}
		
		if(0 <= Fish_amount && Fish_amount <= 9) {
			gc.setFill(Color.LIGHTBLUE);
			if (Fish_amount == 0) {
				gc.setFill(Color.RED);
			}
			gc.setFont(new Font(45));
			gc.fillText(Integer.toString(Fish_amount), 747, 61);
		} else if (10 <= Fish_amount && Fish_amount <= 99) {
			gc.setFill(Color.LIGHTBLUE);
			gc.setFont(new Font(35));
			gc.fillText(Integer.toString(Fish_amount), 741, 58);
		}		
	}

}
