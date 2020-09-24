package unit.base;

import java.util.Map;

import enums.HeroEnum;
import launcher.GameLookUpServiceImpl;
import sidesObj.Faction;
import unit.armyUnits.ActiveArmy;
import unit.armyUnits.HeroUnit;
import unit.armyUnits.Unit;


public class HeroFactory {
	
	private GameLookUpServiceImpl lookupService;
	ActiveArmy unit=null;
	
	public Unit getUnit(Integer unitSlot, Faction fac){
	      if(unitSlot == null){
	         return null;
	      }	
	      Map<Faction,Map<Integer,HeroEnum>> map = lookupService.getFactionHeroMap();//Map<Faction,Map<Integer,List<String>>
	      Map<Integer, HeroEnum> armySet = map.get(fac);
    	  unit= new ActiveArmy(armySet.get(unitSlot));
	      return unit;
	  }
	public static Unit getUnit(String string) {
		// TODO Auto-generated method stub
		return null;
	}
	public static HeroUnit getUnit(HeroEnum general, String heroName, boolean isFemale) {
		// TODO Auto-generated method stub
		return null;
	}
}
