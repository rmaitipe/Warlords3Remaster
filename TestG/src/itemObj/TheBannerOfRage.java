package itemObj;

import attributes.MoralePlus2;

public class TheBannerOfRage extends Item{
	
	TheBannerOfRage(){
		this.getEffectSelfList().add(new MoralePlus2());
		this.setItemDesc("This magical banner improves the morale of all those who fight beneath it");
	}
}
