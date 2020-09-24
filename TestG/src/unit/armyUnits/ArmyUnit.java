package unit.armyUnits;

import enums.ArmyUnitEnum;
/* This abstract class represents a Non Hero i.e. Army Unit - can be Units/Mercs/Allies */
public abstract class ArmyUnit extends Unit {
	
	private Integer prodTurns=1;
	private Integer unitPointCost;//Used For determining QuestRewards, Setting up factions
	private boolean isInvisible;
	private boolean isSummoned;
	
	public ArmyUnit(ArmyUnitEnum code) {
		super(code);
	}

	public Integer getProdTurns() {
		return prodTurns;
	}

	public void setProdTurns(Integer prodTurns) {
		this.prodTurns = prodTurns;
	}

	public Integer getUnitPointCost() {
		return unitPointCost;
	}

	public void setUnitPointCost(Integer unitPointCost) {
		this.unitPointCost = unitPointCost;
	}	
	
}
