package screen;

import application.Main;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class StartScreen extends VBox{

		private Label title;
		private Button playButton;
		private Button tutorialButton;
		private Button quitButton;
		
	public StartScreen() {
		this.setPrefHeight(500);
		this.setPrefWidth(700);
		this.setBorder(new Border(new BorderStroke(Color.LIGHTGRAY, BorderStrokeStyle.SOLID, 
					CornerRadii.EMPTY, BorderWidths.DEFAULT)));
		this.setAlignment(Pos.CENTER);
		this.setFillWidth(true);
		this.setSpacing(30);
			
		title = new Label();
		title.setFont(new Font(50));
		title.textProperty().setValue("Umm!! Aroi");
			
			
		playButton = new Button("Play");
		playButton.setPrefWidth(100);
		playButton.setPrefHeight(50);
		playButton.setFont(new Font(20));
		playButton.setOnAction( e -> {
//				SimulationManager.playHandler();
		
		});
		tutorialButton = new Button("Tutorial");
		tutorialButton.setPrefWidth(100);
		tutorialButton.setPrefHeight(50);
		tutorialButton.setFont(new Font(20));
		tutorialButton.setOnAction( e -> {
//		SimulationManager.tutorialHandler();
			
		});
		quitButton = new Button("Quit");
		quitButton.setPrefWidth(100);
		quitButton.setPrefHeight(50);
		quitButton.setFont(new Font(20));
		quitButton.setOnAction( e -> {
//		SimulationManager.quitHandler();
			System.exit(1);
		});
		
		this.getChildren().addAll(title,playButton,tutorialButton,quitButton);
		}
	}