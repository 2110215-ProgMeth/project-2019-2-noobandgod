package screen;

import javafx.animation.AnimationTimer;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.StackPane;
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
	private Canvas canvas;
	private GraphicsContext gc;
	private static ButtonsEndScreen menu;
	private AnimationTimer endScreenSong;
	public static StackPane root;

	public EndScreen(Stage primaryStage) {
		this.primaryStage = primaryStage;
		canvas = new Canvas(1000,800);
		gc = canvas.getGraphicsContext2D();
		root = new StackPane();
		root.setPrefSize(1000, 800);
		root.getChildren().add(canvas);
		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Umm!! Aroiii");
		primaryStage.setResizable(false);
		this.draw(gc);

	}

	public void draw(GraphicsContext gc) {
		gc.setFill(Color.RED);
		gc.setStroke(Color.BLUE);
		gc.setLineWidth(2);
		gc.setFont(new Font(100));
		int score = GameController.getScore_count();
			if (score < 100) {
				gc.drawImage(RenderableHolder.endscreen_bg_bad_Image, 0, 0);
				gc.fillText("Bad!!", 400, 250);
				gc.strokeText("Bad!!", 400, 250);
			}else if (score >= 100 && score < 250) {
				gc.drawImage(RenderableHolder.endscreen_bg_good_Image, 0, 0);
				gc.drawImage(RenderableHolder.star_Image, 450, 50 , 100 ,100);
				gc.fillText("Good!!", 350, 250);
				gc.strokeText("Good!!", 350, 250);
			} else if (250 <= score && score < 400) {
				gc.drawImage(RenderableHolder.endscreen_bg_good_Image, 0, 0);
				gc.drawImage(RenderableHolder.star_Image, 375, 50 , 100 ,100);
				gc.drawImage(RenderableHolder.star_Image, 525, 50 , 100 ,100);
				gc.fillText("Very Good!!", 250, 250);
				gc.strokeText("Very Good!!", 250, 250);
			} else if (score >= 400) {
				gc.drawImage(RenderableHolder.endscreen_bg_good_Image, 0, 0);
				gc.drawImage(RenderableHolder.star_Image, 325, 50 , 100 ,100);
				gc.drawImage(RenderableHolder.star_Image, 450, 50 , 100 ,100);
				gc.drawImage(RenderableHolder.star_Image, 575, 50 , 100 ,100);
				gc.fillText("Excellent!!!", 275, 250);
				gc.strokeText("Excellent!!!", 275, 250);
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
		root.getChildren().add(menu);
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
		menu.setupExitButton();
	}

}
