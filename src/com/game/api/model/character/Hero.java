package com.game.api.model.character;

import com.game.api.model.armor.Armor;
import com.game.api.model.weapon.Weapon;

public abstract class Hero extends Character{
	
	
	
	protected Hero(String name) {
		super(name);
		
	}
	public void attack(Monster monster) {
		monster.setHealth(monster.getHealth() - getAttack());
		if(monster.isDead(monster)) {
			if(monster.drop() instanceof Weapon) equipWeapon((Weapon) monster.drop());
			else if(monster.drop() instanceof Armor) equipArmor((Armor) monster.drop());
			
		}
	}
	public abstract void equipWeapon(Weapon weapon);
	
	public abstract void equipArmor(Armor armor);
	
	public boolean isHero(){
		if (this instanceof Hero) {
			return true;
		} else {
			return false;
		}
	}; 

}
