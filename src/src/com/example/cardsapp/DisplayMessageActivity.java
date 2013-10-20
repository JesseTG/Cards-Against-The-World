package com.example.cardsapp;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class DisplayMessageActivity extends Activity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    // Get the message from the intent
	    Intent intent = getIntent();
	    String username = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);

	    TextView textView = new TextView(this);
	    if(username == null || username.equals(""))
	    {
	    	setContentView(R.layout.activity_display_message);
	    	textView.setTextSize(20);
	    	textView.setText("You MUST put in a username to join a game");
	    	
	    	Button backButton = new Button(this);
	    	backButton.setText("back");
	    	/*backButton.setOnClickListener(new View.OnClickListener() {
	    		public void onClick(View v) {
	                 goBack(v);
	             }
	         });*/
	    }
	    else
	    {
		    // Create the text view
		    textView.setTextSize(20);
		    textView.setText("Please wait while we find a game for you to join, "+username+".");
	
		    
		    User player = User.createUser(username);
		    Game.join(player);
	    }
		    // Set the text view as the activity layout
		    setContentView(textView);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.display_message, menu);
		return true;
	}

	public void goBack(View view)
	{
		Intent intent = new Intent(this, MainActivity.class);
		startActivity(intent);
	}
}
