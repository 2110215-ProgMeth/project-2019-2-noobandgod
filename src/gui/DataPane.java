package gui;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import logic.GameController;

public class DataPane extends HBox{
	private IngredientStoragePane ingredientStoragePane;
	private ScoreMoneyBox scoreMoneyBox;
	
	public DataPane() {
		super();
		this.setPadding(new Insets(8));
		this.setMaxHeight(100);
		this.setMaxWidth(640);
		
		VBox timerBox = new VBox();
		timerBox.setAlignment(Pos.CENTER);
			
		
		this.scoreMoneyBox = new ScoreMoneyBox();
		
		VBox box = new VBox();
		Label storageLabel = new Label("Your Storage");
		
		this.ingredientStoragePane = new IngredientStoragePane(GameController.INGREDIENTS);
		
		box.getChildren().addAll(storageLabel,ingredientStoragePane);
		
		
		
		this.getChildren().addAll(timerBox,scoreMoneyBox,box);
	}

	public ScoreMoneyBox getScoreMoneyBox() {
		return scoreMoneyBox;
	}

	public IngredientStoragePane getIngredientStoragePane() {
		return ingredientStoragePane;
	}
	
	
	
	
}
