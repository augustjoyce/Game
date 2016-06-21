package com.game.api.model.character;

import java.awt.Point;




public abstract class Character{

	private int health;
	private int attack;
	private Point onPoint;
	
	
	public abstract String getName();
	
	protected Character(String name) {

	}

	
	
	public void attack(Character character) {
		character.setHealth(character.getHealth() - getAttack());
		if(character.isDead(character)) return;
		
	}

	public void move(Point point) {

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

	public Point getOnPoint() {
		return onPoint;
	}

	public void setOnPoint(Point onPoint) {
		this.onPoint = onPoint;
	}
	
	public abstract AttackType getAttackType();
	public abstract MovementType getMovementType();

}
