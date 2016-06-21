package com.game.api.model.weapon;



import com.game.api.model.Dropable;

public abstract class Weapon implements Dropable{
	
	private int attack;
//	private Point onPoint;
	
	public void setAttack(int attack){
		this.attack = attack;
	}


	public int getAttack() {
		return attack;
	}
	
	public abstract WeaponType getWeaponType();


//	public Point getOnPoint() {
//		return onPoint;
//	}
//
//
//	public Weapon setOnPoint(Point onPoint) {
//		this.onPoint = onPoint;
//		return this;
//	}
	
}
