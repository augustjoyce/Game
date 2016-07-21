package com.game.impl.model.character.monster;

import java.awt.Point;
import java.util.Random;

import com.game.api.model.Dropable;
import com.game.api.model.character.AttackType;
import com.game.api.model.character.Monster;
import com.game.api.model.character.MovementType;
import com.game.impl.model.weapon.bow.CompositeBow;
import com.game.impl.model.weapon.staff.CommonStaff;
import com.game.impl.model.weapon.sword.IronSword;

public class Gargoyle extends Monster{
	
	Dropable[] availableDrop = {new IronSword(), new CompositeBow(), new CommonStaff()};
	
	public static final int MAX_MOVE_LENGTH = 5;
	public static final int ATTACK_DISTANCE = 3;
	public int attack = 5;
	public int health = 20;
	public String name;
	public Point onPoint;
	
	public Gargoyle(String name, Point onPoint) {
		super(name, onPoint);
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
