package launcher;

import java.awt.Point;
import java.util.List;
import java.util.Map;
import java.util.Set;

import itemObj.Item;
import mapObj.base.BonusSite;
import mapObj.cities.City;
import mapObj.searchLoc.Ruin;
import sidesObj.Faction;
import unit.armyUnits.ArmyUnit;
import unit.base.Unit;
import unit.heroUnits.HeroUnit;
/* This class is for loading and looking up static values from Game like factions/armies/heros/items 
 * need to add Spring  - use applicationContext.xml or implement InitializingBean */
public class MasterLookUpServiceImpl  implements MasterLookUpService, InitializingBean {
	
	//Initialize at application Start- has baseObjects//Spring? used by Game Obj
	private Map<String,List<Faction>> masterFactionsMap;
	private Map<String,List<String>> masterArmyMap;//army name, army info
	private List<Faction> masterItemList;
	//heroLevelsMap
	//itemComboList
	public void init(){
		
	}
	

	@Override
	public List<Item> itemsLookUp() {
		// TODO Auto-generated method stub
		return null;
	}

	public Map<String, List<Faction>> getMasterFactionsMap() {
		return masterFactionsMap;
	}

	public void setMasterFactionsMap(Map<String, List<Faction>> masterFactionsMap) {
		this.masterFactionsMap = masterFactionsMap;
	}

	public List<Faction> getMasterItemList() {
		return masterItemList;
	}

	public void setMasterItemList(List<Faction> masterItemList) {
		this.masterItemList = masterItemList;
	}

	@Override
	public List<HeroUnit> factHerosLookup(String factName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ArmyUnit> factArmiesLookUp(String factName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Faction> factionsLookUp(String selectedFactionSet) {
		// TODO Auto-generated method stub
		return null;
	}

	public Map<String, List<String>> getMasterArmyMap() {
		return masterArmyMap;
	}

	public void setMasterArmyMap(Map<String, List<String>> masterArmyMap) {
		this.masterArmyMap = masterArmyMap;
	}

}
