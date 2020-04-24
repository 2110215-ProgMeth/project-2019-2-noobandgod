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

//	public Rectangle playButton = new Rectangle(Game.WIDTH/2+120,150,100,50);
//	public Rectangle tutorialButton = new Rectangle(Game.WIDTH/2+120,150,100,50);
//	public Rectangle quitButtin = new Rectangle(Game.WIDTH/2+120,150,100,50);
	
	public Menu() {
		super(15);
		this.setPrefWidth(100);
		this.setBorder(new Border(new BorderStroke(Color.LIGHTGRAY, BorderStrokeStyle.SOLID, 
				CornerRadii.EMPTY, BorderWidths.DEFAULT)));
		this.setAlignment(Pos.CENTER);
		this.setFillWidth(true);
		
		title = new Label();
		title.setFont(new Font(20));
		title.textProperty().setValue("Umm!! Aroi");
		
		Label label = new Label("Please select a seed or removal tool");
		label.setFont(new Font(14));
		
		harvestButton = new Button("Harvest");
		harvestButton.setPrefWidth(150);
		harvestButton.setOnAction( e -> {
			SimulationManager.harvestHandler();
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
