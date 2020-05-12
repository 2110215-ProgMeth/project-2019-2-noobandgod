package logic;

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
        restartButton.setBackground(new Background(new BackgroundFill(Color.LIGHTBLUE, CornerRadii.EMPTY, Insets.EMPTY)));
        quitButton.setBackground(new Background(new BackgroundFill(Color.LIGHTBLUE, CornerRadii.EMPTY, Insets.EMPTY)));
		setUpButton();
		getChildren().addAll(restartButton, quitButton);
	}
	public void setupExitButton() {
		quitButton.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				AudioLoader.BUTTON_CLICK.play();
				Platform.exit();
			}
		});
	}
	public void setUpButton() {
			restartButton.setOnMouseEntered(e ->{
				restartButton.setBackground(new Background(new BackgroundFill(Color.AQUA, CornerRadii.EMPTY, Insets.EMPTY)));
				restartButton.setEffect(new DropShadow());
			});
			restartButton.setOnMouseExited(e ->{
				restartButton.setBackground(new Background(new BackgroundFill(Color.LIGHTBLUE, CornerRadii.EMPTY, Insets.EMPTY)));
				restartButton.setEffect(null);
			});
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





