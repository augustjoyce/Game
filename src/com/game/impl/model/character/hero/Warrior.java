package com.game.impl.model.character.hero;

import java.awt.Point;

import com.game.api.model.armor.Armor;
import com.game.api.model.armor.ArmorType;
import com.game.api.model.character.AttackType;
import com.game.api.model.character.Hero;
import com.game.api.model.character.MovementType;
import com.game.api.model.weapon.Weapon;
import com.game.api.model.weapon.WeaponType;

public class Warrior extends Hero {

	public static final int MAX_MOVE_LENGTH = 2;
	public static final int ATTACK_DISTANCE = 15;
	private static final int INIT_ATTACK = 12;
	public int attack = INIT_ATTACK;
	private static final int INIT_HEALTH = 250;
	public int health = INIT_HEALTH;
	public String name;
	public Point onPoint;
	private Armor equippedArmor;
	
	public Warrior(String name, Point onPoint) {

		this.name = name;
		this.onPoint = onPoint;
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
		if (weapon.getWeaponType() == WeaponType.SWORD && (getAttack() - INIT_ATTACK) < weapon.getAttack()) {
			setAttack(INIT_ATTACK + weapon.getAttack());
			System.out.println(getName() + " equips " + weapon.getClass().getSimpleName());
		}

	}

	@Override
	public void equipArmor(Armor armor) {
		if (armor.getArmorType() == ArmorType.FULLPLATE && ((getEquippedArmor() == null) || getEquippedArmor().getDefense() < armor.getDefense())) {
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

	public Armor getEquippedArmor() {
		return equippedArmor;
	}

	public void setEquippedArmor(Armor equippedArmor) {
		this.equippedArmor = equippedArmor;
	}

}
