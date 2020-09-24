package unit.armyUnits;

import enums.ArmyUnitEnum;
import enums.HeroEnum;
import mapObj.base.MapObject;

public class ActiveArmy extends Unit implements MapObject{

	public ActiveArmy(ArmyUnitEnum code) {
		super(code);
	}

	public ActiveArmy(HeroEnum heroEnumCode) {
		super(heroEnumCode);
	}

}
