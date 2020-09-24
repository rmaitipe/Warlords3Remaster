package sidesObj;

import java.util.HashMap;
import java.util.Map;

import enums.ArmyUnitEnum;
import enums.HeroEnum;

public abstract class Faction {

	protected String factionName;
	protected Integer manaMax;//add manaType
	private Integer factPoints;//used to determine who is winning and threat level-cities+heroLevels+armyValue
	
	//PreConfigured ArmySet Units+Allies+Mercs+Heros
	protected Map<Integer,HeroEnum> factHeroMap = new HashMap<Integer,HeroEnum>();
	protected Map<Integer,ArmyUnitEnum> factAllyMap = new HashMap<Integer,ArmyUnitEnum>();//15
	protected Map<Integer,ArmyUnitEnum> factMercsMap = new HashMap<Integer,ArmyUnitEnum>();
	protected Map<Integer,ArmyUnitEnum> factArmyMap  = new HashMap<Integer,ArmyUnitEnum>();
	
	public String getFactionName() {
		return factionName;
	}
	
	public void setFactionName(String factionName) {
		this.factionName = factionName;
	}
	
	public Integer getManaMax() {
		return manaMax;
	}
	
	public void setManaMax(Integer manaMax) {
		this.manaMax = manaMax;
	}

	public Integer getFactPoints() {
		return factPoints;
	}

	public void setFactPoints(Integer factPoints) {
		this.factPoints = factPoints;
	}

	public Map<Integer, HeroEnum> getFactHeroMap() {
		return factHeroMap;
	}

	public void setFactHeroMap(Map<Integer, HeroEnum> factHeroMap) {
		this.factHeroMap = factHeroMap;
	}

	public Map<Integer, ArmyUnitEnum> getFactAllyMap() {
		return factAllyMap;
	}

	public void setFactAllyMap(Map<Integer, ArmyUnitEnum> factAllyMap) {
		this.factAllyMap = factAllyMap;
	}

	public Map<Integer, ArmyUnitEnum> getFactMercsMap() {
		return factMercsMap;
	}

	public void setFactMercsMap(Map<Integer, ArmyUnitEnum> factMercsMap) {
		this.factMercsMap = factMercsMap;
	}

	public Map<Integer, ArmyUnitEnum> getFactArmyMap() {
		return factArmyMap;
	}

	public void setFactArmyMap(Map<Integer, ArmyUnitEnum> factArmyMap) {
		this.factArmyMap = factArmyMap;
	}

}
