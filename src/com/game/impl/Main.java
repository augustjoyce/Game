package com.game.impl;

import com.game.impl.model.character.hero.Mage;
import com.game.impl.model.character.monster.Boss;


public class Main {

	public static void main(String[] args) {
		
	
		Mage mage = new Mage("John");
		Boss boss = new Boss("Jack");
		while (!mage.isDead(mage) && !boss.isDead(boss)) {

			System.out.println(boss.getHealth());
			System.out.println(boss.isDead(boss));
			System.out.println(mage.getHealth());
			mage.attack(boss);
			
			
		
			
			
		}
		

	}

}
