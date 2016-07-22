package com.game;


import com.game.impl.service.GameService;


public class Main {

	public static void main(String[] args) {

		GameService gs = new GameService();
		
		try {
			gs.gameStart();
		} catch (NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException e) {
			
			e.printStackTrace();
		}
			
			
		}
		

	}


