package com.game.impl.model.character.hero;

import com.game.api.model.armor.Armor;
import com.game.api.model.armor.ArmorType;
import com.game.api.model.character.AttackType;
import com.game.api.model.character.Hero;
import com.game.api.model.character.MovementType;
import com.game.api.model.weapon.Weapon;
import com.game.api.model.weapon.WeaponType;

public class Warrior extends Hero{
	
	private static final int MAX_MOVE_LENGTH = 2;
	private static final int INIT_ATTACK = 12;
	public int attack = INIT_ATTACK;
	private static final int INIT_HEALTH = 250;
	public int health = INIT_HEALTH;
	public String name;
	
	public Warrior(String name, int attack, int health) {
		super(name);
		this.name = name;
		System.out.println("Warrior " + name + "(" + attack + "," + health + ") has entered the arena!");
		setHealth(health);
		setAttack(attack);
	
	
	}
	@Override
	public String getName() {

		return name;
	}
	
	@Override
	public AttackType getAttackType() {
		
		return AttackType.MELEE;
	}
	@Override
	public MovementType getMovementType() {
		
		return MovementType.RUNNING;
	}
	
	public void equipWeapon(Weapon weapon) {
		if (weapon.getWeaponType() == WeaponType.SWORD	 && (getAttack() - INIT_ATTACK) < weapon.getAttack())
				setAttack(INIT_ATTACK + weapon.getAttack());
		
	}
	
	@Override
	public void equipArmor(Armor armor) {
		if (armor.getArmorType() == ArmorType.FULLPLATE && (getHealth() - INIT_HEALTH) < armor.getDefense())
		setHealth(getHealth() + armor.getDefense());
		
	}
	public static int getMaxMoveLength() {
		return MAX_MOVE_LENGTH;
	}

}
