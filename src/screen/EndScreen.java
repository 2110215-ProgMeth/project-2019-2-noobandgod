package screen;

import javafx.animation.AnimationTimer;

import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
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
	private static final Font mainfont = Font.loadFont(ClassLoader.getSystemResourceAsStream("font/supermarket.ttf"), 100);
	private static final Font scorefont = Font.loadFont(ClassLoader.getSystemResourceAsStream("font/supermarket.ttf"), 50);
	private static final Font detailfont = Font.loadFont(ClassLoader.getSystemResourceAsStream("font/supermarket.ttf"), 40);
	private static int y = 230;
	
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
		gc.setLineWidth(2);
		gc.setFont(mainfont);
		int s = GameController.getScore_count();
		int bonus = GameController.getCoin_count()/10;
		int score = s+bonus;
		
			if (score < 100) {
				gc.drawImage(RenderableHolder.endscreen_bg_bad_Image, 0, 0);
				
				gc.setFill(Color.RED);
				gc.setStroke(Color.DARKRED);
				gc.fillText("Bad!!", 420, y);
				gc.strokeText("Bad!!", 420, y);
			
			}else if (score >= 100 && score < 250) {
				gc.drawImage(RenderableHolder.endscreen_bg_good_Image, 0, 0);
				gc.drawImage(RenderableHolder.star_Image, 450, 50 , 100 ,100);
				
				gc.setFill(Color.BLUE);
				gc.setStroke(Color.DARKBLUE);
				gc.fillText("Good!!", 370, y);
				gc.strokeText("Good!!", 370, y);
				
			} else if (250 <= score && score < 400) {
				gc.drawImage(RenderableHolder.endscreen_bg_good_Image, 0, 0);
				gc.drawImage(RenderableHolder.star_Image, 375, 50 , 100 ,100);
				gc.drawImage(RenderableHolder.star_Image, 525, 50 , 100 ,100);
				
				gc.setFill(Color.BLUE);
				gc.setStroke(Color.DARKBLUE);
				gc.fillText("Very Good!!", 280, y);
				gc.strokeText("Very Good!!", 280, y);
			
			} else if (score >= 400) {
				gc.drawImage(RenderableHolder.endscreen_bg_good_Image, 0, 0);
				gc.drawImage(RenderableHolder.star_Image, 325, 50 , 100 ,100);
				gc.drawImage(RenderableHolder.star_Image, 450, 50 , 100 ,100);
				gc.drawImage(RenderableHolder.star_Image, 575, 50 , 100 ,100);
				
				gc.setFill(Color.GOLD);
				gc.setStroke(Color.YELLOW);
				gc.fillText("Excellent!!!", 290, y);
				gc.strokeText("Excellent!!!", 290, y);
			}
			
		gc.setFont(detailfont);
		gc.setLineWidth(1);
		
		gc.setFill(Color.DARKGREEN);
		gc.fillText("Orders delivered : ", 250, y+90);
		
		if (0 <= GameController.getSuccessDish() && GameController.getSuccessDish() <= 9) {
			gc.fillText(Integer.toString(GameController.getSuccessDish()), 750, y+90);
		} else if (10 <= GameController.getSuccessDish() && GameController.getSuccessDish() <= 99) {
			gc.fillText(Integer.toString(GameController.getSuccessDish()), 734, y+90);
		}
		
		gc.setFill(Color.RED);
		gc.fillText("Orders failed : ", 250, y+140);;
		
		if (0 <= GameController.getFailedDish() && GameController.getFailedDish() <= 9) {
			gc.fillText(Integer.toString(GameController.getFailedDish()), 750, y+140);
		} else if (10 <= GameController.getFailedDish() && GameController.getFailedDish() <= 99) {
			gc.fillText(Integer.toString(GameController.getFailedDish()), 734, y+140);
		}
		
		drawLine(gc);
		drawScoreandBonus(gc, s, bonus);
		
		menu = new ButtonsEndScreen();
		root.getChildren().add(menu);
		
		if (GameController.getScore_count() <= 100) {
			endScreenSong = new AnimationTimer() {
				public void handle(long now) {
					if (!AudioLoader.End_Screen.isPlaying()) {
						AudioLoader.End_Screen.play();
					}
				}
			};endScreenSong.start();
		}else {
			endScreenSong = new AnimationTimer() {
				@Override
				public void handle(long now) {
					if (!AudioLoader.End_Screen2.isPlaying())
						AudioLoader.End_Screen2.play();
				}
			};
			endScreenSong.start();
		}

		setupButton();
	}

	public void setupButton() {
		menu.setupExitButton();
	}
	
	public void drawLine(GraphicsContext gc) {
		gc.beginPath();
		gc.moveTo(245, y+170);
		gc.lineTo(770, y+170);
		gc.setStroke(Color.BLACK);
		gc.setLineWidth(3);
		gc.stroke();
		
		gc.beginPath();
		gc.moveTo(245, y+300);
		gc.lineTo(770, y+300);
		gc.setStroke(Color.BLACK);
		gc.setLineWidth(3);
		gc.stroke();
		
		gc.beginPath();
		gc.moveTo(245, y+370);
		gc.lineTo(770, y+370);
		gc.setStroke(Color.BLACK);
		gc.setLineWidth(3);
		gc.stroke();
		
		gc.beginPath();
		gc.moveTo(245, y+375);
		gc.lineTo(770, y+375);
		gc.setStroke(Color.BLACK);
		gc.setLineWidth(3);
		gc.stroke();
	}
	
	public void drawScoreandBonus(GraphicsContext gc,int s,int bonus) {		
		gc.setFill(Color.BLACK);
		gc.fillText("Score : ", 250, y+220);
		int digit1 = Integer.toString(s).length();
		gc.fillText(Integer.toString(s), 750-16*(digit1-1), y+220);
		
		//-----------------------------------------------------------
		
		gc.setFill(Color.BLUE);
		gc.fillText("Money Bonus : ", 250, y+270);
		int digit2 = Integer.toString(bonus).length();
		gc.fillText("+"+Integer.toString(bonus), 750-16*(digit2), y+270);
		
		//-----------------------------------------------------------

		gc.setFont(scorefont);
		gc.setLineWidth(1);
		gc.setFill(Color.BLACK);
		gc.setStroke(Color.GOLD);
		gc.fillText("TOTAL SCORE : ", 250, y+350);
		gc.strokeText("TOTAL SCORE : ", 250, y+350);
		
		int score = s + bonus;
		int digit3 = Integer.toString(score).length();
		
		gc.setFill(Color.BLACK);
		gc.fillText(Integer.toString(score), 750-20*(digit3-1), y+350);
		
	}

}
