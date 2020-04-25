package gui;

import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class ScoreMoneyBox extends VBox{
	private Label scoreLabel;
	private Label moneyLabel;
	
	public ScoreMoneyBox() {
		this.setPrefSize(96, 96);
		
		
		VBox scoreBox = new VBox();
			Label scoretext = new Label("Score");
			this.scoreLabel = new Label("0");
			
			scoreBox.getChildren().addAll(scoretext,scoreLabel);
			
		VBox moneyBox = new VBox();
			Label moneytext = new Label("Money");
			this.moneyLabel = new Label("0");
			
			moneyBox.getChildren().addAll(moneytext,moneyLabel);
		
		this.getChildren().addAll(scoreBox,moneyBox);
		
	}
		
	
	
	
}
