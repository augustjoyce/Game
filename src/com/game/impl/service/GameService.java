package com.game.impl.service;

import java.awt.Point;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import com.game.api.model.character.Hero;
import com.game.api.model.character.Monster;
import com.game.impl.model.character.hero.*;
import com.game.impl.model.character.monster.*;

public class GameService implements com.game.api.service.GameService {

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
				monsters.add(i, new Gargoyle(nameList[rand.nextInt(200)], new Point(rand.nextInt(250), 5)));
				break;
			case 1:
				monsters.add(i, new HellDog(nameList[rand.nextInt(200)], new Point(rand.nextInt(250), 0)));
				break;
			case 2:
				monsters.add(i, new Imp(nameList[rand.nextInt(200)], new Point(rand.nextInt(250), 5)));
				break;
			case 3:
				monsters.add(i, new Troll(nameList[rand.nextInt(200)], new Point(rand.nextInt(250), 0)));
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
				heroes.add(i, new Mage(nameList[rand.nextInt(200)], new Point(rand.nextInt(250), 0)));
				break;
			case 1:
				heroes.add(i, new Warrior(nameList[rand.nextInt(200)], new Point(rand.nextInt(250), 0)));
				break;
			case 2:
				heroes.add(i, new Thief(nameList[rand.nextInt(200)], new Point(rand.nextInt(250), 0)));
				break;
			default:
				break;
			}
		}

	}

	@Override
	public void calculateNextStep() throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {

		while (!monsters.isEmpty() || !heroes.isEmpty()) {

			move();
			
		}
	}

	@Override
	public void fight(Monster monster, Hero hero) {
		while (!hero.isDead(hero) || !monster.isDead(monster)) {

			hero.attack(monster);
			monster.attack(hero);

			if (hero.isDead(hero))
				heroes.remove(hero);
			if (monster.isDead(monster))
				monsters.remove(monster);
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
		}
	}
}
