package spellObj;

import attributes.FearPlus1;

public class SongOfBattle extends Spell {

	SongOfBattle(){
		this.getEffectStackList().add(new FearPlus1());
	}
}
