package mapObj.searchLoc;

import enums.other.RewardTypeEnum;
import mapObj.base.MapObject;
/* Encountering a Sage gives the choice of reward - Gold, location of Item, location of Allies
 * challengeLevel determines the payout tier
 * */
public abstract class Ruin extends MapObject{
	
	private boolean isRuinInvis;
	private RewardTypeEnum reward;
	private Integer challengeLevel;
	
	public boolean isRuinInvis() {
		return isRuinInvis;
	}

	public void setRuinInvis(boolean isRuinInvis) {
		this.isRuinInvis = isRuinInvis;
	}

	public RewardTypeEnum getReward() {
		return reward;
	}

	public void setReward(RewardTypeEnum reward) {
		this.reward = reward;
	}

	public Integer getChallengeLevel() {
		return challengeLevel;
	}

	public void setChallengeLevel(Integer challengeLevel) {
		this.challengeLevel = challengeLevel;
	}
	
}
