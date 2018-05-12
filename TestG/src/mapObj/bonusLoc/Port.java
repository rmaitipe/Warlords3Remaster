package mapObj.bonusLoc;

import mapObj.base.BonusSite;
//Transform to boat and vice versa when moving into/out of water and Gives +2 Gold to nearest City
public class Port extends BonusSite {
	
	private Integer addG;

	public Integer getAddG() {
		return addG;
	}

	public void setAddG(Integer addG) {
		this.addG = addG;
	}
	
}
