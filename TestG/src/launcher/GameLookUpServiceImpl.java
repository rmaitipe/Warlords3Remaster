package launcher;

import java.util.List;
import java.util.Map;

import itemObj.Item;
import mapObj.base.BonusSite;
import mapObj.cities.City;
import mapObj.searchLoc.Ruin;
import sidesObj.ActiveFaction;
import sidesObj.Faction;
import unit.armyUnits.ActiveArmy;
/* This class is for loading and looking up dynamic values from Game like cities/ruins/sites 
 * need to add Spring  - use applicationContext.xml or implement InitializingBean */
public class GameLookUpServiceImpl  implements GameLookUpService, InitializingBean {
	
	private List<City> cityList;
	private List<BonusSite> siteList;
	private List<Ruin> ruinList;
	private Map<Faction,Map<Integer,List<String>>> factionArmyMap;//All units including heroes
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

	public List<Ruin> ruinsLookUp(int randSeed, int ruinCount, List<Item> itemList) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public Map<Faction,Map<Integer,List<String>>> getFactionArmyMap() {
		// Populate from masterlist for factions slots
		return null;
	}
	
}
