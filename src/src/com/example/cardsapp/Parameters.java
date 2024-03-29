package com.example.cardsapp;

public class Parameters {
	/** The final URL of the server this application connects to */
	public static final String URL="latinohealthandlife.com/cgi-bin/test/.py"; 
	
	/** The integer value for the max number of allowed players in a lobby	 */
	public static final int maxPlayers=10;
	
	/** The integer value for the min number of allowed players in a lobby */
	public static final int minPlayer=6;
	
	/** Message representing the message that should be receieved at the beginning of a game */
	public static final String GameStartMessage="A new game has begun.";
	/**
	 * Constructor for type parameters that will not ever need
	 * to be constructed so this is private.
	 */
	private Parameters(){
		//No need to construct an object of this class
	}
}
