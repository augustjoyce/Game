package com.game.api.model.character;

import com.game.api.model.Dropable;


public abstract class Monster extends Character { 
	
	public Monster(String name) {
		super(name);
		
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
