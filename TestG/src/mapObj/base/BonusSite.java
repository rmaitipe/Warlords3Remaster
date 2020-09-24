package mapObj.base;

/* This abstract class has 1 field - indicating whether it's effect is active or not (isRazed)*/
public abstract class BonusSite implements MapObject{

	private boolean isRazed;
		
	/*Updates the City Bonus on the closest city on Site being razed/rebuilt*/
	public void updateCityBonusonEvent(){
		
	}

	public boolean isRazed() {
		return isRazed;
	}

	public void setRazed(boolean isRazed) {
		this.isRazed = isRazed;
	}
		
}
