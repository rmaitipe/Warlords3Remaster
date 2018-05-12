package itemObj;

import attributes.IncomePerCity2;

public class TheBlueKey extends Item{
	
	TheBlueKey(){
		this.getEffectStackList().add(new IncomePerCity2());
		this.setItemDesc("The Blue Key opens new oportunities for those who hold it bringing them treasures beyond their dreams");
	}
}
