package sharedObject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import entity.base.Updatable;

public class RenderableHolder {
	private ArrayList<IRenderable> entities;
	private Comparator<IRenderable> comparator;
	private static final RenderableHolder instance = new RenderableHolder();
	
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
	
	
	
}
