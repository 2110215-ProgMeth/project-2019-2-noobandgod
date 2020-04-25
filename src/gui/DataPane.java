package gui;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

public class DataPane extends HBox{
	private IngredientStoragePane ingredientStoragePane;
	private ScoreMoneyBox scoreMoneyBox;
	
	public DataPane() {
		super();
		this.setPadding(new Insets(8));
		this.setMaxHeight(100);
		this.setMaxWidth(500);
		
		VBox timerBox = new VBox();
		timerBox.setAlignment(Pos.CENTER);
			Label timeLabel = new Label("Time");
			timeLabel.setFont(new Font(16));
		
		timerBox.getChildren().addAll(timeLabel);
		
		
		
		
		this.scoreMoneyBox = new ScoreMoneyBox();
		
		VBox box = new VBox();
		Label storageLabel = new Label("Your Storage");
		this.ingredientStoragePane = new IngredientStoragePane(new String[]{"Tomato","Cabbage","Fish"});
		
		box.getChildren().addAll(storageLabel,ingredientStoragePane);
		
		
		
		this.getChildren().addAll(timerBox,scoreMoneyBox,box);
	}

	public ScoreMoneyBox getScoreMoneyBox() {
		return scoreMoneyBox;
	}
	
	
	
}
