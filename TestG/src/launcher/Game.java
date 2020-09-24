package launcher;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import itemObj.Item;
import mapObj.base.BonusSite;
import mapObj.cities.City;
import mapObj.searchLoc.Explorable;
import sidesObj.ActiveFaction;
import sidesObj.Faction;
/* This class manages the game session and keeps track of Faction Turns and victory conditions and ends 
 * mapSize determines upper limit for cityCount/ruinCount/siteCount/islandCount
 * cityCount, ruinCount, siteCount vars have no impact on map shape
 * the Game if conditions met*/
public class Game {
	//Singleton
	
	private boolean isGameOver;
	private List<ActiveFaction> actFactList = new ArrayList<ActiveFaction>();
	private MasterLookUpServiceImpl lookUpService;
	private GameLookUpServiceImpl loadService;
	private GameMap gameMap;//Visual Representation
	private Map<Faction,Integer> diplomacyMap = new HashMap<Faction,Integer>(); //50 default 100 max , 0 lowest change to 2D
	List<City> cityList;
	List<Item> itemList;
	List<BonusSite> siteList;
	List<Explorable> ruinList;
	int turnNumber;
	
	public Game(InputGameParam input) {
		List<Faction> factList = lookUpService.factionsLookUp(input.getFactionSet());//This is the Faction as a concept
		for (Faction fac: factList){
			ActiveFaction actFact= new ActiveFaction(fac);//This is the Faction as a Game object
			actFactList.add(actFact);
		}
		if (input.getMapSizeSelected()==0){
			gameMap = createMap(100,100);
		}
		else{
			gameMap = createMap(150,150);
		}
		//setupGameMap(input);
		itemList = loadService.itemsLookUp(input.getRandSeed(), lookUpService.itemsLookUp());
		ruinList = loadService.ruinsLookUp(input.getRandSeed(),input.getRuinCount(), itemList);
		siteList = loadService.bonusSitesLookUp(input.getRandSeed(),input.getSiteCount());
		cityList = loadService.cityListLookUp(input.getRandSeed(),input.getCityCount(), actFactList, siteList, input.getGameMode());

		gameMap.placeCities(cityList);
		gameMap.placeItems(itemList);//Some are already placed in Ruins
		gameMap.placeSites(siteList);
		gameMap.placeRuins(ruinList);
		gameMap.placeActiveFactions(actFactList);
	}
	
	public void play(){
		
		while (!isGameOver){
			for (ActiveFaction actFact: actFactList){
				//if other factions surrender - and accepted set isGameOver to true
				actFact.takeTurn(this);
			}
		}
		//if victory
		//defeat
	}

	public void displayStartMenu() {//The first Screen Shown When game starts as only SinglePlayer Mode exists
		//NewCapaign,NewScenario,RandomMap,Load,Tutorial,Credits,Exit
	}
	public void displayEscapeMenu(){//When ever esc button is hit within the game
		//Save,Load,Exit
	}
	public void displaySaveMenu(){
		//Save,Cancel
	}
	public void displayLoadMenu(){
		//Load,Cancel
	}
	public void placeItems(){
		
	}

	public GameMap createMap(Integer xCoordinate, Integer yCoordinate){
		GameMap VarGameMap = new GameMap(xCoordinate, yCoordinate);
		return VarGameMap;
	}
	
	public boolean isGameOver() {
		return isGameOver;
	}

	public void setGameOver(boolean isGameOver) {
		this.isGameOver = isGameOver;
	}

	public MasterLookUpServiceImpl getLookUpService() {
		return lookUpService;
	}

	public void setLookUpService(MasterLookUpServiceImpl lookUpService) {
		this.lookUpService = lookUpService;
	}

	public GameMap getGameMap() {
		return gameMap;
	}

	public void setGameMap(GameMap gameMap) {
		this.gameMap = gameMap;
	}

	public Map<Faction, Integer> getDiplomacyMap() {
		return diplomacyMap;
	}

	public void setDiplomacyMap(Map<Faction, Integer> diplomacyMap) {
		this.diplomacyMap = diplomacyMap;
	}

	public List<ActiveFaction> getActFactList() {
		return actFactList;
	}

	public void setActFactList(List<ActiveFaction> actFactList) {
		this.actFactList = actFactList;
	}
	
}
