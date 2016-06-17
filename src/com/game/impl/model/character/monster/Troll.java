package com.game.impl.model.character.monster;

import java.util.Random;

import com.game.api.model.Dropable;
import com.game.api.model.character.AttackType;
import com.game.api.model.character.Monster;
import com.game.api.model.character.MovementType;
import com.game.impl.model.weapon.bow.DemonicBow;
import com.game.impl.model.weapon.staff.DemonicStaff;
import com.game.impl.model.weapon.sword.DemonicSword;


public class Troll extends Monster{
	
	Dropable availableDrop[] = {new DemonicBow(), new DemonicStaff(), new DemonicSword()};
	
	public int attack = 15;
	public int health = 100;
	public String name;
	public Troll(String name) {
		super(name);
		this.name = name;
		System.out.println("Troll " + name + "(" + attack + "," + health + ") has entered the arena!");
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
	
	@Override
	public Dropable drop() {
		Random rand = new Random();
		return availableDrop[rand.nextInt(2)];
	}
	
}