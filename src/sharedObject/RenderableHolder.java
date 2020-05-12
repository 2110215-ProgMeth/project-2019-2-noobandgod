package sharedObject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import entity.Cabbage;
import entity.Dish;
import entity.base.Updatable;
import javafx.scene.image.Image;

public class RenderableHolder {
	private ArrayList<IRenderable> entities;
	private Comparator<IRenderable> comparator;
	private static final RenderableHolder instance = new RenderableHolder();
	
	//Images
	
	//---------------[StartScreen & EndScreen]------------------
	
	
	
	
	public static Image endscreen_bg_good_Image;
	public static Image endscreen_bg_bad_Image;
	
	//---------------[GameScreen]-------------------------------
	
	//Floor
	public static Image floor_Image;
	
	//Player
	public static Image player0_sprite_Image;
	public static Image player1_sprite_Image;
	
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
	public static Image cabbage_sliced_Image;
	
	//TomatoStorage
	public static Image tomatostorage_infront_Image;
	public static Image tomatostorage_between_Image;
	
	//Tomato
	public static Image tomato_Image;
	public static Image tomato_sliced_Image;
	
	//FishStorage
	public static Image fishstorage_infront_Image;
	public static Image fishstorage_between_Image;
	
	//Fish
	public static Image fish_Image;
	public static Image fish_sliced_Image;
	public static Image fish_fried_Image;
	
	//Dish
	public static Image dish_ontable_empty_Image;
	public static Image dish_onhead_empty_Image;
	public static Image dish_onhead_simplesalad_Image;
	public static Image dish_onhead_sashimisalad_Image;
	public static Image dish_ontable_simplesalad_Image;
	public static Image dish_ontable_sashimisalad_Image;
	
	//DishPicker
	public static Image dishpicker_infront_Image;
	public static Image dishpicker_between_Image;
	
	//CuttingBoard
	public static Image cuttingboard_infront_Image;
	public static Image cuttingboard_between_Image;
	
	//FryingPan
	public static Image fryingpan_infront_Image;
	public static Image fryingpan_between_Image;
	
	//Obstacle
	public static Image obstacle_Image;
	
	//FoodCounter
	public static Image foodcounter_infront_Image;
	public static Image foodcounter_between_Image;
	
	//Menu
	public static Image menu_sashimisalad_Image;
	public static Image menu_simplesalad_Image;
	public static Image menu_friedfish_Image;
	
	//TimeBox
	public static Image timebox_bg_Image;
	
	//DataPane
	public static Image datapane_bg_Image;
	
	//OrderPane
	public static Image orderpane_bg_Image;
	
	//ShopPane
	public static Image shoppane_window_Image;
	public static Image shoppane_bg_Image;
	
	//GameScreen
	public static Image gamescreen_bg_Image;
	
	//Crate
	public static Image crate_tomato_empty_Image;
	public static Image crate_tomato_Image;
	
	public static Image crate_cabbage_empty_Image;
	public static Image crate_cabbage_Image;
	
	public static Image crate_fish_empty_Image;
	public static Image crate_fish_Image;
	
	//---------------------------------------------------------
	
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
		
		//System.out.println("Suscessfully added "+entity.toString()+"\nto entites....");
		
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
			if (entity instanceof Dish || entity instanceof Cabbage) {
				System.out.println(entity.toString()+"  (Z = "+entity.getZ()+")");
				System.out.println("-------------------------------");
			}
			
		}
		System.out.println("===================================");
	}
	
	public static void loadResource() {
		String p = "picture/";
		
		//---------------[StartScreen & EndScreen]------------------
		
		endscreen_bg_bad_Image = new Image(ClassLoader.getSystemResource(p+"endscreen_bg_bad.png").toString());
		endscreen_bg_good_Image = new Image(ClassLoader.getSystemResource(p+"endscreen_bg_good.png").toString());
		
		//---------------[GameScreen]-------------------------------
		//Floor
		floor_Image = new Image(ClassLoader.getSystemResource(p+"floor.png").toString());
		
		//Player
		player0_sprite_Image = new Image(ClassLoader.getSystemResource(p+"player0_sprite.png").toString());
		player1_sprite_Image = new Image(ClassLoader.getSystemResource(p+"player1_sprite.png").toString());
		
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
		cabbage_sliced_Image = new Image(ClassLoader.getSystemResource(p+"cabbage_sliced.png").toString());
		
		//TomatoStorage
		tomatostorage_infront_Image = new Image(ClassLoader.getSystemResource(p+"tomatostorage_infront.png").toString());
		tomatostorage_between_Image = new Image(ClassLoader.getSystemResource(p+"tomatostorage_between.png").toString());
		
		//Tomato
		tomato_Image = new Image(ClassLoader.getSystemResource(p+"tomato.png").toString());
		tomato_sliced_Image = new Image(ClassLoader.getSystemResource(p+"tomato_sliced.png").toString());
		
		//FishStorage
		fishstorage_infront_Image = new Image(ClassLoader.getSystemResource(p+"fishstorage_infront.png").toString());
		fishstorage_between_Image = new Image(ClassLoader.getSystemResource(p+"fishstorage_between.png").toString());
		
		//Fish
		fish_Image = new Image(ClassLoader.getSystemResource(p+"fish.png").toString());
		fish_sliced_Image = new Image(ClassLoader.getSystemResource(p+"fish_sliced.png").toString());
		fish_fried_Image = new Image(ClassLoader.getSystemResource(p+"fish_fried.png").toString());
		
		//Dish
		dish_ontable_empty_Image = new Image(ClassLoader.getSystemResource(p+"dish_ontable_empty.png").toString());
		dish_onhead_empty_Image = new Image(ClassLoader.getSystemResource(p+"dish_onhead_empty.png").toString());
		dish_onhead_simplesalad_Image = new Image(ClassLoader.getSystemResource(p+"dish_onhead_simplesalad.png").toString());
		dish_onhead_sashimisalad_Image = new Image(ClassLoader.getSystemResource(p+"dish_onhead_sashimisalad.png").toString());
		dish_ontable_simplesalad_Image = new Image(ClassLoader.getSystemResource(p+"dish_ontable_simplesalad.png").toString());
		dish_ontable_sashimisalad_Image = new Image(ClassLoader.getSystemResource(p+"dish_ontable_sashimisalad.png").toString());
		
		//DishPicker
		dishpicker_infront_Image = new Image(ClassLoader.getSystemResource(p+"dishpicker_infront.png").toString());
		dishpicker_between_Image = new Image(ClassLoader.getSystemResource(p+"dishpicker_between.png").toString());
	
		//CuttingBoard
		cuttingboard_infront_Image = new Image(ClassLoader.getSystemResource(p+"cuttingboard_infront.png").toString());
		cuttingboard_between_Image = new Image(ClassLoader.getSystemResource(p+"cuttingboard_between.png").toString());
	
		//FryingPan
		fryingpan_infront_Image = new Image(ClassLoader.getSystemResource(p+"fryingpan_infront.png").toString());
		fryingpan_between_Image = new Image(ClassLoader.getSystemResource(p+"fryingpan_between.png").toString());
	
		//Obstacle
		obstacle_Image = new Image(ClassLoader.getSystemResource(p+"obstacle.png").toString());
		
		//FoodCounter
		foodcounter_infront_Image = new Image(ClassLoader.getSystemResource(p+"foodcounter_infront.png").toString());
		foodcounter_between_Image = new Image(ClassLoader.getSystemResource(p+"foodcounter_between.png").toString());
	
		//Menu
		menu_sashimisalad_Image = new Image(ClassLoader.getSystemResource(p+"menu_sashimisalad.png").toString());
		menu_simplesalad_Image = new Image(ClassLoader.getSystemResource(p+"menu_simplesalad.png").toString());
		menu_friedfish_Image = new Image(ClassLoader.getSystemResource(p+"menu_friedfish.png").toString());
		
		//TimeBox
		timebox_bg_Image = new Image(ClassLoader.getSystemResource(p+"timebox_bg.png").toString());
	
		//DataPane
		datapane_bg_Image = new Image(ClassLoader.getSystemResource(p+"datapane_bg.png").toString());
	
		//OrderPane
		orderpane_bg_Image = new Image(ClassLoader.getSystemResource(p+"orderpane_bg.png").toString());
	
		//ShopPane
		shoppane_window_Image = new Image(ClassLoader.getSystemResource(p+"shoppane_window.png").toString());
		shoppane_bg_Image = new Image(ClassLoader.getSystemResource(p+"shoppane_bg.png").toString());
		
		//GameScreen
		gamescreen_bg_Image = new Image(ClassLoader.getSystemResource(p+"gamescreen_bg.png").toString());
		
		//Crate
		crate_tomato_empty_Image = new Image(ClassLoader.getSystemResource(p+"crate_tomato_empty.png").toString());
		crate_tomato_Image = new Image(ClassLoader.getSystemResource(p+"crate_tomato.png").toString());
		
		crate_cabbage_empty_Image = new Image(ClassLoader.getSystemResource(p+"crate_cabbage_empty.png").toString());
		crate_cabbage_Image = new Image(ClassLoader.getSystemResource(p+"crate_cabbage.png").toString());
	
		crate_fish_empty_Image = new Image(ClassLoader.getSystemResource(p+"crate_fish_empty.png").toString());
		crate_fish_Image = new Image(ClassLoader.getSystemResource(p+"crate_fish.png").toString());
	}
	
	
}
