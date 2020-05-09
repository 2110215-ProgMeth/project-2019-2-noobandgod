package screen;

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
		canvas = new Canvas(900, 800);
		gc = canvas.getGraphicsContext2D();
		menu = new ButtonStartScreen();
		setupButton();

	}
	public void draw(GraphicsContext gc) {
		root = new StackPane();
		root.setPrefSize(900, 800);
		root.getChildren().addAll(canvas,menu);
		
		Scene scene = new Scene(root);
		//canvas.requestFocus();
		primaryStage.setScene(scene);
		primaryStage.setTitle("Umm!! Aroiii");
		primaryStage.setResizable(false);
		MousePressed();


	}
	public void setBackground() {
		gc.drawImage(background, 0, 0,900,800);
		gc.setFill(Color.BLACK);
		gc.setLineWidth(5);
		gc.setFont(new Font(50));
//		gc.strokeRect(600, 275, 300, 75);
//		gc.strokeRect(600, 450, 300, 75);
		//gc.rotate(340);
		gc.fillText("Umm!! Aroiii",530,225);
		draw(gc);
		//AudioLoader.END.play();
		}
	public void setupButton() {
		
		menu.playButton.setOnAction(new EventHandler<ActionEvent>() {
				
		@Override
		public void handle(ActionEvent event) {
//			GameScreen gameScreen = new GameScreen(primaryStage);
//			GameController.getCurrentGameMap().printMap();
			root.getChildren().removeAll(menu);
			EndScreen endscreen = new EndScreen(primaryStage,gc);
			}
		});
			menu.setupExitButton();
		setBackground();
	}
	public void MousePressed() {
		menu.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent arg0) {
				AudioLoader.BUTTON_CLICK.play();
				AudioLoader.END.play();
				menu.playButton.setBackground(new Background(new BackgroundFill(Color.GREENYELLOW, CornerRadii.EMPTY, Insets.EMPTY)));
				menu.quitButton.setBackground(new Background(new BackgroundFill(Color.GREENYELLOW, CornerRadii.EMPTY, Insets.EMPTY)));
			}
	});
}
}