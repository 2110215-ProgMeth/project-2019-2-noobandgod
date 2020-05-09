package logic;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;

public class ButtonsEndScreen extends HBox{
	public Button restartButton;
	public Button quitButton;
	public ButtonsEndScreen() {
		setSpacing(100);
		setPrefWidth(700);
		setPrefHeight(150);
		setAlignment(Pos.BOTTOM_CENTER);
		setPadding(new Insets(100));
		
		restartButton = new Button("Restart");
		restartButton.setPrefSize(300,75);
		restartButton.setFont(new Font(30));
		quitButton = new Button("Quit");		
		quitButton.setPrefSize(300, 75);
		quitButton.setFont(new Font(30));
		getChildren().addAll(restartButton, quitButton);
	}
	public void setupExitButton() {
		quitButton.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				Platform.exit();
			}
		});
	}

}




