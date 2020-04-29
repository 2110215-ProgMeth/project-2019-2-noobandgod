package application;

import gui.IngredientStoragePane;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import screen.StartScreen;

public class Main2 extends Application {
	private static String image_path = ClassLoader.getSystemResource("picture/Background.png").toString();
	private static Image background = new Image(image_path);		
	
	@Override
	public void start(Stage primaryStage) {
		
		StackPane root = new StackPane();
		StartScreen start = new StartScreen();
		Canvas canvas = new Canvas(900, 800);
		GraphicsContext gc = canvas.getGraphicsContext2D();
		drawPicture(gc);
		root.getChildren().addAll(canvas,start);
		
		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Umm!! Aroiii");
		primaryStage.show();
	}

	private void drawPicture(GraphicsContext gc) {
		// TODO Auto-generated method stub		
		gc.drawImage(background, 0, 0,900,800);
		
	}

	public static void main(String[] args) {
		launch(args);
	}

	}

