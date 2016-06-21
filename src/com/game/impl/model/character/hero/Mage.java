package com.game.impl.model.character.hero;

import com.game.api.model.armor.Armor;
import com.game.api.model.armor.ArmorType;
import com.game.api.model.character.AttackType;
import com.game.api.model.character.Hero;
import com.game.api.model.character.MovementType;
import com.game.api.model.weapon.Weapon;
import com.game.api.model.weapon.WeaponType;

public class Mage extends Hero {

	private static final int MAX_MOVE_LENGTH = 3;
	private static final int INIT_ATTACK = 10;
	private static final int INIT_HEALTH = 200;
	public int attack = INIT_ATTACK;
	public int health = INIT_HEALTH;
	public String name;

	public Mage(String name) {
		super(name);
		this.name = name;
		System.out.println("Mage " + name + "(" + attack + "," + health + ") has entered the arena!");
		setHealth(health);
		setAttack(attack);
	}

	@Override
	public String getName() {

		return name;
	}

	@Override
	public AttackType getAttackType() {

		return AttackType.MAGIC;
	}

	@Override
	public MovementType getMovementType() {

		return MovementType.RUNNING;
	}

	@Override
	public void equipWeapon(Weapon weapon) {
		if (weapon.getWeaponType() == WeaponType.STAFF && (getAttack() - INIT_ATTACK) < weapon.getAttack()) {

			setAttack(INIT_ATTACK + weapon.getAttack());
			System.out.println(getName() + " equips "+ weapon.getClass().getSimpleName());
		}

	}

	@Override
	public void equipArmor(Armor armor) {
		if (armor.getArmorType() == ArmorType.ROBE && (getHealth() - INIT_HEALTH) < armor.getDefense())
			setHealth(getHealth() + armor.getDefense());

	}

	public static int getMaxMoveLength() {
		return MAX_MOVE_LENGTH;
	}

}
