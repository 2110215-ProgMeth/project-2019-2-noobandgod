package screen;

import javafx.animation.AnimationTimer;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
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
import sharedObject.RenderableHolder;
public class StartScreen{
		private String image_path = ClassLoader.getSystemResource("picture/Background.png").toString();
		private Image background = new Image(image_path);		
		private Stage primaryStage;
		private Canvas canvas;
		private GraphicsContext gc;
		public static StackPane root;
		
		private ButtonStartScreen menu;
		
		private AnimationTimer  startScreenSong;
		
		private int timer = 0;// time delay to show the menu
		
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
		root.getChildren().addAll(canvas);
		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Umm!! Aroiii");
		primaryStage.setResizable(false);
		startScreenSong = new AnimationTimer() {
			@Override
			public void handle(long now) {
				if(!AudioLoader.Start_Screen.isPlaying()) 
					AudioLoader.Start_Screen.play();
				if (timer == 50) {
					root.getChildren().addAll(menu);
				}timer++;
			}
		};
		startScreenSong.start();


	}
	public void setBackground() {
		gc.drawImage(RenderableHolder.startscreen_bg_Image, 0, 0,1000,800);
		gc.setFill(Color.BLACK);
		draw(gc);
		
	}
	public void setupButton() {
		
		menu.playButton.setOnAction(new EventHandler<ActionEvent>() {
		@Override
		public void handle(ActionEvent event) {
			AudioLoader.BUTTON_CLICK.play();
			menu.setPlayerButton();
			}
		});
		menu.p1Button.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				GameScreen gameScreen = new GameScreen(primaryStage,1);
				AudioLoader.BUTTON_CLICK.play();
				AudioLoader.Start_Screen.stop();
				startScreenSong.stop();
				}
			});
		menu.p2Button.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				GameScreen gameScreen = new GameScreen(primaryStage,2);
				AudioLoader.BUTTON_CLICK.play();
				AudioLoader.Start_Screen.stop();
				startScreenSong.stop();
				}
			});
		menu.setupExitButton();
		setBackground();
	}
	public static StackPane getRoot() {
		return root;
	}
}