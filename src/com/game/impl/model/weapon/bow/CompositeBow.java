package com.game.impl.model.weapon.bow;

import com.game.api.model.weapon.Weapon;
import com.game.api.model.weapon.WeaponType;

public class CompositeBow extends Weapon{
	
	private int attack = 14;
	
	public int getAttack() {
		return attack;
	}

	public void setAttack(int attack) {
		this.attack = attack;
	}

	@Override
	public WeaponType getWeaponType() {
		
		return WeaponType.BOW;
	}

}
