package com.game.api.service;

import com.game.api.model.character.Hero;
import com.game.api.model.character.Monster;

public interface GameService {
	
	public void generateMonsters();
	public void generateHeroes();
	public void gameStart() throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException;
	public void fight(Hero hero, Monster monster) throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException;
	public void move() throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException;
	public void bossAppearance() throws NoSuchFieldException, SecurityException;
	public void findRival() throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException;
	
}
