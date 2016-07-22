package com.game.impl.service;

import java.awt.Point;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.game.api.model.character.Hero;
import com.game.api.model.character.Monster;
import com.game.impl.model.character.hero.*;
import com.game.impl.model.character.monster.*;

public class GameService implements com.game.api.service.GameService {

	private static Logger logger = Logger.getLogger(GameService.class);
	Random rand = new Random();

	private String[] nameList = new String[200];

	public void addingNames() throws FileNotFoundException {
		int i = 0;
		Scanner sc = new Scanner(new File("resources/names.txt"));

		while (sc.hasNext()) {
			nameList[i] = sc.next();
			i++;
		}

		sc.close();
	}

	public ArrayList<Monster> monsters = new ArrayList<Monster>(30);
	public ArrayList<Hero> heroes = new ArrayList<Hero>(10);

	@Override
	public void generateMonsters() {
		for (int i = 0; i < 30; i++) {
			switch (rand.nextInt(4)) {
			case 0:
				monsters.add(i, new Gargoyle(nameList[rand.nextInt(200)], new Point(rand.nextInt(100), 15)));
				break;
			case 1:
				monsters.add(i, new HellDog(nameList[rand.nextInt(200)], new Point(rand.nextInt(100), 0)));
				break;
			case 2:
				monsters.add(i, new Imp(nameList[rand.nextInt(200)], new Point(rand.nextInt(100), 15)));
				break;
			case 3:
				monsters.add(i, new Troll(nameList[rand.nextInt(200)], new Point(rand.nextInt(100), 0)));
				break;
			default:
				break;
			}
		}

	}

	@Override
	public void generateHeroes() {
		for (int i = 0; i < 10; i++) {
			switch (rand.nextInt(3)) {
			case 0:
				heroes.add(i, new Mage(nameList[rand.nextInt(200)], new Point(rand.nextInt(100), 0)));
				break;
			case 1:
				heroes.add(i, new Warrior(nameList[rand.nextInt(200)], new Point(rand.nextInt(100), 0)));
				break;
			case 2:
				heroes.add(i, new Thief(nameList[rand.nextInt(200)], new Point(rand.nextInt(100), 0)));
				break;
			default:
				break;
			}
		}

	}

	@Override
	public void gameStart()
			throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
		try {
			addingNames();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		generateHeroes();
		generateMonsters();

		while (!monsters.isEmpty() && !heroes.isEmpty()) {

			move();
			findRival();
			
			if (heroes.isEmpty()) {
				System.out.println("Monsters win!");
			} else if (heroes.isEmpty()) {
				System.out.println("Heroes win!");
				try {
					Thread.sleep(10000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println(
						"But stop! Do you hear these steps?" + " It seems like something terrible is approaching");
				bossAppearance();
			}
		}
	}

	@Override
	public void findRival()
			throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException {
		
		for (int i = 0; i < heroes.size(); i++) {
			for (int j = 0; j < monsters.size(); j++) {
					if (Math.abs (heroes.get(i).getOnPoint().x - monsters.get(j).getOnPoint().x) <= heroes.get(i).getClass()
							.getDeclaredField("ATTACK_DISTANCE").getInt(getClass())
							&& Math.abs(heroes.get(i).getOnPoint().y - monsters.get(j).getOnPoint().y) <= heroes.get(i).getClass()
									.getDeclaredField("ATTACK_DISTANCE").getInt(getClass())) {

						System.out.println(heroes.get(i).getClass().getSimpleName() +" " + heroes.get(i).getName()
								+ " and " + monsters.get(j).getClass().getSimpleName() + " " + monsters.get(i).getName()
								+ " are fighting now!");

						fight(heroes.get(i), monsters.get(j));
						move();
				}else move();

			}
		}
	}

	@Override
	public void move()
			throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
		for (int i = 0; i < monsters.size(); i++) {
			switch (rand.nextInt(2)) {
			case 0:
				monsters.get(i)
						.setOnPoint(new Point(
								monsters.get(i).getOnPoint().x + monsters.get(i).getClass()
										.getDeclaredField("MAX_MOVE_LENGTH").getInt(getClass()),
						monsters.get(i).getOnPoint().y));
				break;
			case 1:
				monsters.get(i)
						.setOnPoint(new Point(
								monsters.get(i).getOnPoint().x - monsters.get(i).getClass()
										.getDeclaredField("MAX_MOVE_LENGTH").getInt(getClass()),
						monsters.get(i).getOnPoint().y));
				break;
			}

			logger.trace(monsters.get(i).getClass().getSimpleName() + " " + monsters.get(i).getName() + " now at point "
					+ monsters.get(i).getOnPoint());
		}

		for (int i = 0; i < heroes.size(); i++) {
			switch (rand.nextInt(2)) {
			case 0:
				heroes.get(i)
						.setOnPoint(new Point(
								heroes.get(i).getOnPoint().x + heroes.get(i).getClass()
										.getDeclaredField("MAX_MOVE_LENGTH").getInt(getClass()),
						heroes.get(i).getOnPoint().y));
				break;
			case 1:
				heroes.get(i)
						.setOnPoint(new Point(
								heroes.get(i).getOnPoint().x - heroes.get(i).getClass()
										.getDeclaredField("MAX_MOVE_LENGTH").getInt(getClass()),
						heroes.get(i).getOnPoint().y));
				break;
			}

			logger.trace(heroes.get(i).getClass().getSimpleName() + " " + heroes.get(i).getName() + " now at point "
					+ heroes.get(i).getOnPoint());
		}
	}

	@Override
	public void bossAppearance() throws NoSuchFieldException, SecurityException {
		Boss boss = new Boss(nameList[rand.nextInt(200)], new Point(rand.nextInt(100), 0));
		while (!heroes.isEmpty() && !boss.isDead()) {
			for (int i = 0; i < heroes.size(); i++) {
				heroes.get(i).attack(boss);
				boss.attack(heroes.get(i));
			}
			if (heroes.isEmpty()) {
				System.out.println("All the heroes are dead...");
			} else if (boss.isDead()) {
				System.out.println("The heroes killed the horror!");
			}

		}
	}



	@Override
	public void fight(Hero hero, Monster monster)
			throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException {
		while (true) {
			if(!hero.isDead()) {
				hero.attack(monster);
				
			} else {heroes.remove(hero); return;}

				if(!monster.isDead()) {
			monster.attack(hero);
		}  	else {monsters.remove(monster); return;}
	}


		
	}
}
