package com.game;

import java.io.FileNotFoundException;

import com.game.impl.model.character.hero.Mage;
import com.game.impl.model.character.monster.Boss;
import com.game.impl.service.GameService;


public class Main {

	public static void main(String[] args) {
		
	
//		Mage mage = new Mage("John");
//		Boss boss = new Boss("Jack");
//		while (!mage.isDead(mage) && !boss.isDead(boss)) {
//
//			System.out.println(boss.getHealth());
//			System.out.println(boss.isDead(boss));
//			System.out.println(mage.getHealth());
//			mage.attack(boss);
		GameService gs = new GameService();
		try {
			gs.addingNames();
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		}
		gs.generateHeroes();
		gs.generateMonsters();
		
		try {
			gs.move();
		} catch (NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException e) {
		
			e.printStackTrace();
		}
			
		
			
			
		}
		

	}


