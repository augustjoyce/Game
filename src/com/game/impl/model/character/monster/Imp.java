package com.game.impl.model.character.monster;

import java.awt.Point;
import java.util.Random;

import com.game.api.model.Dropable;
import com.game.api.model.character.AttackType;
import com.game.api.model.character.Monster;
import com.game.api.model.character.MovementType;
import com.game.impl.model.armor.fullplate.IronPlate;
import com.game.impl.model.armor.light.CottonHood;
import com.game.impl.model.armor.robe.WizardRobe;
import com.game.impl.model.weapon.bow.ShortBow;
import com.game.impl.model.weapon.staff.WoodenStaff;
import com.game.impl.model.weapon.sword.WoodenSword;

public class Imp extends Monster {

	Dropable availableDrop[] = { new ShortBow(), new WoodenStaff(), new WoodenSword(), new CottonHood(),
			new WizardRobe(), new IronPlate() };

	public static final int MAX_MOVE_LENGTH = 3;
	public int attack = 5;
	public int health = 40;
	public String name;
	public Point onPoint;

	public Imp(String name, Point onPoint) {
		this.name = name;
		this.onPoint = onPoint;
		System.out.println("Imp " + name + "(" + attack + "," + health + ") has entered the arena!");
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

		return MovementType.FLYING;
	}

	@Override
	public Dropable drop() {
		Random rand = new Random();
		return availableDrop[rand.nextInt(3)];
	}

	public static int getMaxMoveLength() {
		return MAX_MOVE_LENGTH;
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