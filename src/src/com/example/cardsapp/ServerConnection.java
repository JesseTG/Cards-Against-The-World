package com.example.cardsapp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/*
 * Connects to server, sends info (String) to server, reads info from Server
 * Very Basic, needs to update methods
 */
public class ServerConnection {

	private final String serverURL = ""; //set to "" until Parameter class is made
	/* Connection to the server */
	private HttpURLConnection connection;
	
	/*
	 * Sets up connection to server
	 */
	public ServerConnection() {
		try {
		    URL url = new URL(serverURL);
		    connection = (HttpURLConnection)url.openConnection();
		    connection.connect();
		} 
		catch (MalformedURLException e) { 
		    System.err.format("Malformed URL Exception: %s\n", e);
		    e.printStackTrace();
		} 
		catch (IOException e) {   
			System.err.format("I/O Exception: %s\n", e);
			e.printStackTrace();
		}
		
	}
	
	/*
	 * Sends info to server
	 * @param String info to be sent to server
	 */
	public void send(String info) {
		if (!connection.getDoOutput())
			connection.setDoOutput(true);
		
		try { 
			OutputStreamWriter out = new OutputStreamWriter(connection.getOutputStream());
			out.write(info);
			//info sent, wait for input (server response)
			String input = getServerInput();
			//print input for now
			System.out.println(input);
		}
		catch(IOException e) {
			System.err.format("I/O Exception: %s\n", e);
			e.printStackTrace();
		}
		
	}
	
	/*
	 * Gets Server Input: Sets up input stream to read in server output
	 * @return input from server, null if some error occured
	 */
	public String getServerInput() {
		if(!connection.getDoInput()) //if connection is sending output, set it to input mode
			connection.setDoInput(true);
		
		String input = null;
		try {
			BufferedReader in = new BufferedReader(new InputStreamReader(
													connection.getInputStream()));
			String buf;
			while ((buf = in.readLine()) != null) {
				input += buf;
			}
			in.close();
		}
		catch(IOException e) {
			System.err.format("I/O Exception: %s\n", e);
			e.printStackTrace();
		}
		
		connection.setDoInput(false);
		return input;
	}
}
