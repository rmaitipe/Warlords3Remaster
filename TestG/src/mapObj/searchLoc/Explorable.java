package mapObj.searchLoc;

import enums.QuestRewardTypeEnum;
import mapObj.base.MapObject;
/* Encountering a Sage gives the choice of reward - Gold, location of Item, location of Allies
 * challengeLevel determines the payout tier
 * */
public abstract class Explorable implements MapObject{
	
	private boolean isInvisible;
	private QuestRewardTypeEnum reward;
	private Integer challengeLevel;
	
	public boolean isInvisible() {
		return isInvisible;
	}

	public void setInvisible(boolean isInvisible) {
		this.isInvisible = isInvisible;
	}

	public QuestRewardTypeEnum getReward() {
		return reward;
	}

	public void setReward(QuestRewardTypeEnum reward) {
		this.reward = reward;
	}

	public Integer getChallengeLevel() {
		return challengeLevel;
	}

	public void setChallengeLevel(Integer challengeLevel) {
		this.challengeLevel = challengeLevel;
	}
	
}
