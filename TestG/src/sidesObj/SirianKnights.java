package sidesObj;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import enums.ArmyUnitEnum;
import enums.HeroEnum;

public class SirianKnights extends Faction {
	
	SirianKnights(){
		this.setFactionName("Sirian Knights");
		this.setManaMax(12);
		Set<HeroEnum> factHeroSet = Stream.of(HeroEnum.Thief,HeroEnum.Warrior).collect(Collectors.toSet());
		Set<ArmyUnitEnum> factArmySet = Stream.of(ArmyUnitEnum.KnightLord).collect(Collectors.toSet());
		Set<ArmyUnitEnum> factAllySet = Stream.of(ArmyUnitEnum.GreenDragon).collect(Collectors.toSet());
//		this.setFactAlliesList(factAlliesList);
//		this.setFactMercsList(factMercsList);
		
	}
	
}
