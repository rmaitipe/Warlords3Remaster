package unit.armyUnits;

import java.util.List;

/* This abstract class represents a Army Unit - can be Producible Units/Mercs/Allies */
public class ActiveArmy extends ArmyUnit {
	
	public ActiveArmy(List<String> list) {
		super(ArmyEnum.valueOf(list.get(1)));
		this.setStrPoints(Integer.parseInt(list.get(1)));
		this.setHitPoints(Integer.parseInt(list.get(2)));
		this.setMovePoints(Integer.parseInt(list.get(3)));
	}
	
}
