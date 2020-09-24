package test.combat;

import java.util.List;

import sidesObj.ActiveFaction;
import sidesObj.Faction;
import unit.base.ArmyStack;
import unit.base.ArmyUnitFactory;

//Given 2 Army Stacks Run Combat - refer to Warlords Combat Sequence document
public class CombatTester {
	private List<ArmyStack> armList1;
	private List<ArmyStack>  armList2;
	private ArmyUnitFactory uf;
	
	public void setUp(){
		ArmyStack  arm1 =new ArmyStack();
		ArmyStack  arm2 =new ArmyStack();
		Faction faction =null;//use Mock Objects
		ActiveFaction activeFaction =new ActiveFaction(faction);
		arm1.getUnitList().add(uf.getUnit("GreenDragon"));
		arm1.getUnitList().add(uf.getUnit("RedDragon"));
		arm1.getUnitList().add(uf.getUnit("BlackDragon"));
		arm2.getUnitList().add(uf.getUnit("Griffin"));
		arm2.getUnitList().add(uf.getUnit("KnightLord"));
		arm2.getUnitList().add(uf.getUnit("Infantry"));
		arm2.getUnitList().add(uf.getUnit("Mummy"));
		armList1.add(arm1);
		armList2.add(arm2);
	}
	
	public void runCombat(List<ArmyStack> armLi1, List<ArmyStack>  armLi2){
		/*
		 * Integer cursePrecent1= armLi1.stream().flatMap(p -> p.getUnitList().stream()).filter(u->u.getUnitName().endsWith("")).mapToInt(Unit::getCursePoints).sum()*4;
		 * Integer poisonPrecent1= armLi1.stream().flatMap(p -> p.getUnitList().stream()).mapToInt(Unit::getPoisonPoints).sum()*4;
		 * Integer diseasePrecent1= armLi1.stream().flatMap(p -> p.getUnitList().stream()).mapToInt(Unit::getDiseasePoints).sum()*4;
		 * Integer paralysisPrecent1= armLi1.stream().flatMap(p -> p.getUnitList().stream()).mapToInt(Unit::getParalysisPoints).sum()*4;
		 */
	
	}
}