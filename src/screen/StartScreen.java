package screen;

import application.Main;
import javafx.animation.AnimationTimer;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import logic.Buttons;
import logic.GameController;
import screen.GameScreen;
public class StartScreen{
		private static String image_path = ClassLoader.getSystemResource("picture/Background.png").toString();
		private static Image background = new Image(image_path);		
		private Label title;
		private Stage primaryStage;
		private Canvas canvas;
		private GraphicsContext gc;

		public Buttons menu;
		
	public StartScreen(Stage primaryStage) {
		this.primaryStage = primaryStage;
		canvas = new Canvas(900, 800);
		gc = canvas.getGraphicsContext2D();
		menu = new Buttons();
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

//		startscreenAnimation = new AnimationTimer() {
//	@Override
//			public void handle(long now) {
//				setBackground();
//					if(!isSoundOn) gameSound.play();
//						if(timer == 30) {
//							root.getChildren().add(menu);
//					}
//					timer++;
//				}
//			};
//			startscreenAnimation.start();
	}
	public void setBackground() {
//		GraphicsContext gc = canvas.getGraphicsContext2D();
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
			//buttonSound.play();
//			GameScreen gameScreen = new GameScreen(primaryStage);
//			GameController.getCurrentGameMap().printMap();
		//	game.draw();
		//startscreenAnimation.stop();
			}
		});
			menu.setupExitButton();
	}
//	public void startanimation() {
//			draw(gc);
//		}
//	}

//		this.setPrefHeight(500);
//		this.setPrefWidth(700);
//		this.setBorder(new Border(new BorderStroke(Color.LIGHTGRAY, BorderStrokeStyle.SOLID, 
//					CornerRadii.EMPTY, BorderWidths.DEFAULT)));
//		this.setAlignment(Pos.CENTER_RIGHT);
//		this.setFillWidth(true);
//		this.setSpacing(50);
//		
//
//		title = new Label();
//		title.setFont(new Font(70));
//		title.textProperty().setValue("Umm!! Aroiii");
//		title.setBackground(new Background(new BackgroundFill(Color.YELLOW, CornerRadii.EMPTY, Insets.EMPTY)));;
//			
//
//		playButton = new Button("Play");
//		playButton.setPrefWidth(300);
//		playButton.setPrefHeight(50);
//		playButton.setBackground(new Background(new BackgroundFill(Color.LIMEGREEN, CornerRadii.EMPTY, Insets.EMPTY)));
//		playButton.setFont(new Font(30));
//		playButton.setOnAction( e -> {
////				SimulationManager.playHandler();
//			System.out.print("Something went wrong");
//			setStartPressed(true);
//			System.out.print(isGameStart());
//		});
//		tutorialButton = new Button("Tutorial");
//		tutorialButton.setPrefWidth(300);
//		tutorialButton.setPrefHeight(50);
//		tutorialButton.setBackground(new Background(new BackgroundFill(Color.LIMEGREEN, CornerRadii.EMPTY, Insets.EMPTY)));
//		tutorialButton.setFont(new Font(30));
//		tutorialButton.setOnAction( e -> {
////		SimulationManager.tutorialHandler();
//			
//		});
//		quitButton = new Button("Quit");
//		quitButton.setPrefWidth(300);
//		quitButton.setPrefHeight(50);
//		quitButton.setFont(new Font(30));
//		quitButton.setBackground(new Background(new BackgroundFill(Color.LIMEGREEN, CornerRadii.EMPTY, Insets.EMPTY)));
//		quitButton.setOnAction( e -> {
////		SimulationManager.quitHandler();
//			System.exit(1);
//		});
//		
//		this.getChildren().addAll(title,playButton,tutorialButton,quitButton);
//		}


}