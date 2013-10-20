package com.example.cardsapp;

/*
 * Represents Question Card: sent to all users, created by server 
 * Has a number of spaces, to be filled by white Cards
 */
public class BlackCard extends Card {

	private int spaces;
	
	public BlackCard(String content, int spaces) {
		super(content);
		this.spaces = spaces;
	}
	
	public int getSpaces() {
		return spaces;
	}
	
}
