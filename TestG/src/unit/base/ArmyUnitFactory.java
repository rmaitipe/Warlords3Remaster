package unit.base;

import java.util.Map;

import enums.ArmyUnitEnum;
import launcher.GameLookUpServiceImpl;
import sidesObj.Faction;
import unit.armyUnits.ActiveArmy;
import unit.armyUnits.Unit;


public class ArmyUnitFactory {
	
	private GameLookUpServiceImpl lookupService;
	ActiveArmy unit=null;
	
	public ActiveArmy getUnit(Integer unitSlot, Faction fac){
	      if(unitSlot == null){
	         return null;
	      }	
	      Map<Faction,Map<Integer,ArmyUnitEnum>> map = lookupService.getFactionArmyMap();
	      Map<Integer, ArmyUnitEnum> armySet = map.get(fac);
    	  unit= new ActiveArmy(armySet.get(unitSlot));
	      return unit;
	  }
	
	public Unit getUnit(String string) {
		// TODO Auto-generated method stub
		return null;
	}
}
