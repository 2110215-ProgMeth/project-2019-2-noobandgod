package screen;


import java.io.File;
import java.net.URL;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.StackPane;
import javafx.scene.media.AudioClip;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import logic.ButtonStartScreen;

import logic.GameController;
import screen.GameScreen;
import sharedObject.AudioLoader;
public class StartScreen{
		private String image_path = ClassLoader.getSystemResource("picture/Background.png").toString();
		private Image background = new Image(image_path);		
		private Stage primaryStage;
		private Canvas canvas;
		private GraphicsContext gc;
		public static StackPane root;
		public static StackPane getRoot() {
			return root;
		}
		private ButtonStartScreen menu;
		
	public StartScreen(Stage primaryStage) {
		this.primaryStage = primaryStage;
		canvas = new Canvas(1000, 800);
		gc = canvas.getGraphicsContext2D();
		menu = new ButtonStartScreen();
		setupButton();

        
    }

	public void draw(GraphicsContext gc) {
		root = new StackPane();
		root.setPrefSize(1000, 800);
		root.getChildren().addAll(canvas,menu);
		
		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Umm!! Aroiii");
		primaryStage.setResizable(false);
		AudioLoader.Start_Screen.play();
		//AudioLoader.Start_Screen.setVolume(0.01);


	}
	public void setBackground() {
		gc.drawImage(background, 0, 0,900,800);
		gc.setFill(Color.BLACK);
		draw(gc);
		
	}
	public void setupButton() {
		
		menu.playButton.setOnAction(new EventHandler<ActionEvent>() {
		@Override
		public void handle(ActionEvent event) {
//			GameScreen gameScreen = new GameScreen(primaryStage);
//			GameController.getCurrentGameMap().printMap();
			AudioLoader.BUTTON_CLICK.play();
			menu.setPlayerButton();
			}
		});
		menu.p1Button.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
//				GameScreen gameScreen = new GameScreen(primaryStage);
//				GameController.getCurrentGameMap().printMap();
				AudioLoader.BUTTON_CLICK.play();
				AudioLoader.Start_Screen.stop();
				root.getChildren().removeAll(menu);
				EndScreen endscreen = new EndScreen(primaryStage,gc);
				}
			});
		menu.p2Button.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
//				GameScreen gameScreen = new GameScreen(primaryStage);
//				GameController.getCurrentGameMap().printMap();
				AudioLoader.BUTTON_CLICK.play();
				AudioLoader.Start_Screen.stop();
				root.getChildren().removeAll(menu);
				EndScreen endscreen = new EndScreen(primaryStage,gc);
				}
			});
		menu.setupExitButton();
		setBackground();
	}
}