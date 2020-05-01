package screen;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class Buttons extends VBox{
	//private static final Font mainFont = Font.loadFont(ClassLoader.getSystemResourceAsStream("supermarket.ttf"), 24);
	public Button playButton;
	public Button quitButton;
	
	public Buttons() {
		setSpacing(100);
		setPrefWidth(700);
		setPrefHeight(150);
		setAlignment(Pos.CENTER_RIGHT);

		
		playButton = new Button("Play");
		playButton.setPrefSize(300,75);
		playButton.setFont(new Font(20));
		quitButton = new Button("Quit");		
		quitButton.setPrefSize(300, 75);
		quitButton.setFont(new Font(20));
		playButton.setStyle("-fx-background-color: #6495ed; -fx-text-fill: #ffffff;");
		quitButton.setStyle("-fx-background-color: #6495ed; -fx-text-fill: #ffffff;");
		getChildren().addAll(playButton, quitButton);
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


