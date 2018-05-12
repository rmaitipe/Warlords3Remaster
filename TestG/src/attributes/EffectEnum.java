package attributes;

public enum EffectEnum {
	HitsPlusAll2,
	MoralePlus2,
	HitsPlus1,
	MissilesPlus3,
	FearPlus1,
	FearPlus2,
	FearPlus3,
	FearPlus4,
	FearPlus5, PoisonPlus3,
	LeadershipPlus1, StrengthPlus2,
	FortifyPlus3, IncomePerCity2;

	private String code;
	
	private EffectEnum() {
		this.code = "";
	}
	
	private EffectEnum(String code) {
		this.code = code;
	}
	
	public String getCode() {
		return code;
	}
}