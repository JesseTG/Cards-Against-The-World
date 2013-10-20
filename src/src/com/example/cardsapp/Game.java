package com.example.cardsapp;

public class Game
{
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
		//send(paramString);
	}
	
	/**
	 * Sends the player information so that the server would create a new game and push the player in it
	 * @param player User that wants to create a new game
	 */
	public static void create(User player)
	{
		String paramString = 
				"activity=create"+
				"user="+player.getUsername()+
				"id="+player.getIP();
		//send(paramString);
	}
}
