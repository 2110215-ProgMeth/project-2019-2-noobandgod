package sharedObject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import entity.base.Updatable;
import javafx.scene.image.Image;

public class RenderableHolder {
	private ArrayList<IRenderable> entities;
	private Comparator<IRenderable> comparator;
	private static final RenderableHolder instance = new RenderableHolder();
	
	//Images
	//Player
	public static Image player_walk_left_Image;
	public static Image player_walk_right_Image;
	public static Image player_walk_up_Image;
	public static Image player_walk_down_Image;
	
	public static Image player_still_left_Image;
	public static Image player_still_right_Image;
	public static Image player_still_up_Image;
	public static Image player_still_down_Image;
	
	//Bin
	public static Image bin_infront_Image;
	public static Image bin_between_Image;
	
	//Station
	public static Image station_infront_Image;
	public static Image station_between_Image;
	
	//CabbageStorage
	public static Image cabbagestorage_infront_Image;
	public static Image cabbagestorage_between_Image;
	
	//Dish
	public static Image dish_ontable_empty;
	
	
	static {
		loadResource();
	}
	
	public RenderableHolder() {
		entities = new ArrayList<IRenderable>();
		comparator = (IRenderable o1, IRenderable o2) -> {
			if (o1.getZ() > o2.getZ()) {
				return 1;
			}
		return -1;
		};
	}
	
	public void add(IRenderable entity) {
		entities.add(entity);
		
		System.out.println("Suscessfully added "+entity.toString()+"\nto entites....");
		
		Collections.sort(entities, comparator);
	}
	
	public void update() {
		Collections.sort(entities, comparator);
		for (int i = entities.size() - 1; i >= 0; i--) {
			if (!entities.get(i).isVisible())
				entities.remove(i);
				//continue;
			if (entities.get(i) instanceof Updatable) {
				((Updatable) entities.get(i)).update();
			}
		}
	}
	
	public static RenderableHolder getInstance() {
		return instance;
	}

	public ArrayList<IRenderable> getEntities() {
		return entities;
	}
	
	public static void show() {
		ArrayList<IRenderable> entities2 = RenderableHolder.getInstance().getEntities();
		for (IRenderable entity: entities2) {
			System.out.println(entity.toString()+entity.getZ());
		}
	}
	
	public static void loadResource() {
		String p = "picture/";
		
		//Player
		player_walk_left_Image = new Image(ClassLoader.getSystemResource(p+"player_walk_left.png").toString());
		player_walk_right_Image = new Image(ClassLoader.getSystemResource(p+"player_walk_right.png").toString());
		player_walk_up_Image = new Image(ClassLoader.getSystemResource(p+"player_walk_up.png").toString());
		player_walk_down_Image = new Image(ClassLoader.getSystemResource(p+"player_walk_down.png").toString());
	
		player_still_left_Image = new Image(ClassLoader.getSystemResource(p+"player_still_left.png").toString());
		player_still_right_Image = new Image(ClassLoader.getSystemResource(p+"player_still_right.png").toString());
		player_still_up_Image = new Image(ClassLoader.getSystemResource(p+"player_still_up.png").toString());
		player_still_down_Image = new Image(ClassLoader.getSystemResource(p+"player_still_down.png").toString());
	
		//Bin
		bin_infront_Image = new Image(ClassLoader.getSystemResource(p+"bin_infront.png").toString());
		bin_between_Image = new Image(ClassLoader.getSystemResource(p+"bin_between.png").toString());
	
		//Station
		station_infront_Image = new Image(ClassLoader.getSystemResource(p+"station_infront.png").toString());
		station_between_Image = new Image(ClassLoader.getSystemResource(p+"station_between.png").toString());
		
		
		//CabbageStorage
		cabbagestorage_infront_Image = new Image(ClassLoader.getSystemResource(p+"cabbagestorage_infront.png").toString());
		cabbagestorage_between_Image = new Image(ClassLoader.getSystemResource(p+"cabbagestorage_between.png").toString());
	
		//Dish
		dish_ontable_empty = new Image(ClassLoader.getSystemResource(p+"dish_ontable_empty.png").toString());
	}
	
	
}
