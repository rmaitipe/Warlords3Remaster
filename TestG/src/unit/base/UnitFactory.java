package unit.base;

import java.util.List;
import java.util.Map;

import launcher.GameLookUpServiceImpl;
import sidesObj.Faction;
import unit.armyUnits.ActiveArmy;


public class UnitFactory {
	
	private GameLookUpServiceImpl lookupService;
	ActiveArmy unit=null;
	public Unit getUnit(Integer unitSlot, Faction fac){
	      if(unitSlot == null){
	         return null;
	      }	
    	  Map<Integer,List<String>> io = lookupService.getFactionArmyMap().get(fac);
    	  unit= new ActiveArmy(io.get(unitSlot));
	      return unit;
	  }
}
