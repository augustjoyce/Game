package com.game.impl.model.character.hero;

import com.game.api.model.armor.Armor;
import com.game.api.model.armor.ArmorType;
import com.game.api.model.character.AttackType;
import com.game.api.model.character.Hero;
import com.game.api.model.character.MovementType;
import com.game.api.model.weapon.Weapon;
import com.game.api.model.weapon.WeaponType;

public class Thief extends Hero{
	
	private static final int MAX_MOVE_LENGTH = 5;
	private static final int INIT_ATTACK = 15;
	public int attack = INIT_ATTACK;
	private static final int INIT_HEALTH = 150;
	public int health = INIT_HEALTH;
	public String name;
	public Thief(String name) {
		super(name);
		this.name = name;
		System.out.println("Thief " + name + "(" + attack + "," + health + ") has entered the arena!");
		setHealth(health);
		setAttack(attack);
	
	}
	@Override
	public String getName() {

		return name;
	}
	@Override
	public AttackType getAttackType() {
		
		return AttackType.RANGE;
	}
	@Override
	public MovementType getMovementType() {
		
		return MovementType.RUNNING;
	}
	
	@Override
	public void equipWeapon(Weapon weapon) {
		if (weapon.getWeaponType() == WeaponType.BOW && (getAttack() - INIT_ATTACK) < weapon.getAttack())
				setAttack(INIT_ATTACK + weapon.getAttack());
		
	}
	
	@Override
	public void equipArmor(Armor armor) {
		if (armor.getArmorType() == ArmorType.LIGHT && (getHealth() - INIT_HEALTH) < armor.getDefense())
		setHealth(getHealth() + armor.getDefense());
		
	}
	public static int getMaxMoveLength() {
		return MAX_MOVE_LENGTH;
	}

}
