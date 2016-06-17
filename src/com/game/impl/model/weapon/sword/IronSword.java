package com.game.impl.model.weapon.sword;

import com.game.api.model.weapon.Weapon;
import com.game.api.model.weapon.WeaponType;

public class IronSword extends Weapon {
	
	private int attack = 8;
	
	public int getAttack() {
		return attack;
	}

	public void setAttack(int attack) {
		this.attack = attack;
	}

	@Override
	public WeaponType getWeaponType() {
		
		return WeaponType.SWORD;
	}
}
