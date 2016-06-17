package com.game.api.model.weapon;

import com.game.api.model.Dropable;

public abstract class Weapon implements Dropable{
	
	private int attack;
	
	public void setAttack(int attack){
		this.attack = attack;
	}


	public int getAttack() {
		return attack;
	}
	
	public abstract WeaponType getWeaponType();
	
}
