package itemObj;

import java.util.ArrayList;
import java.util.List;

import attributes.Effect;
import mapObj.base.MapObject;
/* This abstract class has 6 fields. 3 fields to describe item effect- one for the Effects on Stack (effectStackList) one for Effects on Self (effectSelfList)
 * and the other for Effects on Faction  (effectFactionList).
 * Others are for Item Name, Description and Level (used for Quest Rewards and like)
 * */
public abstract class Item extends MapObject{

	private List<Effect> effectStackList = new ArrayList<Effect>(); 
	private List<Effect> effectSelfList = new ArrayList<Effect>();
	private List<Effect> effectFactionList = new ArrayList<Effect>();
	
	private String itemTitle;
	private String itemDesc;
	private RankEnum itemLevel;
	private Integer itemBaseCost;
	
	public List<Effect> getEffectStackList() {
		return effectStackList;
	}
	public void setEffectStackList(List<Effect> effectStackList) {
		this.effectStackList = effectStackList;
	}
	public List<Effect> getEffectSelfList() {
		return effectSelfList;
	}
	public void setEffectSelfList(List<Effect> effectSelfList) {
		this.effectSelfList = effectSelfList;
	}
	public List<Effect> getEffectFactionList() {
		return effectFactionList;
	}
	public void setEffectFactionList(List<Effect> effectFactionList) {
		this.effectFactionList = effectFactionList;
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
	public RankEnum getItemLevel() {
		return itemLevel;
	}
	public void setItemLevel(RankEnum itemLevel) {
		this.itemLevel = itemLevel;
	}
	
}
