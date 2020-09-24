package itemObj;

import java.util.ArrayList;
import java.util.List;

import attributes.Effect;
import enums.QuestEnums;

/* This abstract class has 6 fields. 
 * 3 fields to describe item effect- one for the Effects on Stack (effectStackList) one for Effects on Self (effectSelfList)
 * and the other for Effects on Faction  (effectFactionList).
 */
public abstract class Item {

	private List<Effect> effectList = new ArrayList<>();

	private String itemTitle;
	private String itemDesc;
	private QuestEnums itemLevel;
	private Integer itemBaseCost;

	public List<Effect> getEffectList() {
		return effectList;
	}

	public void setEffectList(List<Effect> effectList) {
		this.effectList = effectList;
	}

	public String getItemDesc() {
		return itemDesc;
	}

	public void setItemDesc(String itemDesc) {
		this.itemDesc = itemDesc;
	}

	public String getItemTitle() {
		return itemTitle;
	}

	public void setItemTitle(String itemTitle) {
		this.itemTitle = itemTitle;
	}

	public QuestEnums getItemLevel() {
		return itemLevel;
	}

	public void setItemLevel(QuestEnums itemLevel) {
		this.itemLevel = itemLevel;
	}

	public Integer getItemBaseCost() {
		return itemBaseCost;
	}

	public void setItemBaseCost(Integer itemBaseCost) {
		this.itemBaseCost = itemBaseCost;
	}

}
