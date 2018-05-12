package sidesObj;

import java.awt.Point;
import java.util.List;

import enums.other.ConquestActEnum;
import enums.other.QuestCompletionEnum;
import itemObj.RankEnum;
import mapObj.base.BonusSite;
import mapObj.cities.City;
import mapObj.searchLoc.Ruin;
import unit.armyUnits.ArmyEnum;
import unit.heroUnits.HeroUnit;
/* Quests are associated with a hero, but only 1 quest can be active at a time. Completion condition also gets evaluated at 
 * beginning of turn for things like enemy count.
 * EnemyUnitTypeFromFaction/EnemyUnitsFromFaction/Gold/EnemyHeros/ExploreRuin/MoveNearCity/MoveToSite/OccupyCity/RazeCity/RazeSite/RazeCity
 * */
public abstract class Quest {
	
	private RankEnum questLevel;
	private Integer turnPenalty;
	private Integer xpAmount; 
	
	private QuestCompletionEnum goalType;
	private Integer amount;
	private Integer currentAmount;
	private Point coordList;
	private Integer heroId;
	private ArmyEnum armyType;
	private Faction enemyFaction;
	private ConquestActEnum action;
	
	public Quest(QuestCompletionEnum type,City city){//Take a message to x
		
	}
	public Quest(QuestCompletionEnum type,BonusSite site){//Take a message to x
		
	}	
	public Quest(QuestCompletionEnum type,HeroUnit hero){//Kill Heathen
		
	}
	public Quest(QuestCompletionEnum type,Ruin ruin){//Explore Ruin
		
	}
	public Quest(QuestCompletionEnum type,ConquestActEnum act, Integer amount){//Pillage x gold
		
	}
	public Quest(QuestCompletionEnum type,ConquestActEnum act, City city){//Raze/Occupy
		
	}
	public Quest(QuestCompletionEnum type,ConquestActEnum act, BonusSite site){//Raze
		
	}
	public Quest(QuestCompletionEnum type,Faction fac, Integer amount){//Kill x Enemies
		
	}
	public Quest(QuestCompletionEnum type,Faction fac, ArmyEnum army, Integer amount){//Kill x Enemies of y type
		
	}
	public RankEnum getQuestLevel() {
		return questLevel;
	}
	
	public void setQuestLevel(RankEnum questLevel) {
		this.questLevel = questLevel;
	}
	
	public Integer getXpAmount() {
		return xpAmount;
	}
	
	public void setXpAmount(Integer xpAmount) {
		this.xpAmount = xpAmount;
	}

	public Integer getTurnPenalty() {
		return turnPenalty;
	}

	public void setTurnPenalty(Integer turnPenalty) {
		this.turnPenalty = turnPenalty;
	}
	
}
