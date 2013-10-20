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
 * 
 */
public class ServerConnection {

	private final String serverURL = Parameters.URL; //set to "" until Parameter class is made
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
	public void send(String info) throws IOException {
		if (!connection.getDoOutput())
			connection.setDoOutput(true);
		
		connection.setRequestMethod("GET");
		OutputStreamWriter out = new OutputStreamWriter(connection.getOutputStream());
		out.write(info);
		//info sent, wait for input (server response)
		String input = getServerInput();
		//print input for now
		System.out.println(input);

	}
	
	/*
	 * Gets Server Input: Sets up input stream to read in server output
	 * @return input from server, null if some error occured
	 */
	public String getServerInput() throws IOException {
		if(!connection.getDoInput()) //if connection is sending output, set it to input mode
			connection.setDoInput(true);
		
			String input = null;
			
			connection.setRequestMethod("GET");
			BufferedReader in = new BufferedReader(new InputStreamReader(
													connection.getInputStream()));
			String buf;
			while ((buf = in.readLine()) != null) {
				input += buf;
			}
			in.close();
		
		
		connection.setDoInput(false);
		return input;
	}
}
