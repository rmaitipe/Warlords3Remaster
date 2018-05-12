package unit.armyUnits;

import unit.base.Unit;
/* This abstract class represents a Army Unit - can be Producible Units/Mercs/Allies */
public abstract class ArmyUnit extends Unit {
	
	private Integer prodTurns=1;
	private Integer unitPointCost;//Used For determining QuestRewards, Setting up factions
	private boolean isInvisible;
	private boolean isSummoned;
	
	public ArmyUnit(ArmyEnum code) {
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
