package sidesObj;

import java.util.HashMap;
import java.util.Map;

import unit.armyUnits.ArmyEnum;
import unit.heroUnits.HeroEnum;

public abstract class Faction {

	protected String factionName;
	protected Integer manaMax;//add manaType
	private Integer factPoints;//used to determine who is winning and threat level-cities+heroLevels+armyValue
	
	//PreConfigured ArmySet Units+Allies+Mercs+Heros
	protected Map<Integer,HeroEnum> factHeroMap = new HashMap<Integer,HeroEnum>();
	protected Map<Integer,ArmyEnum> factAllyMap = new HashMap<Integer,ArmyEnum>();//15
	protected Map<Integer,ArmyEnum> factMercsMap = new HashMap<Integer,ArmyEnum>();
	protected Map<Integer,ArmyEnum> factArmyMap  = new HashMap<Integer,ArmyEnum>();
	
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

	public Map<Integer, ArmyEnum> getFactAllyMap() {
		return factAllyMap;
	}

	public void setFactAllyMap(Map<Integer, ArmyEnum> factAllyMap) {
		this.factAllyMap = factAllyMap;
	}

	public Map<Integer, ArmyEnum> getFactMercsMap() {
		return factMercsMap;
	}

	public void setFactMercsMap(Map<Integer, ArmyEnum> factMercsMap) {
		this.factMercsMap = factMercsMap;
	}

	public Map<Integer, ArmyEnum> getFactArmyMap() {
		return factArmyMap;
	}

	public void setFactArmyMap(Map<Integer, ArmyEnum> factArmyMap) {
		this.factArmyMap = factArmyMap;
	}

}
