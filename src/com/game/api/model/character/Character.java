package com.game.api.model.character;

import java.awt.Point;

public abstract class Character {

	private int health;
	private int attack;
	protected Point onPoint;
	
	public abstract String getName();

	protected Character(String name, Point onPoint) {

	}

	public void attack(Character character) {
		character.setHealth(character.getHealth() - getAttack());
		if (character.isDead(character))
			return;

	}


	public int setHealth(int health) {
		this.health = health;
		return health;
	}

	public int getHealth() {
		return health;
	}

	public boolean isDead(Character ch) {
		if (health <= 0) {

			System.out.println(ch.getName() + " is dead");
			
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
