package attributes;
/* This abstract class has 2 fields - one for the Effect (EffectEnum) and the other for 
 * its applicability (EffectOnEnum)*/
public abstract class Effect {
	
	private EffectOnEnum effectOn;
	private EffectEnum effectType;
	
	public Effect(EffectEnum code,EffectOnEnum affect) {
		effectType = code;
		effectOn = affect;
	}

	public EffectOnEnum getEffectOn() {
		return effectOn;
	}

	public void setEffectOn(EffectOnEnum effectOn) {
		this.effectOn = effectOn;
	}

	public EffectEnum getEffectType() {
		return effectType;
	}

	public void setEffectType(EffectEnum effectType) {
		this.effectType = effectType;
	}


}
