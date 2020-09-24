package mapObj.cities;

import java.util.HashMap;
import java.util.Map;

import enums.ManaEnum;
import mapObj.base.MapObject;
import sidesObj.Faction;
import unit.armyUnits.ArmyUnit;
/* This class keeps track of which faction owns the city.
 * Cities has 8 available units but only 4 unit production slots and each of slots must be unlocked if not available
 * On City Conquest, Occupy keeps compatible unit slots and CityLevel, Pillage keeps compatible unit slots and lose 1 CityLevel, and Sack loses all slots and reduce to CityLevel 1.
 * Shrine Bonuses can modify the base unit */
public class City implements MapObject{
	private Faction owner;//default value Neutrals
	private String cityName;
	private ManaEnum manaType;
	private Integer manaIncome;
	private CityLevelEnum cityLevel;
	private Integer goldIncome;
	private boolean isRazed;
	private Integer prodTurnsLeft;
	private ArmyUnit currentArmyProd;//If no Unit Production this will be null
	private Map<ArmyUnit,Boolean> cityProdMap = new HashMap<ArmyUnit,Boolean>();//Slots out of possible 8
	
	//can be only razed on the time of capture by units
	//actions upgrade, buyProd, changeProd
	public void upgradeSelectedCity(){}
	public void razeCity(){}
	public void vectorArmyProdForCity(){}
	public void placeArmyInCity(ArmyUnit arm1) {
		// Place Unit in Existing Stack or if none exists create a new Stack and place it
		
	}
	
	public String getCityName() {
		return cityName;
	}
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}


	public Integer getManaIncome() {
		return manaIncome;
	}

	public void setManaIncome(Integer manaIncome) {
		this.manaIncome = manaIncome;
	}

	public Integer getGoldIncome() {
		return goldIncome;
	}

	public void setGoldIncome(Integer goldIncome) {
		this.goldIncome = goldIncome;
	}
	
	public ManaEnum getManaType() {
		return manaType;
	}
	
	public void setManaType(ManaEnum manaType) {
		this.manaType = manaType;
	}
	
	public CityLevelEnum getCityLevel() {
		return cityLevel;
	}
	public void setCityLevel(CityLevelEnum cityLevel) {
		this.cityLevel = cityLevel;
	}
	public boolean isRazed() {
		return isRazed;
	}
	
	public void setRazed(boolean isRazed) {
		this.isRazed = isRazed;
	}
	
	public Integer getProdTurnsLeft() {
		return prodTurnsLeft;
	}
	
	public void setProdTurnsLeft(Integer prodTurnsLeft) {
		this.prodTurnsLeft = prodTurnsLeft;
	}
	
	public ArmyUnit getCurrentArmyProd() {
		return currentArmyProd;
	}
	
	public void setCurrentArmyProd(ArmyUnit currentArmyProd) {
		this.currentArmyProd = currentArmyProd;
	}
	
	public Map<ArmyUnit, Boolean> getCityProdMap() {
		return cityProdMap;
	}
	
	public void setCityProdMap(Map<ArmyUnit, Boolean> cityProdMap) {
		this.cityProdMap = cityProdMap;
	}
	
	public Faction getOwner() {
		return owner;
	}
	
	public void setOwner(Faction owner) {
		this.owner = owner;
	}
	
}
