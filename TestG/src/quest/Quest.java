package quest;

import enums.QuestCompletionEnum;
import enums.QuestEnums;
import enums.QuestTypeEnum;

/*
 * Use Observer Pattern?
 * This is after a quest is chosen by player
 */
public class Quest {

	QuestEnums difficulty;
	QuestCompletionEnum completionCondition;
	int xpReward;
	
	Quest(QuestEnums difficulty, QuestTypeEnum type){
		this.difficulty=difficulty;
		//setup completionCondition
		switch (difficulty) {
		
			case EASY: 
			xpReward=2;
			break;
			
			case AVERAGE:
			xpReward=7;
			break;
	
			case HARD:
			xpReward=7;
			break;
		}
	}

	public QuestEnums getDifficulty() {
		return difficulty;
	}

	public void setDifficulty(QuestEnums difficulty) {
		this.difficulty = difficulty;
	}

	public QuestCompletionEnum getCompletionCondition() {
		return completionCondition;
	}

	public void setCompletionCondition(QuestCompletionEnum completionCondition) {
		this.completionCondition = completionCondition;
	}

	public int getXpReward() {
		return xpReward;
	}

	public void setXpReward(int xpReward) {
		this.xpReward = xpReward;
	}
	
	
	
}
