package com.example.cardsapp;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.*;


/**
 * Class representing the client currently running the application on their phone.
 * @author Varun
 *
 */
public class User {
	private String username;
	private String IP;
	
	/**
	 * Constructor for type user.
	 * @param username : The username the player entered at joining to play.
	 */
	public User(String username){
		this.username=username;
		IP=findIP();
	}
	
	/**
	 * Returns the IP of the current machine so that the server can transmit information.
	 * @return
	 */
	private String findIP(){
		try {
            for (Enumeration<NetworkInterface> en = NetworkInterface
                    .getNetworkInterfaces(); en.hasMoreElements();) {
                NetworkInterface intf = en.nextElement();
                for (Enumeration<InetAddress> enumIpAddr = intf
                        .getInetAddresses(); enumIpAddr.hasMoreElements();) {
                    InetAddress inetAddress = enumIpAddr.nextElement();
                    if (!inetAddress.isLoopbackAddress()) {
                        return inetAddress.getHostAddress().toString();
                    }
                }
            }
        } catch (SocketException ex) {
            ex.printStackTrace();
        }
        return "";
	}
	
	/**
	 * Getter method for the IP of the current application runner.
	 * @param IP: A string representation of the IP address of the user.
	 */
	public String getIP(){
		return IP;
	}
	
	/**
	 * Getter method for the Username of the current user.
	 * @param username: The username of the user.
	 */
	public String getUsername(){
		return username;
	}
}
