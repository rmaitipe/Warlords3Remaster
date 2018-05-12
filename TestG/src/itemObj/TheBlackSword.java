package itemObj;

import attributes.FearPlus1;
import attributes.StrengthPlus2;

public class TheBlackSword extends Item{
	
	TheBlackSword(){
		this.getEffectStackList().add(new FearPlus1());
		this.getEffectSelfList().add(new StrengthPlus2());
		this.setItemDesc("The Black Sword is a frightful thing to look upon");
	}
}
