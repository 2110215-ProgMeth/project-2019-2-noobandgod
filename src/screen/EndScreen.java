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

public class EndScreen{
	private Stage primaryStage;
	private static String image_path = ClassLoader.getSystemResource("picture/bad.jpg").toString();
	private static Image gameOver = new Image(image_path);
	
	private static String image_path2 = ClassLoader.getSystemResource("picture/good.jpg").toString();
	private static Image good = new Image(image_path2);
	
	private static String image_path3= ClassLoader.getSystemResource("picture/VeryGood.jpg").toString();
	private static Image veryGood = new Image(image_path3);
	
	private static String image_path4 = ClassLoader.getSystemResource("picture/Excellent.jpg").toString();
	private static Image  excellent = new Image(image_path4);
	private static ButtonsEndScreen menu;
	
	public EndScreen(Stage primaryStage,GraphicsContext gc) {
		this.primaryStage = primaryStage;
		this.draw(gc);
		// TODO Auto-generated constructor stub
	}
	
	public void draw(GraphicsContext gc) {	
			
			GameController.setScoreCount(299);
			gc.setFill(Color.RED);
			gc.setStroke(Color.BLUE);
			gc.setLineWidth(2);
			Font theFont = Font.font("Times New Roman", FontWeight.LIGHT, 100);
			gc.setFont(theFont);
			int score = GameController.getScore_count();
			if (score < 100) {
				gc.drawImage(gameOver, 0, 0,900,800);
				gc.fillText("Bad!!", 350, 200);
				gc.strokeText("Bad!!", 350, 200);
			}else if (100 <= score&& score < 200) {
				gc.drawImage(good, 0, 0, 900, 800);
				gc.fillText("Good!", 350, 200);
				gc.strokeText("Good!!", 350, 200);
			}else if (200 <= score && score < 300) {
				gc.drawImage(veryGood, 0, 0, 900, 800);
				gc.fillText("Very Good!!", 250,200);
				gc.strokeText("Very Good!!", 250, 200);
			}else if (300 <= score) {
				gc.drawImage(excellent, 0, 0, 900, 800);
				gc.fillText("Excellent!!!", 250,200);
				gc.strokeText("Excellent!!!", 250, 200);
			}
			gc.setFill(Color.GREEN);
			gc.setStroke(Color.YELLOW);
			gc.fillText("SCORE : " + score, 200, 450);
			gc.strokeText("SCORE : " + score, 200, 450);
			menu = new ButtonsEndScreen();
			StartScreen.getRoot().getChildren().add(menu);
			setupButton();
		}
	
		public void setupButton() {

			menu.restartButton.setOnAction(new EventHandler<ActionEvent>() {
					
			@Override
			public void handle(ActionEvent event) {
//				GameScreen gameScreen = new GameScreen(primaryStage);
//				GameController.getCurrentGameMap().printMap();
				StartScreen start = new StartScreen(primaryStage);
				}
			});
				menu.setupExitButton();
				MousePressed();
		}
		public void MousePressed() {
			menu.setOnMouseMoved(e ->{
		
//				public void handle(ActionEvent event) {
				menu.restartButton.setBackground(new Background(new BackgroundFill(Color.GREENYELLOW, CornerRadii.EMPTY, Insets.EMPTY)));
				menu.quitButton.setBackground(new Background(new BackgroundFill(Color.GREENYELLOW, CornerRadii.EMPTY, Insets.EMPTY)));
			});
		}
}
