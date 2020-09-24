package unit.armyUnits;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import enums.HeroEnum;
import itemObj.Item;
import spellObj.Spell;
/* Has 1 Leadership at starting */
public abstract class HeroUnit extends Unit{
	
	private Integer heroLevel;//MaxLevel 10
	private Integer currentXp;
	private String heroName;
	private Integer levelPoints;//Given on level Ups Used to Purchase Abilities
	private List<Item> itemList = new ArrayList<Item>();
	private Map<Spell,Boolean> spellsOwnedMap = new HashMap<Spell,Boolean>();//available vs active /onHero vs onStack vs onFaction
	
	//getQuest - dependent on city level
	public HeroUnit(HeroEnum unitName, String hName, boolean isGenderFemale) {
		super(unitName);
		if(isGenderFemale){//Unit Portrait changes based on gender
		heroName=hName;	
		}
	}
	
	public void getQuestforHero(){}
	public void sellItemsOnHero(){}
	public void castSpellOnHero(){}
	
	public void heroLevelUp() {
		heroLevel++;
	}	

	public Integer getHeroLevel() {
		return heroLevel;
	}

	public void setHeroLevel(Integer heroLevel) {
		this.heroLevel = heroLevel;
	}

	public Integer getCurrentXp() {
		return currentXp;
	}

	public void setCurrentXp(Integer currentXp) {
		this.currentXp = currentXp;
	}

	public List<Item> getItemList() {
		return itemList;
	}
	public void setItemList(List<Item> itemList) {
		this.itemList = itemList;
	}

	public Map<Spell, Boolean> getSpellsOwnedMap() {
		return spellsOwnedMap;
	}

	public void setSpellsOwnedMap(Map<Spell, Boolean> spellsOwnedMap) {
		this.spellsOwnedMap = spellsOwnedMap;
	}

	public Integer getLevelPoints() {
		return levelPoints;
	}

	public void setLevelPoints(Integer levelPoints) {
		this.levelPoints = levelPoints;
	}

	public String getHeroName() {
		return heroName;
	}

	public void setHeroName(String heroName) {
		this.heroName = heroName;
	}

}
