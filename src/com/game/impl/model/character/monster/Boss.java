package com.game.impl.model.character.monster;

import java.awt.Point;
import java.util.Random;

import com.game.api.model.Dropable;
import com.game.api.model.character.AttackType;
import com.game.api.model.character.Monster;
import com.game.api.model.character.MovementType;
import com.game.impl.model.armor.fullplate.AdamantitePlate;
import com.game.impl.model.armor.light.SilkHood;
import com.game.impl.model.armor.robe.DemonRobe;
import com.game.impl.model.weapon.bow.DemonicBow;
import com.game.impl.model.weapon.staff.DemonicStaff;
import com.game.impl.model.weapon.sword.DemonicSword;

public class Boss extends Monster {
	
	Dropable[] availableDrop = {new DemonicSword(), new DemonicBow(), new DemonicStaff(),
								new DemonRobe(), new SilkHood(), new AdamantitePlate()};
	
	
	public static final int MAX_MOVE_LENGTH = 1;
	String name;
	public int attack = 20;
	public int health = 400;
	public Point onPoint;
	
	public String getName(){
		return name;
	}
	
	public Boss(String name, Point onPoint) {
		this.name = name;
		this.onPoint = onPoint;
		System.out.println("Boss " + name + "(" + attack + "," + health + ") has entered the arena!");
		setHealth(health);
		setAttack(attack);
	
	}
	
	@Override
	public AttackType getAttackType() {
		
		return AttackType.MELEE;
	}
	@Override
	public MovementType getMovementType() {
		
		return MovementType.RUNNING;
	}
	
	

	@Override
	public Dropable drop() {
		Random rand = new Random();
		return availableDrop[rand.nextInt(3) ];
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
