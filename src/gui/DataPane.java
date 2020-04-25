package gui;

import javafx.geometry.Insets;
import javafx.scene.layout.HBox;

public class DataPane extends HBox{
	private ScoreMoneyBox scoreMoneyBox;
	
	public DataPane() {
		super();
		this.setPadding(new Insets(8));
		this.setMaxHeight(100);
		
		this.scoreMoneyBox = new ScoreMoneyBox();
		this.getChildren().addAll(scoreMoneyBox);
	}

	public ScoreMoneyBox getScoreMoneyBox() {
		return scoreMoneyBox;
	}
	
	
	
}
