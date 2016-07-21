package com.game.impl.model.character.monster;

import java.awt.Point;
import java.util.Random;

import com.game.api.model.Dropable;
import com.game.api.model.character.AttackType;
import com.game.api.model.character.Monster;
import com.game.api.model.character.MovementType;
import com.game.impl.model.weapon.bow.LongBow;
import com.game.impl.model.weapon.staff.AngelicStaff;
import com.game.impl.model.weapon.sword.SteelSword;

public class HellDog extends Monster{
	
	Dropable availableDrop[] = {new LongBow(), new AngelicStaff(), new SteelSword()};
	
	public static final int MAX_MOVE_LENGTH = 6;
	public static final int ATTACK_DISTANCE = 2;
	public int attack = 12;
	public int health = 70;
	public String name;
	public Point onPoint;
	
	public HellDog(String name, Point onPoint) {
		super(name, onPoint);
		this.name = name;
		this.onPoint = onPoint;
		System.out.println("HellDog " + name + "(" + attack + "," + health + ") has entered the arena!");
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