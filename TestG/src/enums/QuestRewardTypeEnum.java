package enums;

public enum QuestRewardTypeEnum {
	R_GOLD1("Some Gold Coins"), R_ALLIES1("A Powerful Comanion"), R_MERCS1("Few Loyal Mercenaries"),
	R_ITEM1("A Magical Trinket"), R_XP1("An Ancient Tome"), R_RUIN_LOCATION("The Map to a Lost Ruin"),
	R_SAGE_LOCATION("The Map to a Sage"), R_GOLD2("A Chest of Gold"), R_MANA2("A Single Mana Crystal"),
	R_GOLD3("A Dragon's Hoard of Treasure"), R_MANA3("A Cluster of Mana Crystals"),
	R_ALLIES3("A Host of Powerful Allies"), R_ITEM3("A Powerful Artifact"), R_XP3("A Week's Tution at Palace");

	private String code;

	private QuestRewardTypeEnum() {
		this.code = "";
	}

	private QuestRewardTypeEnum(String code) {
		this.code = code;
	}

	public String getCode() {
		return code;
	}

}
