package screen;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import logic.ButtonsEndScreen;
import logic.GameController;
import sharedObject.AudioLoader;

public class EndScreen{
	private Stage primaryStage;
	private static Image gameOver = new Image(ClassLoader.getSystemResource("picture/bad.jpg").toString());
	
	private static Image good = new Image(ClassLoader.getSystemResource("picture/good.jpg").toString());
	
	private static Image veryGood = new Image(ClassLoader.getSystemResource("picture/VeryGood.jpg").toString());
	
	private static Image  excellent = new Image(ClassLoader.getSystemResource("picture/Excellent.jpg").toString());
	private static ButtonsEndScreen menu;
	
	public EndScreen(Stage primaryStage,GraphicsContext gc) {
		this.primaryStage = primaryStage;
		this.draw(gc);
	}
	
	public void draw(GraphicsContext gc) {	
			
			GameController.setScoreCount(99);
			gc.setFill(Color.RED);
			gc.setStroke(Color.BLUE);
			gc.setLineWidth(2);
			int score = GameController.getScore_count();
			if (score < 100) {
				gc.drawImage(gameOver, 0, 0,1000,800);
				gc.fillText("Bad!!", 350, 200);
				gc.strokeText("Bad!!", 350, 200);
			}else if (100 <= score&& score < 200) {
				gc.drawImage(good, 0, 0, 1000, 800);
				gc.fillText("Good!", 350, 200);
				gc.strokeText("Good!!", 350, 200);
			}else if (200 <= score && score < 300) {
				gc.drawImage(veryGood, 0, 0, 1000, 800);
				gc.fillText("Very Good!!", 250,200);
				gc.strokeText("Very Good!!", 250, 200);
				gc.drawImage(excellent, 0, 0, 1000, 800);
				gc.fillText("Excellent!!!", 250,200);
				gc.strokeText("Excellent!!!", 250, 200);
			}
			gc.setFill(Color.GREEN);
			gc.setStroke(Color.YELLOW);
			gc.fillText("SCORE : " + score, 200, 450);
			gc.strokeText("SCORE : " + score, 200, 450);
			menu = new ButtonsEndScreen();
			StartScreen.getRoot().getChildren().add(menu);
			//AudioLoader.END_SONG.playSong();
			setupButton();
		}
	
		public void setupButton() {

			menu.restartButton.setOnAction(new EventHandler<ActionEvent>() {
					
			@Override
			public void handle(ActionEvent event) {
				//AudioLoader.BUTTON_CLICK.play();
				//AudioLoader.END_SONG.stopSong();
				StartScreen start = new StartScreen(primaryStage);
				}
			});
				menu.setupExitButton();
		}
		
}
