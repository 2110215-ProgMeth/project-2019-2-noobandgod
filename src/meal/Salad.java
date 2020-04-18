package meal;

public class Salad extends Menu{
	protected int saladType;

	public Salad(int timeleft,int saladType) {
		super(timeleft);
		if (saladType == 0) {
			setSaladType(saladType);
			this.name = "Simple Salad";
			//set price and max_score
			//set ingredients
			
		} else if (saladType == 1) {
			setSaladType(saladType);
			this.name = "Sashimi Salad";
			//set price and max_score
			//set ingredients
			
		} else {
			System.out.println("saladType ERROR!!");
		}
		
	}

	@Override
	public boolean isAllIngredients() {
		// TODO Auto-generated method stub
		return false;
	}

	public int getSaladType() {
		return saladType;
	}

	public void setSaladType(int saladType) {
		this.saladType = saladType;
	}
	
	

	
	
}
