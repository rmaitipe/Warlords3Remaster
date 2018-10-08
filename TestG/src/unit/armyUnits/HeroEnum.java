package unit.heroUnits;

public enum HeroEnum {

	General,Bard,Paladin,Monk,	
	Barbarian,Shaman,Vampire,Necromancer,
	Wizard,Ranger, Warrior,	Thief,
	Priest, Alchemist, Summoner;
	
	private String code;
	
	private HeroEnum() {
		this.code = "";
	}
	
	private HeroEnum(String code) {
		this.code = code;
	}
	
	public String getCode() {
		return code;
	}
}
