package screen;

import javafx.animation.AnimationTimer;
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
import sharedObject.RenderableHolder;

public class EndScreen {
	private Stage primaryStage;

	private static ButtonsEndScreen menu;
	private AnimationTimer endScreenSong;

	public EndScreen(Stage primaryStage, GraphicsContext gc) {
		this.primaryStage = primaryStage;
		this.draw(gc);

	}

	public void draw(GraphicsContext gc) {
		gc.setFill(Color.RED);
		gc.setStroke(Color.BLUE);
		gc.setLineWidth(2);
		gc.setFont(new Font(100));
		int score = GameController.getScore_count();
		if (score < 0) {
			gc.drawImage(RenderableHolder.endscreen_bg_bad_Image, 0, 0);
			gc.fillText("Bad!!", 400, 250);
			gc.strokeText("Bad!!", 400, 250);
		} else {
			gc.drawImage(RenderableHolder.endscreen_bg_good_Image,0, 0);
			if (score >= 0 && score < 100) {
				gc.fillText("Bad!!", 400, 250);
				gc.strokeText("Bad!!", 400, 250);
			} else if (100 <= score && score < 200) {
				gc.fillText("Good!!", 350, 250);
				gc.strokeText("Good!!", 350, 250);
			} else if (200 <= score && score < 300) {
				gc.fillText("Very Good!!", 250, 250);
				gc.strokeText("Very Good!!", 250, 250);
			} else if (score >= 300) {
				gc.fillText("Excellent!!!", 250, 250);
				gc.strokeText("Excellent!!!", 250, 250);
			}
		}
		gc.setFont(new Font(75));
		gc.setFill(Color.GREEN);
		gc.setStroke(Color.YELLOW);
		gc.fillText("SCORE : " + score, 300, 550);
		gc.strokeText("SCORE : " + score, 300, 550);

		gc.setFont(new Font(50));
		gc.setFill(Color.WHITE);
		gc.setStroke(Color.BLACK);

		gc.fillText("Orders delivered : ", 250, 350);
		gc.strokeText("Orders delivered : ", 250, 350);
		gc.fillText(Integer.toString(GameController.getSuccessDish()), 750, 350);
		gc.strokeText(Integer.toString(GameController.getSuccessDish()), 750, 350);

		gc.fillText("Orders failed : ", 250, 450);
		gc.strokeText("Orders failed : ", 250, 450);
		gc.fillText(Integer.toString(GameController.getFailedDish()), 750, 450);
		gc.strokeText(Integer.toString(GameController.getFailedDish()), 750, 450);

		menu = new ButtonsEndScreen();
		StartScreen.getRoot().getChildren().add(menu);
		endScreenSong = new AnimationTimer() {
			@Override
			public void handle(long now) {
				if (!AudioLoader.End_Screen.isPlaying())
					AudioLoader.End_Screen.play();
			}
		};
		endScreenSong.start();

		setupButton();
	}

	public void setupButton() {

		menu.restartButton.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				AudioLoader.BUTTON_CLICK.play();
				AudioLoader.End_Screen.stop();
				endScreenSong.stop();
				StartScreen start = new StartScreen(primaryStage);
			}
		});
		menu.setupExitButton();
	}

}
