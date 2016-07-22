package com.game.api.model.character;

import java.awt.Point;

public abstract class Character {

	private int health;
	private int attack;
	
	
	public abstract String getName();



	public void attack(Character character) throws NoSuchFieldException, SecurityException {
		character.setHealth(character.getHealth() - getAttack());
		
	}


	public int setHealth(int health) {
		this.health = health;
		return health;
	}

	public int getHealth() {
		return health;
	}

	public boolean isDead() throws NoSuchFieldException, SecurityException {
		if (health <= 0) {

			System.out.println(getClass().getSimpleName() + " " + getName() + " is dead");
			
			return true;
		} else
			return false;
	}

	public int getAttack() {
		return attack;
	}

	public void setAttack(int attack) {
		this.attack = attack;
	}

	public abstract Point getOnPoint();

	public abstract void setOnPoint(Point onPoint);

	public abstract AttackType getAttackType();

	public abstract MovementType getMovementType();

}
