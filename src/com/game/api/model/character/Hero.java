package com.game.api.model.character;

import com.game.api.model.armor.Armor;
import com.game.api.model.weapon.Weapon;

public abstract class Hero extends Character{
	
	
	
	protected Hero(String name) {
		super(name);
		
	}

	public abstract void equipWeapon(Weapon weapon);
	
	public void equipArmor(Armor armor){
		setHealth(getHealth() + armor.getDefense());
	};
	
	public boolean isHero(){
		if (this instanceof Hero) {
			return true;
		} else {
			return false;
		}
	}; 

}
