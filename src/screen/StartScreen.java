package screen;

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
import javafx.stage.Stage;
import logic.Buttons;
import logic.GameController;
import screen.GameScreen;
public class StartScreen{
		private static String image_path = ClassLoader.getSystemResource("picture/Background.png").toString();
		private static Image background = new Image(image_path);		
		private Stage primaryStage;
		private Canvas canvas;
		private GraphicsContext gc;

		public Buttons menu;
		
	public StartScreen(Stage primaryStage) {
		this.primaryStage = primaryStage;
		canvas = new Canvas(900, 800);
		gc = canvas.getGraphicsContext2D();
		menu = new Buttons();
		MousePressed();
		setupButton();
		draw(gc);
		setBackground();

	}
	public void draw(GraphicsContext gc) {
		StackPane root = new StackPane();
		root.setPrefSize(900, 800);
		root.getChildren().addAll(canvas,menu);
		
		Scene scene = new Scene(root);
		//canvas.requestFocus();
		primaryStage.setScene(scene);
		primaryStage.setTitle("Umm!! Aroiii");
		primaryStage.setResizable(false);


	}
	public void setBackground() {
		gc.drawImage(background, 0, 0,900,800);
		gc.setFill(Color.BLUE);
		gc.setLineWidth(5);
		gc.setFont(new Font(50));
		gc.fillText("Umm!! Aroiii", 450, 230);
		}
	public void setupButton() {

		menu.playButton.setOnAction(new EventHandler<ActionEvent>() {
				
		@Override
		public void handle(ActionEvent event) {
			GameScreen gameScreen = new GameScreen(primaryStage);
			GameController.getCurrentGameMap().printMap();
			
			}
		});
			menu.setupExitButton();
	}
	public void MousePressed() {
		menu.setOnMouseMoved(e ->{
	
//			public void handle(ActionEvent event) {
			menu.playButton.setBackground(new Background(new BackgroundFill(Color.GREENYELLOW, CornerRadii.EMPTY, Insets.EMPTY)));
			menu.quitButton.setBackground(new Background(new BackgroundFill(Color.GREENYELLOW, CornerRadii.EMPTY, Insets.EMPTY)));
		});
	}
}