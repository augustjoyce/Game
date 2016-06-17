package com.game.impl.model.character.monster;

import java.util.Random;

import com.game.api.model.Dropable;
import com.game.api.model.character.AttackType;
import com.game.api.model.character.Character;
import com.game.api.model.character.Monster;
import com.game.api.model.character.MovementType;
import com.game.impl.model.weapon.bow.DemonicBow;
import com.game.impl.model.weapon.staff.DemonicStaff;
import com.game.impl.model.weapon.sword.DemonicSword;

public class Boss extends Monster {
	
	Dropable[] availableDrop = {new DemonicSword(), new DemonicBow(), new DemonicStaff()};
	
	
	
	String name;
	public int attack = 20;
	public int health = 300;
	
	public String getName(){
		return name;
	}
	
	public Boss(String name) {
		super(name);
		this.name = name;
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
	
	public boolean isDead(Character ch) {
		if (health <= 0) {
			
			System.out.println(ch.getName() + " is dead");
			
					
			return true;
		} else
			return false;
	}

	@Override
	public Dropable drop() {
		Random rand = new Random();
		return availableDrop[rand.nextInt(2)];
	}

}
