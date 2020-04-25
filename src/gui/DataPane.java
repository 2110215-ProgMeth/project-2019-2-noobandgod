package gui;

import javafx.geometry.Insets;
import javafx.scene.layout.HBox;

public class DataPane extends HBox{
	private IngredientStoragePane ingredientStoragePane;
	private ScoreMoneyBox scoreMoneyBox;
	
	public DataPane() {
		super();
		this.setPadding(new Insets(8));
		this.setMaxHeight(100);
		
		this.ingredientStoragePane = new IngredientStoragePane(new String[]{"Tomato","Cabbage","Fish"});
		
		this.scoreMoneyBox = new ScoreMoneyBox();
		
		
		this.getChildren().addAll(scoreMoneyBox,ingredientStoragePane);
	}

	public ScoreMoneyBox getScoreMoneyBox() {
		return scoreMoneyBox;
	}
	
	
	
}
