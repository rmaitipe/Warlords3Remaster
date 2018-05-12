package unit.heroUnits;

import attributes.LeadershipPlus1;

public class Bard extends HeroUnit{
	
	public Bard(String heroName, boolean isGenderFemale){
		super(HeroEnum.Bard.getCode(), heroName, isGenderFemale);
		this.getEffectStackList().add(new LeadershipPlus1());
		this.setCurrentXp(0);
		this.setHeroLevel(1);
		this.setMovePoints(18);
		this.setHitPoints(2);
		this.setStrPoints(4);
		this.setGoldUpkeep(5);
	}

}
