package com.example.cardsapp;

import android.os.Bundle;
import android.app.ActionBar.LayoutParams;
import android.app.Activity;
import android.content.Intent;
import android.view.*;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends Activity 
{
	public final static String EXTRA_MESSAGE = "com.example.cardsapp.MESSAGE";
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        /*EditText editText = (EditText) findViewById(R.id.username_msg);
        TextView.OnEditorActionListener exampleListener = new TextView.OnEditorActionListener(){
        	public boolean onEditorAction(TextView exampleView, int actionId, KeyEvent event) {
        		   if (actionId == EditorInfo.IME_NULL  
        		      && event.getAction() == KeyEvent.ACTION_DOWN) { 
        		      joinGame(exampleView);//match this behavior to your 'Send' (or Confirm) button
        		   }
        		   return true;
        		}};
        editText.setOnEditorActionListener(exampleListener);
        */
        setContentView(R.layout.activity_main);
        
        //Game game = new Game();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
        
    /**
     * Generates the next page the User would go to after joining a game.
     * 
     * @param view HomePageActivity (this class)
     */
    public void joinGame(View view)
    {
    	//connects this class to JoinButtonActivity class
    	Intent intent = new Intent(this, DisplayMessageActivity.class);
    	//grabs the the textbox containing username information
	    EditText editText = (EditText) findViewById(R.id.username_msg);
	    //grabs the username
	    String message = editText.getText().toString();
	    intent.putExtra(EXTRA_MESSAGE, message);
	    startActivity(intent);
    }
}
