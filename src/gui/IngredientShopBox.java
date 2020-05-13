package gui;

import exception.InvalidIngredientNameException;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import sharedObject.RenderableHolder;

public class IngredientShopBox extends StackPane{
	private AmountBox amountBox;
	private IngredientItem ingredientItem;
	private String ingredientName;
	
	private static int width = 180;
	private static int height = 157;
	
	public IngredientShopBox(String ingredientName) {
		setIngredientName(ingredientName);
		
		this.setPrefWidth(width); this.setPrefHeight(height);
		
		this.setPadding(new Insets(2));
		//-------------------------------------------------
		//Background 
		Canvas bg = new Canvas(width,height);
		GraphicsContext bggc = bg.getGraphicsContext2D();
		bggc.drawImage(RenderableHolder.shoppane_window_Image, 0, 0,bg.getWidth(), bg.getHeight());
		
		this.getChildren().add(bg);
		//-------------------------------------------------
		//MainBox (VBox)
		VBox mainBox = new VBox();
		mainBox.setPrefWidth(117);
		mainBox.setPrefHeight(125);
		mainBox.setAlignment(Pos.CENTER);
		//mainBox.setPadding(new Insets(5,0,0,0));
		//-------------------------------------------------
		//Ingredient Name
		Label nameLabel = new Label(ingredientName);
		nameLabel.setFont(Font.font("Verdana", FontWeight.BOLD, 15));
		nameLabel.setTextFill(Color.BLACK);
		
		try {
			this.ingredientItem = new IngredientItem(ingredientName);
		} catch (InvalidIngredientNameException e) {
			e.printStackTrace();
		}
		//-------------------------------------------------
		//Ingredient Picture
		Pane ingredientPic = new StackPane();
		ingredientPic.setPrefHeight(64);
		ingredientPic.setPrefWidth(64);
		
		
		if (ingredientName == "Cabbage") {
			ImageView testImageView = new ImageView(RenderableHolder.cabbage_Image);
			testImageView.setFitHeight(40);
			ingredientPic.getChildren().add(testImageView);
		} else if (ingredientName == "Tomato") {
			ImageView testImageView = new ImageView(RenderableHolder.tomato_Image);
			testImageView.setFitHeight(40);
			ingredientPic.getChildren().add(testImageView);
		} else { //fish case
			ImageView testImageView = new ImageView(RenderableHolder.fish_Image);
			testImageView.setFitHeight(40);
			ingredientPic.getChildren().add(testImageView);
		}
		
		//-------------------------------------------------
		//Ingredient Price
		
		Label priceLabel = new Label(ingredientItem.getPrice()+" $ /piece");
		priceLabel.setFont(new Font(14));
		//-------------------------------------------------
		
		this.amountBox = new AmountBox();
		
		mainBox.getChildren().addAll(nameLabel,ingredientPic,priceLabel,amountBox);
		this.getChildren().add(mainBox);
		
		
		
	}

	public IngredientItem getIngredientItem() {
		return ingredientItem;
	}

	public AmountBox getAmountBox() {
		return amountBox;
	}

	public void setIngredientName(String ingredientName) {
		this.ingredientName = ingredientName;
	}

	public String getIngredientName() {
		return ingredientName;
	}
	
	
	
	
}
