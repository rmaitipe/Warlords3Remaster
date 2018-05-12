package launcher;

public class InputGameParam {
	//default values
	private int mapSizeSelected=0;
	private int randSeed=100;
	private int cityCount=40;
	private int ruinCount=20;
	private int siteCount=20;
	private int islandCount=1;
	private String mountDensity="Average"; ;
	private String riverDensity="Average"; 
	private String forestDensity="Average"; 
	private String factionSet ="Default"; 
	private String gameMode="Standard";

	public int getMapSizeSelected() {
		return mapSizeSelected;
	}
	public void setMapSizeSelected(int mapSizeSelected) {
		this.mapSizeSelected = mapSizeSelected;
	}
	public int getCityCount() {
		return cityCount;
	}
	public void setCityCount(int cityCount) {
		this.cityCount = cityCount;
	}
	public int getRuinCount() {
		return ruinCount;
	}
	public void setRuinCount(int ruinCount) {
		this.ruinCount = ruinCount;
	}
	public int getSiteCount() {
		return siteCount;
	}
	public void setSiteCount(int siteCount) {
		this.siteCount = siteCount;
	}
	public int getIslandCount() {
		return islandCount;
	}
	public void setIslandCount(int islandCount) {
		this.islandCount = islandCount;
	}
	public String getMountDensity() {
		return mountDensity;
	}
	public void setMountDensity(String mountDensity) {
		this.mountDensity = mountDensity;
	}
	public String getRiverDensity() {
		return riverDensity;
	}
	public void setRiverDensity(String riverDensity) {
		this.riverDensity = riverDensity;
	}
	public String getForestDensity() {
		return forestDensity;
	}
	public void setForestDensity(String forestDensity) {
		this.forestDensity = forestDensity;
	}
	public String getFactionSet() {
		return factionSet;
	}
	public void setFactionSet(String factionSet) {
		this.factionSet = factionSet;
	}
	public String getGameMode() {
		return gameMode;
	}
	public void setGameMode(String gameMode) {
		this.gameMode = gameMode;
	}
	public int getRandSeed() {
		return randSeed;
	}
	public void setRandSeed(int randSeed) {
		this.randSeed = randSeed;
	}
	
}
