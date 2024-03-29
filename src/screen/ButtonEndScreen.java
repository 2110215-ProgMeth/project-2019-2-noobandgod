package screen;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import sharedObject.AudioLoader;

public class ButtonEndScreen extends HBox{
	public Button quitButton;
	public ButtonEndScreen() {
		setSpacing(100);
		setPrefWidth(700);
		setPrefHeight(150);
		setAlignment(Pos.BOTTOM_CENTER);
		setPadding(new Insets(75));
		
		quitButton = new Button("Quit");		
		quitButton.setPrefSize(300, 75);
		quitButton.setFont(new Font(30));
        quitButton.setBackground(new Background(new BackgroundFill(Color.LIGHTBLUE, CornerRadii.EMPTY, Insets.EMPTY)));
		setUpButton();
		getChildren().addAll(quitButton);
	}
	public void setUpExitButton() {
		quitButton.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				AudioLoader.BUTTON_CLICK.play();
				Platform.exit();
			}
		});
	}
	public void setUpButton() {
			quitButton.setOnMouseEntered(e ->{
				quitButton.setBackground(new Background(new BackgroundFill(Color.AQUA, CornerRadii.EMPTY, Insets.EMPTY)));
				quitButton.setEffect(new DropShadow());
			});
			quitButton.setOnMouseExited(e ->{
				quitButton.setBackground(new Background(new BackgroundFill(Color.LIGHTBLUE, CornerRadii.EMPTY, Insets.EMPTY)));
				quitButton.setEffect(null);
			});
		}
	}





