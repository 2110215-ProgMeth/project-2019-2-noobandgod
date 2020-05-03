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
	
	//Cabbage
	public static Image cabbage_Image;
	
	//TomatoStorage
	public static Image tomatostorage_infront_Image;
	public static Image tomatostorage_between_Image;
	
	//Dish
	public static Image dish_ontable_empty_Image;
	public static Image dish_onhead_empty_Image;
	
	//DishPicker
	public static Image dishpicker_infront_Image;
	public static Image dishpicker_between_Image;
	
	
	
	
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
			if (entities.get(i) instanceof Updatable) {
				((Updatable) entities.get(i)).update();
			}
		}
		for (int i1 = entities.size() - 1; i1 >= 0; i1--) {
			if (!entities.get(i1).isVisible()) {
				entities.remove(i1);
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
			System.out.println(entity.toString()+"  (Z = "+entity.getZ()+")");
			System.out.println("-------------------------------");
		}
		System.out.println("===================================");
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
	
		//Cabbage
		cabbage_Image = new Image(ClassLoader.getSystemResource(p+"cabbage.png").toString());

		//TomatoStorage
		tomatostorage_infront_Image = new Image(ClassLoader.getSystemResource(p+"tomatostorage_infront.png").toString());
		tomatostorage_between_Image = new Image(ClassLoader.getSystemResource(p+"tomatostorage_between.png").toString());
		
		//Dish
		dish_ontable_empty_Image = new Image(ClassLoader.getSystemResource(p+"dish_ontable_empty.png").toString());
		dish_onhead_empty_Image = new Image(ClassLoader.getSystemResource(p+"dish_onhead_empty.png").toString());
	
		//DishPicker
		dishpicker_infront_Image = new Image(ClassLoader.getSystemResource(p+"dishpicker_infront.png").toString());
		dishpicker_between_Image = new Image(ClassLoader.getSystemResource(p+"dishpicker_between.png").toString());
	}
	
	
}
