package spellObj;

import java.util.ArrayList;
import java.util.List;

import attributes.Effect;

public abstract class Spell {

	private List<Effect> effectStackList = new ArrayList<Effect>(); 
	private List<Effect> effectSelfList = new ArrayList<Effect>();
	private List<Effect> effectFactionList = new ArrayList<Effect>();
	
	private Integer manaCost;
	private String spellDesc;
	private String spellTitle;

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
	public Integer getManaCost() {
		return manaCost;
	}
	public void setManaCost(Integer manaCost) {
		this.manaCost = manaCost;
	}
	public String getSpellDesc() {
		return spellDesc;
	}
	public void setSpellDesc(String spellDesc) {
		this.spellDesc = spellDesc;
	}
	public String getSpellTitle() {
		return spellTitle;
	}
	public void setSpellTitle(String spellTitle) {
		this.spellTitle = spellTitle;
	}
	
	
}
