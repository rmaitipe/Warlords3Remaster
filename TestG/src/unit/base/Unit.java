package unit.base;

import java.awt.Image;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import attributes.Effect;
import mapObj.base.MapObject;
import unit.armyUnits.ArmyEnum;
/* This abstract class represents a base Unit - gets extended by ArmyUnit, HeroUnit
 * Unit stats can be permanently modified by effects, hits can't go below 1*/
public abstract class Unit extends MapObject{
	
	private List<Effect> effectStackList = new ArrayList<Effect>(); 
	private List<Effect> effectSelfList = new ArrayList<Effect>();
	
	private Integer unitId;//unique Identifier for each Army Unit
	private ArmyEnum unitName;
	private Integer movePoints;
	private Integer strPoints;
	private Integer hitPoints;
	private Integer viewRange;
	private Set<TerrainCombatBonusEnum> terraBonus;//Separate from StackBonus
	private Set<MoveBonusEnum> moveBonus;   //Separate from StackBonus
	private Integer goldUpkeep;

	private Integer manaUpkeep;
	private Image unitPortrait;

	public Unit(ArmyEnum code) {
		unitName =code;
	}
	
	public Image getUnitPortrait() {
		return unitPortrait;
	}
	
	public void setUnitPortrait(Image unitPortrait) {
		this.unitPortrait = unitPortrait;
	}

	public Integer getMovePoints() {
		return movePoints;
	}
	public void setMovePoints(Integer movePoints) {
		this.movePoints = movePoints;
	}
	public Integer getStrPoints() {
		return strPoints;
	}
	public void setStrPoints(Integer strPoints) {
		this.strPoints = strPoints;
	}
	public Integer getHitPoints() {
		return hitPoints;
	}
	public void setHitPoints(Integer hitPoints) {
		if (hitPoints<1){
			this.hitPoints=1;
		}
		else{
			this.hitPoints = hitPoints;
		}
	}

	public Integer getGoldUpkeep() {
		return goldUpkeep;
	}

	public void setGoldUpkeep(Integer goldUpkeep) {
		this.goldUpkeep = goldUpkeep;
	}

	public Integer getManaUpkeep() {
		return manaUpkeep;
	}

	public void setManaUpkeep(Integer manaUpkeep) {
		this.manaUpkeep = manaUpkeep;
	}

	public ArmyEnum getUnitName() {
		return unitName;
	}

	public void setUnitName(ArmyEnum unitName) {
		this.unitName = unitName;
	}

	public Integer getUnitId() {
		return unitId;
	}

	public void setUnitId(Integer unitId) {
		this.unitId = unitId;
	}

	public Integer getViewRange() {
		return viewRange;
	}

	public void setViewRange(Integer viewRange) {
		this.viewRange = viewRange;
	}

	public Set<MoveBonusEnum> getMoveBonus() {
		return moveBonus;
	}

	public void setMoveBonus(Set<MoveBonusEnum> moveBonus) {
		this.moveBonus = moveBonus;
	}

	public List<Effect> getEffectStackList() {
		return effectStackList;
	}

	public void setEffectStackList(List<Effect> effectStackList) {
		this.effectStackList = effectStackList;
	}

	public List<Effect> getEffectSelfList() {
		return effectSelfList;
	}

	public void setEffectSelfList(List<Effect> effectSelfList) {
		this.effectSelfList = effectSelfList;
	}

	public Set<TerrainCombatBonusEnum> getTerraBonus() {
		return terraBonus;
	}

	public void setTerraBonus(Set<TerrainCombatBonusEnum> terraBonus) {
		this.terraBonus = terraBonus;
	}

}
