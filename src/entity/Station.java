package entity;

import entity.base.Block;
import entity.base.Entity;
import exception.HoldFailedException;
import exception.PlaceFailedException;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.WritableImage;
import logic.Sprites;
import screen.GameScreen;

public class Station extends Block {
	private Entity OnStationExists = null;
	protected boolean visible;
	
	private static Image station1 = new Image(ClassLoader.getSystemResource("picture/station1.png").toString());
	private static Image station2 = new Image(ClassLoader.getSystemResource("picture/station2.png").toString());
	
	public Station() {
		setOnStationExists(null);
		visible = true;
	}
	public boolean interacts(Player e) {
		
	}

	public Entity getOnStationExists() {
		return OnStationExists;
	}
	public void setOnStationExists(Entity onStationExists) {
		OnStationExists = onStationExists;
	}
	public char getSymbol() {
		return Sprites.Station;
	}
	
	public String toString() {
		String result = "STATION";
		result += "\nLocated at ("+this.getX()+","+this.getY()+")";
		result += "\nisAnyBlockDownward: "+isAnyBlockDownward;
		return result;
	}

	@Override
	public int getZ() {
		return getY()*3;
	}

	@Override
	public void draw(GraphicsContext gc) {
		int pixel = GameScreen.pixel;
		int x = GameScreen.draw_origin_x+this.getX()*pixel;
		int y = (GameScreen.draw_origin_y-6)+this.getY()*pixel;
		
		//System.out.println("Drawing Station at ("+getX()+","+getY()+")");
		
		if(!isAnyBlockDownward) {
			gc.drawImage(station1, x, y);
		} else {
			gc.drawImage(station2, x, y);
			
			//WritableImage station2 = new WritableImage(station1.getPixelReader(), 0, 0, 64, 58);
			//gc.drawImage(station2, x, y, 64, 72);
		}
		
	}

	@Override
	public boolean isVisible() {
		return visible;
	}

	
}
