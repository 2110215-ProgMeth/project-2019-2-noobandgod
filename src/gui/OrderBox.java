package gui;

import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

public class OrderBox extends VBox {
	private Pane foodPic;
	public OrderBox(int typeMenu) {
		super();
		this.setPrefHeight(64);
		this.setPrefWidth(80);
		this.setSpacing(16);
		this.foodPic = new Pane();
		foodPic.setPrefHeight(64);
		foodPic.setPrefWidth(64);
		
		if (typeMenu==1) {
			
			
			
			
		}else if (typeMenu==2) {
		
			
			
		}else {
			
			
			
			
		}
		
		
	
	}
	
}
