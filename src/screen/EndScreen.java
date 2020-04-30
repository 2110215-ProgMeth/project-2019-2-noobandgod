package screen;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import logic.GameController;

public class EndScreen {
	
	private static String image_path = ClassLoader.getSystemResource("picture/bad.jpg").toString();
	private static Image gameOver = new Image(image_path);
	
	private static String image_path2 = ClassLoader.getSystemResource("picture/good.jpg").toString();
	private static Image good = new Image(image_path2);
	
	private static String image_path3= ClassLoader.getSystemResource("picture/VeryGood.jpg").toString();
	private static Image veryGood = new Image(image_path3);
	
	private static String image_path4 = ClassLoader.getSystemResource("picture/Excellent.jpg").toString();
	private static Image  excellent = new Image(image_path4);
	
		public static void draw(GraphicsContext gc) {	
			
			GameController.setScoreCount(300);
			gc.setFill(Color.WHITE);
			gc.setLineWidth(2);
			int score = GameController.getScore_count();
			if (score < 100) {
				gc.drawImage(gameOver, 0, 0,900,800);
				gc.fillText("Bad!!", 350, 500);
			}else if (100 <= score&& score < 200) {
				gc.drawImage(good, 0, 0, 900, 800);
				gc.fillText("Good!", 350, 500);
			}else if (200 <= score && score < 300) {
				gc.drawImage(veryGood, 0, 0, 900, 800);
				gc.fillText("Very Good!!", 350,500);
			}else if (300 <= score) {
				gc.drawImage(excellent, 0, 0, 900, 800);
				gc.fillText("Excellent!!!", 350,500);
			}
			gc.setFont(new Font(50));
			gc.fillText("SCORE : " + score, 300, 450);
		}

	
}
