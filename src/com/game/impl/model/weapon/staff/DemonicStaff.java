package com.game.impl.model.weapon.staff;

import com.game.api.model.weapon.Weapon;
import com.game.api.model.weapon.WeaponType;

public class DemonicStaff extends Weapon{
	
	private int attack = 20;
	
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
