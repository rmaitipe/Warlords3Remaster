package launcher;

import java.util.List;
/* This class lets user select Game setup options: map size, available factions, Win mode
 * Creates a Game object*/
public class GameLauncher {

	private Integer mapSizeSelect;
	private List<String> factNames;
	private String gameMode;
	
	//SelectMapSetings	//SelectWinConditions	//SelectFactions	//GetUserFaction/s
	public static void main(String arg []){
		GameLauncher gameLuncher = new GameLauncher();
		gameLuncher.run();  
	}
	
	public void genFactions(Integer randSeed){
		
	}
	
	public void populateMap(){
		//place factions-Set capitals-initial aUnit
	}
	
	public void setGameSettings(){
		// create a new with user selected settings like turn limits etc..
	}
	
	public void run(){
		displaySetUpMenu();//menuOptions-newGame-save-load-quit-
	}

	private void displaySetUpMenu() {
		// TODO Auto-generated method stub
		displayRandomMapMenu();
	}

	private void displayRandomMapMenu(){//Used to Generate map and Setup the Game
		//FactionSetDropDown,Begin,Cancel
		//<<-Get user Input Once begin is clicked
		//mapsize(1/4 choices),factions (default Random), gameMode aka winCondition(1/6), numofSitesRange, islands
		InputGameParam input =new InputGameParam();
		Game game = new Game(input);
		game.play();
	}

	public Integer getMapSizeSelect() {
		return mapSizeSelect;
	}

	public void setMapSizeSelect(Integer mapSizeSelect) {
		this.mapSizeSelect = mapSizeSelect;
	}

	public List<String> getFactNames() {
		return factNames;
	}

	public void setFactNames(List<String> factNames) {
		this.factNames = factNames;
	}

	public String getGameMode() {
		return gameMode;
	}

	public void setGameMode(String gameMode) {
		this.gameMode = gameMode;
	}
	
}
