package gui;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

//for creating text in menu bar
public class Menu extends VBox{
	private Label title;
	private Button playButton;
	private Button tutorialButton;
	private Button quitButton;

//	public Rectangle playButton = new Rectangle(Game.WIDTH/2+120,150,100,50);
//	public Rectangle tutorialButton = new Rectangle(Game.WIDTH/2+120,150,100,50);
//	public Rectangle quitButtin = new Rectangle(Game.WIDTH/2+120,150,100,50);
	
	public Menu() {
		super(100);
		this.setPrefWidth(700);
		this.setBorder(new Border(new BorderStroke(Color.LIGHTGRAY, BorderStrokeStyle.SOLID, 
				CornerRadii.EMPTY, BorderWidths.DEFAULT)));
		this.setAlignment(Pos.CENTER);
		this.setFillWidth(true);
		
		title = new Label();
		title.setFont(new Font(50));
		title.textProperty().setValue("Umm!! Aroi");
		
		
		playButton = new Button("Play");
		playButton.setPrefWidth(150);
		playButton.setPrefHeight(75);
		playButton.setFont(new Font(20));
		playButton.setOnAction( e -> {
			SimulationManager.playHandler();
		
		});
		tutorialButton = new Button("Tutorial");
		tutorialButton.setPrefWidth(150);
		tutorialButton.setPrefHeight(75);
		tutorialButton.setFont(new Font(20));
		tutorialButton.setOnAction( e -> {
			SimulationManager.tutorialHandler();
		
		});
		quitButton = new Button("Play");
		quitButton.setPrefWidth(150);
		quitButton.setPrefHeight(75);
		quitButton.setFont(new Font(20));
		quitButton.setOnAction( e -> {
			SimulationManager.quitHandler();
		
		});
		this.getChildren().addAll(title,playButton,tutorialButton,quitButton);
	}
//		Graphics2D g2d = (Graphics2D) g;
//		Font fnt0 = new Font("Um!! Aroi",50);
//		
//		this.setBorder(new Border(new BorderStroke(Color.LIGHTGRAY, BorderStrokeStyle.SOLID, 
//				CornerRadii.EMPTY, BorderWidths.DEFAULT)));
//		
//		g.setColor(Color.WHITE);
//		g.drawString("Umm!! Aroi", game.WIDTH, 100);
//		
//		Font fnt1 = new Font("aerial",Font.BOLD, 30);
//		g.setFont(fnt1);
//		g.setColor(Color.white);
//		g.drawString("Play", playButton.x, playButton.y);
//		g2d.draw(playButton);
//		
//		g.drawString("Tutorial", playButton.x, playButton.y);
//		g2d.draw(tutorialButton);
//		
//		g.setFont(fnt1);
//		g.setColor(Color.white);
//		g.drawString("Quit", playButton.x, playButton.y);
//		g2d.draw(quitButtin);
//		
//		
//	}
}
