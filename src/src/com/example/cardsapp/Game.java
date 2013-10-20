package com.example.cardsapp;

import java.io.IOException;

public class Game
{
	public static final ServerConnection sc=new ServerConnection();
	private static boolean gameStarted=false;
	private String input;
	
	public Game(){
		join(User.getPlayer());
		try {
			input = sc.getServerInput();
		} catch (IOException e) {
			e.printStackTrace();
		}
		parseInput(input);
	}
	/**
	 * Sends the player information so that the server would push player in a pre-existing game
	 * @param player User that wants to join a pre-existing game
	 */
	public static void join(User player)
	{
		String paramString = 
				"activity=join"+
				"user="+player.getUsername()+
				"ip="+player.getIP();
		
		try {
			sc.send(paramString);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private void parseInput(String input){
		System.out.println(input);
	}
	
	/**
	 * Sends the player information so that the server would create a new game and push the player in it
	 * @param player User that wants to create a new game
	 */
	/*
	public static void create(User player)
	{
		String paramString = 
				"activity=create"+
				"user="+player.getUsername()+
				"id="+player.getIP();
		sc.send(paramString);
	}
	*/
}
