package com.game.api.model.armor;



import com.game.api.model.Dropable;

public abstract class Armor implements Dropable{
	private int defense;
//	private Point onPoint;
	
	public void setDefense(int defense){
		this.defense = defense;
	}


	public int getDefense() {
		
		return defense;
	}
	
	public abstract ArmorType getArmorType();


//	public Point getOnPoint() {
//		return onPoint;
//	}
//
//
//	public Armor setOnPoint(Point onPoint) {
//		this.onPoint = onPoint;
//		return this;
//	}
}
