package com.example.cardsapp;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.widget.TextView;

public class DisplayMessageActivity extends Activity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);

	    // Get the message from the intent
	    Intent intent = getIntent();
	    String username = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);

	    if(username == null || username.equals(""))
	    {
	    	TextView textView = new TextView(this);
	    	textView.setTextSize(20);
	    	textView.setText("You MUST put in a username to join a game");
	    }
	    else
	    {
		    // Create the text view
		    TextView textView = new TextView(this);
		    textView.setTextSize(20);
		    textView.setText("Please wait while we find a game for you to join, "+username+".");
	
		    // Set the text view as the activity layout
		    setContentView(textView);
		    
		    User player = new User(username);
		    Game.join(player);
	    }
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.display_message, menu);
		return true;
	}

}
