package gui;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import logic.GameController;

public class ScoreMoneyBox extends VBox{
	private Label scoreLabel;
	private Label moneyLabel;
	
	public ScoreMoneyBox() {
		this.setPrefSize(96, 96);

		
		VBox scoreBox = new VBox();
			Label scoretext = new Label("Score");
			this.scoreLabel = new Label("0");
			
			scoreBox.setAlignment(Pos.CENTER);
			scoreBox.getChildren().addAll(scoretext,scoreLabel);
			
		VBox moneyBox = new VBox();
			Label moneytext = new Label("Money");
			this.moneyLabel = new Label();
			updateMoney();
			
			moneyBox.setAlignment(Pos.CENTER);
			moneyBox.getChildren().addAll(moneytext,moneyLabel);
		
		this.getChildren().addAll(scoreBox,moneyBox);
		
		
		String cssLayout = "-fx-border-color: purple;\n" +
                "-fx-border-insets: 2;\n" +
                "-fx-border-width: 1;\n" +
                "-fx-border-style: dashed;\n";
		this.setStyle(cssLayout);
		
	}
	
	public void updateMoney() {
		int money = GameController.getCoin_count();
		this.moneyLabel.setText(Integer.toString(money));
	}
		
	
	
	
}
