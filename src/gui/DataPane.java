package gui;

import javafx.geometry.Insets;
import javafx.scene.layout.HBox;

public class DataPane extends HBox{
	
	public DataPane() {
		super();
		this.setPadding(new Insets(8));
		
		
		ScoreMoneyBox scoreMoneyBox = new ScoreMoneyBox();
		this.getChildren().addAll(scoreMoneyBox);
	}
	
}
