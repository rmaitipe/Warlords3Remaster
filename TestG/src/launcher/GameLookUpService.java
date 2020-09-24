package launcher;

import java.util.List;

import itemObj.Item;
import mapObj.base.BonusSite;
import mapObj.cities.City;
import mapObj.searchLoc.Explorable;
import sidesObj.ActiveFaction;

public interface GameLookUpService {

	List<Item> itemsLookUp(int randSeed, List<Item> itemsLookUp);
	List<City> cityListLookUp(int randSeed, int cityCount, List<ActiveFaction> actFactList,
			List<BonusSite> siteList2, String gameMode);
	List<BonusSite> bonusSitesLookUp(int randSeed, int siteCount);
	List<Explorable> ruinsLookUp(int randSeed, int ruinCount, List<Item> itemList);
}
