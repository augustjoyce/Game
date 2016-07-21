package com.game.api.model.character;

import java.awt.Point;

import com.game.api.model.Dropable;


public abstract class Monster extends Character { 
	
	public Monster(String name, Point onPoint) {
		super(name, onPoint);
		
	}

	
	public abstract Dropable drop();

	
	boolean isMonster(){
		if (this instanceof Monster){
			return true;
		} else{
			return false;
		}
	}
	
	

}
