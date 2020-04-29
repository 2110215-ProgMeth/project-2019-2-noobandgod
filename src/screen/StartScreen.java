package screen;

import application.Main;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import screen.GameScreen;
public class StartScreen extends VBox{

		private Label title;
		private Button playButton;
		private Button tutorialButton;
		private Button quitButton;
		private Stage stage;

	public StartScreen() {

		this.setPrefHeight(500);
		this.setPrefWidth(700);
		this.setBorder(new Border(new BorderStroke(Color.LIGHTGRAY, BorderStrokeStyle.SOLID, 
					CornerRadii.EMPTY, BorderWidths.DEFAULT)));
		this.setAlignment(Pos.CENTER_RIGHT);
		this.setFillWidth(true);
		this.setSpacing(50);
		

		title = new Label();
		title.setFont(new Font(70));
		title.textProperty().setValue("Umm!! Aroiii");
		title.setBackground(new Background(new BackgroundFill(Color.YELLOW, CornerRadii.EMPTY, Insets.EMPTY)));;
			

		playButton = new Button("Play");
		playButton.setPrefWidth(300);
		playButton.setPrefHeight(50);
		playButton.setBackground(new Background(new BackgroundFill(Color.LIMEGREEN, CornerRadii.EMPTY, Insets.EMPTY)));
		playButton.setFont(new Font(30));
		playButton.setOnAction( e -> {
//				SimulationManager.playHandler();
			System.out.print("Something went wrong");
			GameScreen gameScreen = new GameScreen(stage);
		});
		tutorialButton = new Button("Tutorial");
		tutorialButton.setPrefWidth(300);
		tutorialButton.setPrefHeight(50);
		tutorialButton.setBackground(new Background(new BackgroundFill(Color.LIMEGREEN, CornerRadii.EMPTY, Insets.EMPTY)));
		tutorialButton.setFont(new Font(30));
		tutorialButton.setOnAction( e -> {
//		SimulationManager.tutorialHandler();
			
		});
		quitButton = new Button("Quit");
		quitButton.setPrefWidth(300);
		quitButton.setPrefHeight(50);
		quitButton.setFont(new Font(30));
		quitButton.setBackground(new Background(new BackgroundFill(Color.LIMEGREEN, CornerRadii.EMPTY, Insets.EMPTY)));
		quitButton.setOnAction( e -> {
//		SimulationManager.quitHandler();
			System.exit(1);
		});
		
		this.getChildren().addAll(title,playButton,tutorialButton,quitButton);
		}
}