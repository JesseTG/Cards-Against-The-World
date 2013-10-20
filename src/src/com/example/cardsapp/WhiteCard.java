package com.example.cardsapp;

/*
 * Represents Answer card: has a reference to the user who holds the card
 * 
 */
public class WhiteCard extends Card {
	
	/* Represents user who holds the card*/
	private String userID;

	public WhiteCard(String content, String userID) {
		super(content);
		this.userID = userID;
	}

	public String getUserID() {
		return userID;
	}
	
}
