package launcher;

import java.util.List;

import itemObj.Item;
import sidesObj.Faction;
import unit.armyUnits.ArmyUnit;
import unit.heroUnits.HeroUnit;

public interface MasterLookUpService {
	
	List<Faction> factionsLookUp(String selectedFactionSet);
	List<HeroUnit> factHerosLookup (String factName);
	List<ArmyUnit> factArmiesLookUp (String factName);
	List<Item> itemsLookUp();
	
}
