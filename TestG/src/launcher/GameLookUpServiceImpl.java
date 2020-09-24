package launcher;

import java.util.List;
import java.util.Map;

import enums.ArmyUnitEnum;
import enums.HeroEnum;
import itemObj.Item;
import mapObj.base.BonusSite;
import mapObj.cities.City;
import mapObj.searchLoc.Explorable;
import sidesObj.ActiveFaction;
import sidesObj.Faction;
/* This class is for loading and looking up dynamic values from Game like cities/ruins/sites 
 * need to add Spring  - use applicationContext.xml or implement InitializingBean */
public class GameLookUpServiceImpl  implements GameLookUpService {
	
	private List<City> cityList;
	private List<BonusSite> siteList;
	private List<Explorable> ruinList;
	private Map<Faction,Map<Integer,ArmyUnitEnum>> factionArmyMap;//All faction army units 
	private Map<Faction,Map<Integer,HeroEnum>> factionHeroMap;//All faction heroes
	//Initialize at application Start- has baseObjects//Spring? used by Game Obj
	//factionsMasterMap
	//heroLevelsMap
	//itemComboList
	public void init(){
		
	}
	
	public List<Item> itemsLookUp(int randSeed, List<Item> itemsLookUp) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<City> cityListLookUp(int randSeed, int cityCount, List<ActiveFaction> actFactList,
			List<BonusSite> siteList2, String gameMode) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<BonusSite> bonusSitesLookUp(int randSeed, int siteCount) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Explorable> ruinsLookUp(int randSeed, int ruinCount, List<Item> itemList) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public Map<Faction,Map<Integer,ArmyUnitEnum>> getFactionArmyMap() {
		// Populate from masterlist for factions slots
		return null;
	}

	public Map<Faction, Map<Integer, HeroEnum>> getFactionHeroMap() {
		return factionHeroMap;
	}

	public void setFactionHeroMap(Map<Faction, Map<Integer, HeroEnum>> factionHeroMap) {
		this.factionHeroMap = factionHeroMap;
	}
	
}
