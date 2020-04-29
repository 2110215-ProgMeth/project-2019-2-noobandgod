package application;

import gui.IngredientStoragePane;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import screen.StartScreen;

public class Main2 extends Application {

	@Override
	public void start(Stage primaryStage) {
		StartScreen start = new StartScreen();
		
		StackPane root = new StackPane();
		Scene scene1 = new Scene(root);
		primaryStage.setScene(scene1);
		primaryStage.setTitle("Umm!! Aroiii");

		Canvas canvas = new Canvas(900, 800);
		GraphicsContext gc = canvas.getGraphicsContext2D();
		root.getChildren().addAll(canvas,start);

		drawPicture(gc);
		
		primaryStage.show();
	}

	private void drawPicture(GraphicsContext gc) {
		// TODO Auto-generated method stub
		Image image = new Image("file:res/e545209d8362ca017d39fb1807735bb0.png");		
		//ImageView imageView = new ImageView(image);
		gc.drawImage(image, 0, 0,900,800);
		
	}
	public static void main(String[] args) {
		launch(args);
	}

	}

