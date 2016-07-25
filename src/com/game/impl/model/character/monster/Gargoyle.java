package com.game.impl.model.character.monster;

import java.awt.Point;
import java.util.Random;

import com.game.api.model.Dropable;
import com.game.api.model.character.AttackType;
import com.game.api.model.character.Monster;
import com.game.api.model.character.MovementType;
import com.game.impl.model.armor.fullplate.SteelPlate;
import com.game.impl.model.armor.light.LinenHood;
import com.game.impl.model.armor.robe.AngelRobe;
import com.game.impl.model.weapon.bow.CompositeBow;
import com.game.impl.model.weapon.staff.CommonStaff;
import com.game.impl.model.weapon.sword.IronSword;

public class Gargoyle extends Monster {

	Dropable[] availableDrop = { new IronSword(), new CompositeBow(), new CommonStaff(), new AngelRobe(),
			new LinenHood(), new SteelPlate() };

	public static final int MAX_MOVE_LENGTH = 5;
	public int attack = 7;
	public int health = 50;
	public String name;
	public Point onPoint;

	public Gargoyle(String name, Point onPoint) {
		this.name = name;
		this.onPoint = onPoint;
		System.out.println("Gargoyle " + name + "(" + attack + "," + health + ") has entered the arena!");
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
