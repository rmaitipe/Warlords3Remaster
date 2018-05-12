package sidesObj;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import unit.armyUnits.ArmyEnum;
import unit.heroUnits.HeroEnum;

public class SirianKnights extends Faction {
	
	SirianKnights(){
		this.setFactionName("Sirian Knights");
		this.setManaMax(12);
		Set<HeroEnum> factHeroSet = Stream.of(HeroEnum.Thief,HeroEnum.Warrior).collect(Collectors.toSet());
		Set<ArmyEnum> factArmySet = Stream.of(ArmyEnum.KnightLord).collect(Collectors.toSet());
		Set<ArmyEnum> factAllySet = Stream.of(ArmyEnum.GreenDragon).collect(Collectors.toSet());
//		this.setFactAlliesList(factAlliesList);
//		this.setFactMercsList(factMercsList);
		
	}
	
}
