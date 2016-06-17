package com.game.impl.model.character.monster;

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
	
	public int attack = 5;
	public int health = 20;
	public String name;
	public Gargoyle(String name) {
		super(name);
		this.name = name;
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
		return availableDrop[rand.nextInt(2)];
	}
	
}
