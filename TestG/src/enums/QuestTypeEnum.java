package enums;

public enum QuestTypeEnum {
	MESSAGE("A Secret Message"), ESCORT("Escort Duty"), GIFT("Carry a Gift"), HUNT("Hunting Some Enemy Units"),
	LOOT("Some Looting and Pillaging"), CAPTURE("Capturing a City"), OBTAIN("Obtaining Some Temple Gold"),
	RAZE_1("Razing a Rival City"), KILL_HERO("Killing a Heathen"), BURN("Burning an Enemy Site"),
	OCCUPY("Occupying a Rival City"), ASSASINATE("Assassinate An enemy Leader"), ANEX("Annexing a New City"),
	RAZE_2("Razing an Enemy City"), RECOVER("Recovering a Stolen Item"), KILL_ENEMY("Killing Some Enemy");

	private String code;

	private QuestTypeEnum() {
		this.code = "";
	}

	private QuestTypeEnum(String code) {
		this.code = code;
	}

	public String getCode() {
		return code;
	}

}
