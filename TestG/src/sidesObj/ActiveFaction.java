package sidesObj;

import java.util.List;

import enums.HeroEnum;
import enums.QuestEnums;
import launcher.Game;
import mapObj.cities.City;
import quest.Quest;
import unit.armyUnits.ArmyUnit;
import unit.armyUnits.HeroUnit;
import unit.base.ArmyStack;
import unit.base.HeroFactory;

public class ActiveFaction extends Faction{

	private Integer turn;
	private Integer prestige;
	private Integer cityCount;
	private Integer armyCount;
	protected Integer manaIncome;
	protected Integer manaUpKeep;
	protected Integer manaStored;//Only 1 type for Now BRM
	protected Integer manaCrystals;
	protected Integer goldIncome;
	protected Integer goldUpkeep;
	protected Integer goldStored;
	protected City capitalCity;//No Significance in Gameplay except as a Win Condition in 1 mode	
	//Currently Fielded
	protected List<ArmyStack> factArmyStackList;
	protected List<City> factCityList;
	protected Quest activeQuest;
	protected Integer blockedQuestTurns;
	
	public ActiveFaction(Faction fac) {
		super();
	}

	public void setUpFaction() {
		this.capitalCity = new City();//pick 1 from cityList evenly????
		//add Supporting Unit to City
		this.factCityList.add(capitalCity);
	}
	
	public void takeTurn(Game game) {//update Game obj as action happens
		while (true){//endTurnButton
			if (turn==1){
				mainHeroJoin();
			}
			if (factCityList.size()!=0){
				turnMaintenance();
				//--RealTimeEvents--
				//LeftClickOnHero combat/explore/moveArmyStack
				//RightClickOnHero
				//Menu Options
				bribeDiploAction(null); 
				if (this.getFactPoints()>200){
					//offSurrenderDisp();
				}
			}
		}
	}
	public void turnMaintenance (){
		goldStored = goldStored+ goldIncome-goldUpkeep;
		manaStored = manaStored+ manaIncome-manaUpKeep;//or manaMax		
		//--SpecialRandomEvents--
		merchantOffer();
		heroJoin();
		impressedArmiesJoin();
		mercJoins();
		//--SpecialConditionalEvents--
		armyDesertion();
		spellFail();
		showDiplomaticMsgs();
		//UpdateFaction
		addArmiesProduced();
		addVectoredInArmies();
		checkQuestState();
		//herosLevelUp();
	}
	private void bribeDiploAction(ActiveFaction af) {
	}
	private void declareWarDiploAction(ActiveFaction af){}

	private void checkQuestState() {
	}

	private void addVectoredInArmies() {
	}

	private void showDiplomaticMsgs() {
	}

	private void spellFail() {
	}

	private void armyDesertion() {
	}

	private void addArmiesProduced() {
		for (City city:factCityList){
			if (city.getCurrentArmyProd()!=null){
				Integer turnsLeft =city.getProdTurnsLeft();
				if (turnsLeft==1){
					ArmyUnit arm = city.getCurrentArmyProd();
					city.placeArmyInCity(arm);//location
					city.setProdTurnsLeft(arm.getProdTurns());
				}
				else{
					city.setProdTurnsLeft(--turnsLeft);
				}
			}
		}
	}
	
	public void mainHeroJoin(){//no units , 0 cost -cannot refuse - 1 of the 2 base heros 
			Integer randSeed = (int)Math.random()*2;
			HeroEnum hero1 = this.factHeroMap.get(randSeed);
			HeroUnit hero11 = null;
			switch(hero1){
				case General: 
					boolean isFemale = getUInput();//gender+name!!!!
					String heroName="Red Kavar";//dummy name
					//General(heroName,isFem);
					hero11 = (HeroUnit) HeroFactory.getUnit(HeroEnum.General,heroName,isFemale);
					break;
				default:
					break;
			}
			ArmyStack arm1 = new ArmyStack(hero11);
			factArmyStackList.add(arm1);
	}
	
	private boolean getUInput() {//Dummy Method
		return false;
	}

	public void heroJoin(){
		Integer randSeed=(int)Math.random()*100;
		//3 Allied unit max? cost rand	
	}
	
	public void impressedArmiesJoin(){//Only occurs if faction prestige>x?
		Integer randSeed=(int)Math.random()*100;
	}
	
	public void merchantOffer() {//Only occurs if gold above 500 and hero present?
		Integer randSeed=(int)Math.random()*100;
	}

	public void mercJoins() {
	}	
	
	public void displayQFail(){
		if (activeQuest.getDifficulty().equals(QuestEnums.EASY)) {
			blockedQuestTurns=1;
		}
		else if (activeQuest.getDifficulty().equals(QuestEnums.AVERAGE)){
			blockedQuestTurns=2;
		}
		else{
			blockedQuestTurns=3;
		}
	}
	
	public void displayQComplete(){//populate Q rewards
	}

	public Integer getTurn() {
		return turn;
	}

	public void setTurn(Integer turn) {
		this.turn = turn;
	}

	public Integer getPrestige() {
		return prestige;
	}

	public void setPrestige(Integer prestige) {
		this.prestige = prestige;
	}

	public Integer getCityCount() {
		return cityCount;
	}

	public void setCityCount(Integer cityCount) {
		this.cityCount = cityCount;
	}

	public Integer getArmyCount() {
		return armyCount;
	}

	public void setArmyCount(Integer armyCount) {
		this.armyCount = armyCount;
	}

	public Integer getManaIncome() {
		return manaIncome;
	}

	public void setManaIncome(Integer manaIncome) {
		this.manaIncome = manaIncome;
	}

	public Integer getManaUpKeep() {
		return manaUpKeep;
	}

	public void setManaUpKeep(Integer manaUpKeep) {
		this.manaUpKeep = manaUpKeep;
	}

	public Integer getManaStored() {
		return manaStored;
	}

	public void setManaStored(Integer manaStored) {
		this.manaStored = manaStored;
	}

	public Integer getManaCrystals() {
		return manaCrystals;
	}

	public void setManaCrystals(Integer manaCrystals) {
		this.manaCrystals = manaCrystals;
	}

	public Integer getGoldIncome() {
		return goldIncome;
	}

	public void setGoldIncome(Integer goldIncome) {
		this.goldIncome = goldIncome;
	}

	public Integer getGoldUpkeep() {
		return goldUpkeep;
	}

	public void setGoldUpkeep(Integer goldUpkeep) {
		this.goldUpkeep = goldUpkeep;
	}

	public Integer getGoldStored() {
		return goldStored;
	}

	public void setGoldStored(Integer goldStored) {
		this.goldStored = goldStored;
	}

	public City getCapitalCity() {
		return capitalCity;
	}

	public void setCapitalCity(City capitalCity) {
		this.capitalCity = capitalCity;
	}

	public List<ArmyStack> getFactArmyStackList() {
		return factArmyStackList;
	}

	public void setFactArmyStackList(List<ArmyStack> factArmyStackList) {
		this.factArmyStackList = factArmyStackList;
	}

	public List<City> getFactCityList() {
		return factCityList;
	}

	public void setFactCityList(List<City> factCityList) {
		this.factCityList = factCityList;
	}

	public Quest getActiveQuest() {
		return activeQuest;
	}

	public void setActiveQuest(Quest activeQuest) {
		this.activeQuest = activeQuest;
	}

	public Integer getBlockedQuestTurns() {
		return blockedQuestTurns;
	}

	public void setBlockedQuestTurns(Integer blockedQuestTurns) {
		this.blockedQuestTurns = blockedQuestTurns;
	}
	
}
