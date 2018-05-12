package itemObj;

import attributes.StrengthPlus2;

public class TheAxeOfSlaying extends Item{
	
	TheAxeOfSlaying(){
		this.getEffectSelfList().add(new StrengthPlus2());
		this.setItemDesc("It is said that this axe can cleave straight through an opponent's armour");
	}
}
