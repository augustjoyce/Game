package com.game.api.service;




import com.game.api.model.character.Hero;
import com.game.api.model.character.Monster;

public interface GameService {
	
	public void generateMonsters();
	public void generateHeroes();
	public void calculateNextStep() throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException;
	public void fight(Monster monster, Hero hero);
	public void move() throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException;

	
	
}
