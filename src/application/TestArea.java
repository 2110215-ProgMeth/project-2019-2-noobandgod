package application;

import logic.GameController;

public class TestArea {

	public static void main(String[] args) {
		boolean b = GameController.isThisIngredientNameValid("EIEI");
		System.out.print(b);
	}

}
