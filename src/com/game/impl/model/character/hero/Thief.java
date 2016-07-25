package com.game.impl.model.character.hero;

import java.awt.Point;

import com.game.api.model.armor.Armor;
import com.game.api.model.armor.ArmorType;
import com.game.api.model.character.AttackType;
import com.game.api.model.character.Hero;
import com.game.api.model.character.MovementType;
import com.game.api.model.weapon.Weapon;
import com.game.api.model.weapon.WeaponType;


public class Thief extends Hero {

	public static final int MAX_MOVE_LENGTH = 5;
	public static final int ATTACK_DISTANCE = 20;
	private static final int INIT_ATTACK = 15;
	public int attack = INIT_ATTACK;
	private static final int INIT_HEALTH = 150;
	public int health = INIT_HEALTH;
	public String name;
	public Point onPoint;
	private Armor equippedArmor;
	
	public Armor getEquippedArmor() {
		return equippedArmor;
	}

	public void setEquippedArmor(Armor equippedArmor) {
		this.equippedArmor = equippedArmor;
	}

	public Thief(String name, Point onPoint) {
	
		this.name = name;
		this.onPoint = onPoint;
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
		if (weapon.getWeaponType() == WeaponType.BOW && (getAttack() - INIT_ATTACK) < weapon.getAttack()) {
			setAttack(INIT_ATTACK + weapon.getAttack());
			System.out.println(getName() + " equips " + weapon.getClass().getSimpleName());
		}

	}

	@Override
	public void equipArmor(Armor armor) {
		if (armor.getArmorType() == ArmorType.LIGHT &&  ((getEquippedArmor() == null) || getEquippedArmor().getDefense() < armor.getDefense())) {
			setHealth(getHealth() + armor.getDefense());
			System.out.println(getName() + " equips " + armor.getClass().getSimpleName());
		}
	}

	public static int getMaxMoveLength() {
		return MAX_MOVE_LENGTH;
	}

	public static int getAttackDistance() {
		return ATTACK_DISTANCE;
	}

	@Override
	public Point getOnPoint() {

		return onPoint;
	
	}

	@Override
	public void setOnPoint(Point onPoint) {
		this.onPoint = onPoint;
		
	}
	
	

}
