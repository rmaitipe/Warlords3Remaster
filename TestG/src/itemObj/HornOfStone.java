package itemObj;

import attributes.HitsPlusAll2;

public class HornOfStone extends Item{
	
	HornOfStone(){
		this.getEffectStackList().add(new HitsPlusAll2());
	}

}
