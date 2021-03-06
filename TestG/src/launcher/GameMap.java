package launcher;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

import itemObj.Item;
import mapObj.base.BonusSite;
import mapObj.cities.City;
import mapObj.searchLoc.Explorable;
import sidesObj.ActiveFaction;
//Perlin Noise http://devmag.org.za/2009/04/25/perlin-noise/
/* This class manages the visual representation of the game. It first generates terrain and then places cities/sites etc..*/
public class GameMap {
	//Singleton -Handle Visual display/changes
	
	private List<Point> coordList = new ArrayList<Point>();
	private int mapWidth = 10;
    private int mapHeight = 10;
    private int[][] mapTraverse = {
	        {0,1,1,1,1,1,1,1,1,1},
	        {1,0,0,0,0,0,1,1,1,1},
	        {1,0,1,1,1,0,1,1,1,1},
	        {1,0,1,1,1,0,0,0,1,1},
	        {1,0,0,0,1,1,1,0,1,1},
	        {1,1,1,0,1,1,1,0,0,0},
	        {1,0,1,0,0,0,0,0,1,0},
	        {1,0,1,1,1,1,1,1,1,0},
	        {1,0,0,0,0,0,0,0,0,0},
	        {1,1,1,1,1,1,1,1,1,0}
	    };
	public GameMap(Integer xPoint, Integer yPoint){
		mapWidth=xPoint;
		mapHeight=yPoint;
		for (int i=0;i<xPoint;i++){
			for (int j=0;j<yPoint;j++){
				Point co = new Point(i,j);
				coordList.add(co);
			}
		}
	}
	
	//Generate Terrain ???
	//Place Locations without conflicts ???
	public List<City> placeCities(List<City> cityList) {
		return null;
	}

	public List<Point> getCoordList() {
		return coordList;
	}

	public void setCoordList(List<Point> coordList) {
		this.coordList = coordList;
	}

	public List<Item> placeItems(List<Item> itemList) {
		return null;
	}

	public List<ActiveFaction> placeActiveFactions(List<ActiveFaction> actFactList) {
		for (ActiveFaction actFact: actFactList){
			actFact.setUpFaction();
		}
		return null;
	}

	public List<BonusSite> placeSites(List<BonusSite> siteList) {
		return null;
	}

	public void placeRuins(List<Explorable> ruinList) {
		// TODO Auto-generated method stub
		
	}

	public int getMapWidth() {
		return mapWidth;
	}

	public void setMapWidth(int mapWidth) {
		this.mapWidth = mapWidth;
	}

	public int getMapHeight() {
		return mapHeight;
	}

	public void setMapHeight(int mapHeight) {
		this.mapHeight = mapHeight;
	}

	public int[][] getMapTraverse() {
		return mapTraverse;
	}

	public void setMapTraverse(int[][] mapTraverse) {
		this.mapTraverse = mapTraverse;
	}

}
