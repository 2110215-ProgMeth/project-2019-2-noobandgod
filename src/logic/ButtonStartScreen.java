package logic;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import sharedObject.AudioLoader;

public class ButtonStartScreen extends VBox {
	// private static final Font mainFont =
	// Font.loadFont(ClassLoader.getSystemResourceAsStream("supermarket.ttf"), 24);
	public Button playButton;
	public Button quitButton;
	public Button p1Button;
	public Button p2Button;

	public ButtonStartScreen() {
		setSpacing(100);
		setPrefWidth(700);
		setPrefHeight(150);
		setAlignment(Pos.CENTER_RIGHT);

		playButton = new Button("Play");
		playButton.setPrefSize(300, 75);
		playButton.setFont(new Font(30));

		quitButton = new Button("Quit");
		quitButton.setPrefSize(300, 75);
		quitButton.setFont(new Font(30));

		p1Button = new Button("1 Player");
		p1Button.setPrefSize(300, 75);
		p1Button.setFont(new Font(30));

		p2Button = new Button("2 Player");
		p2Button.setPrefSize(300, 75);
		p2Button.setFont(new Font(30));
		
		playButton.setStyle("-fx-text-fill: #ffffff");
		quitButton.setStyle("-fx-text-fill: #ffffff");
		p1Button.setStyle("-fx-text-fill: #ffffff");
		p2Button.setStyle("-fx-text-fill: #ffffff");
		
		playButton.setBackground(new Background(new BackgroundFill(Color.GREEN, CornerRadii.EMPTY, Insets.EMPTY)));
		quitButton.setBackground(new Background(new BackgroundFill(Color.GREEN, CornerRadii.EMPTY, Insets.EMPTY)));
		p1Button.setBackground(new Background(new BackgroundFill(Color.GREEN, CornerRadii.EMPTY, Insets.EMPTY)));
		p2Button.setBackground(new Background(new BackgroundFill(Color.GREEN, CornerRadii.EMPTY, Insets.EMPTY)));

		setUpButton();
		getChildren().addAll(playButton, quitButton);
	}

	public void setupExitButton() {
		quitButton.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
//				AudioLoader.BUTTON_CLICK.play();
				Platform.exit();
			}
		});
	}

	public void setUpButton() {
		playButton.setOnMouseEntered(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent arg0) {
				playButton.setBackground(
						new Background(new BackgroundFill(Color.LIMEGREEN, CornerRadii.EMPTY, Insets.EMPTY)));
			}
		});
		playButton.setOnMouseExited(new EventHandler<MouseEvent>() {
			public void handle(MouseEvent arg0) {
				playButton.setBackground(
						new Background(new BackgroundFill(Color.GREEN, CornerRadii.EMPTY, Insets.EMPTY)));
			}
		});
		quitButton.setOnMouseEntered(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent arg0) {
				quitButton.setBackground(
						new Background(new BackgroundFill(Color.LIMEGREEN, CornerRadii.EMPTY, Insets.EMPTY)));
			}
		});
		quitButton.setOnMouseExited(new EventHandler<MouseEvent>() {
			public void handle(MouseEvent arg0) {
				quitButton.setBackground(
						new Background(new BackgroundFill(Color.GREEN, CornerRadii.EMPTY, Insets.EMPTY)));
			}
		});
	}

	public void setPlayerButton() {
		this.getChildren().clear();
		p1Button.setOnMouseEntered(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent arg0) {
				p1Button.setBackground(
						new Background(new BackgroundFill(Color.LIMEGREEN, CornerRadii.EMPTY, Insets.EMPTY)));
			}
		});
		p1Button.setOnMouseExited(new EventHandler<MouseEvent>() {
			public void handle(MouseEvent arg0) {
				p1Button.setBackground(
						new Background(new BackgroundFill(Color.GREEN, CornerRadii.EMPTY, Insets.EMPTY)));
			}
		});

		p2Button.setOnMouseEntered(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent arg0) {
				p2Button.setBackground(
						new Background(new BackgroundFill(Color.LIMEGREEN, CornerRadii.EMPTY, Insets.EMPTY)));
			}
		});
		p2Button.setOnMouseExited(new EventHandler<MouseEvent>() {
			public void handle(MouseEvent arg0) {
				p2Button.setBackground(
						new Background(new BackgroundFill(Color.GREEN, CornerRadii.EMPTY, Insets.EMPTY)));
			}
		});
		this.getChildren().addAll(p1Button,p2Button,quitButton);
	}
}
