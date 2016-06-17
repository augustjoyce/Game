package com.game.api.model.armor;

import com.game.api.model.Dropable;

public abstract class Armor implements Dropable{
	private int defense;
	
	public void setDefense(int defense){
		this.defense = defense;
	}


	public int getDefense() {
		
		return defense;
	}
	
	public abstract ArmorType getArmorType();
}
