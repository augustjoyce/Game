package com.game.impl.model.weapon.staff;

import com.game.api.model.weapon.Weapon;
import com.game.api.model.weapon.WeaponType;

public class CommonStaff extends Weapon{
	
	private int attack = 8;
	
	public int getAttack() {
		return attack;
	}

	public void setAttack(int attack) {
		this.attack = attack;
	}

	@Override
	public WeaponType getWeaponType() {
		
		return WeaponType.STAFF;
	}

}