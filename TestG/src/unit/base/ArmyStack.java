package unit.base;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import attributes.Effect;
import enums.other.RewardTypeEnum;
import itemObj.Item;
import mapObj.base.MapObject;
import mapObj.searchLoc.Ruin;
import unit.heroUnits.HeroUnit;

public class ArmyStack extends MapObject{
	private Integer armyStackId;
	private Integer effLeadership;//StackEffects Start
	private Integer effMorale;
	private Integer effChaos;
	private Integer effFear;
	private Integer effFortify;
	private Integer effSiege;     //StackEffects End
	private Integer effBonusTotal;//+5/-3
	private Integer effMovePoints;
	private Integer effHitPoints;//capped at 4
	private boolean isInvisible;//Check OnStack Effect
	private boolean isAllFly;//Check OnStack Effect and check MoveBonusEnum OnSelf
	private HashSet<MoveBonusEnum> terrMoveBonus;
	private List <Unit> unitList = new LinkedList <Unit>();
	
	public ArmyStack(Unit arm) {//1 man army
		this.getUnitList().add(arm);
	}
	
	public ArmyStack(){}
	public ArmyStack(List<Unit> units){}

	public void removeUnits(Unit arm){}
	public void addUnits(Unit arm){}
	private void moveArmyStack() {
	/* Stack Movement is the lower bound of individual Unit's movement. 
	If All units in a stack have certain abilities, they apply to the stack as a whole. 
	Calculate shortest path method- factor terrain cost*/
		startCombat(null);
	}
	public void onClickSelfArmyStack() {
		exploreRuin(null);//Click Happens on a hero - who is on Ruin Tile
	}		
	public void onClickEnemyArmyStack() {
		moveArmyStack();
		startCombat(null);
	}
	public void  vectorSelectedArmy(){}
	public void  disbandArmyStack(){}//Warn if Hero
		
	
	public Integer exploreRuin(ArmyStack heroStack) {//Hero explores alone, but has a Bonus from Stack
		//encounter
		Ruin ru = null;//use the lookup service to get the ruin
		if (Integer.parseInt(heroStack.toString())>ru.getChallengeLevel()){
			RewardTypeEnum rwd =ru.getReward();
			if (rwd==RewardTypeEnum.R_GOLD){}
			else if (rwd==RewardTypeEnum.R_MANACRYSTALS){}
			else if (rwd==RewardTypeEnum.R_ITEM){}
			else if (rwd==RewardTypeEnum.R_ALLIES){}// getfromFactionArmySet
			else if (rwd==RewardTypeEnum.R_SAGE){}//3 options
			// getGold. getItem, getStatIncrease, getAllies, getManaCrys
			// 
		}	
		else{
			//Hero Slain
		}
		return null;
	}
	
	public void startCombat(ArmyStack arm1){
		//create and update temp copy of both lists with the stack effects
		ArmyCombatObj aco = new ArmyCombatObj();
		aco.combat(Arrays.asList(this,arm1));
	}
		
	//Click to active vs merging 2 aStacks
	public ArmyStack addUnits(ArmyStack arm2){
		if (this.unitList.size()+arm2.getUnitList().size()<8){
			for (Unit unit:arm2.getUnitList()){
			}
		}
		else{
			throw new IndexOutOfBoundsException();
		}
		return null;
	}

	//Clicked to split Stacks
	public ArmyStack removeUnits(List<Unit> units){
		if (unitList.remove(null)){
		}
		ArmyStack as =new ArmyStack(units);
		return as;
	}
	
	private ArmyStack updateArmyStackEffect() {//Call after adding/removing units from ArmyStack-for now only the max takes effect
		ArmyStack copy = new ArmyStack();
		for (Unit uni:this.getUnitList()){
			if (uni instanceof HeroUnit){
				for (Item  item: ((HeroUnit) uni).getItemList()){
					if (!item.getEffectSelfList().isEmpty()){
						/**/
					}
				}
			}
			else{
				for (Unit uni1:unitList){
					uni1.setStrPoints(uni1.getStrPoints() + effBonusTotal>15 ? 15:uni1.getStrPoints() + effBonusTotal);
					uni1.setMovePoints(uni1.getMovePoints() + effMovePoints);
					uni1.setHitPoints(uni1.getHitPoints() + effHitPoints> 4 ? 4:uni1.getHitPoints() + effHitPoints );
					//isAllFly isInvisible
					copy.getUnitList().add(uni1);
				}
				for (Effect effect: uni.getEffectStackList()){
					
				}
				for (Effect effect: uni.getEffectSelfList()){
					
				}
			}
		}
		Effect effect = null;
		switch(effect.getEffectType()){
		case FearPlus1:
			if (this.getEffFear()<1){
				this.setEffFear(1);
			}
		case FearPlus2:
			if (this.getEffFear()<2){
				this.setEffFear(2);
			}
		case FearPlus3:
			if (this.getEffFear()<3){
				this.setEffFear(3);
			}
		case FearPlus4:
			if (this.getEffFear()<4){
				this.setEffFear(4);
			}
		case FearPlus5:
			if (this.getEffFear()<5){
				this.setEffFear(5);
			}
		break;
		default:
			break;
		}
		return copy;
	}
	
	public Integer getArmyStackId() {
		return armyStackId;
	}

	public void setArmyStackId(Integer armyStackId) {
		this.armyStackId = armyStackId;
	}

	public List<Unit> getUnitList() {
		return unitList;
	}

	public void setUnitList(List<Unit> unitList) {
		this.unitList = unitList;
	}

	public Integer getEffLeadership() {
		return effLeadership;
	}

	public void setEffLeadership(Integer effLeadership) {
		this.effLeadership = effLeadership;
	}

	public Integer getEffMorale() {
		return effMorale;
	}

	public void setEffMorale(Integer effMorale) {
		this.effMorale = effMorale;
	}

	public Integer getEffChaos() {
		return effChaos;
	}

	public void setEffChaos(Integer effChaos) {
		this.effChaos = effChaos;
	}

	public Integer getEffFear() {
		return effFear;
	}

	public void setEffFear(Integer effFear) {
		this.effFear = effFear;
	}

	public Integer getEffFortify() {
		return effFortify;
	}

	public void setEffFortify(Integer effFortify) {
		this.effFortify = effFortify;
	}

	public Integer getEffSiege() {
		return effSiege;
	}

	public void setEffSiege(Integer effSiege) {
		this.effSiege = effSiege;
	}

	public Integer getEffMovePoints() {
		return effMovePoints;
	}

	public void setEffMovePoints(Integer effMovePoints) {
		this.effMovePoints = effMovePoints;
	}

	public boolean isAllFly() {
		return isAllFly;
	}

	public void setAllFly(boolean isAllFly) {
		this.isAllFly = isAllFly;
	}

	public HashSet<MoveBonusEnum> getTerrMoveBonus() {
		return terrMoveBonus;
	}

	public void setTerrMoveBonus(HashSet<MoveBonusEnum> terrMoveBonus) {
		this.terrMoveBonus = terrMoveBonus;
	}
	
}
