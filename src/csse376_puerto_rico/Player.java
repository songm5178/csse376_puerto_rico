package csse376_puerto_rico;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Player {

	private String role;
	public boolean isTurn;
	private int points = 0;

	private static List<String> roles = new ArrayList<String>(Arrays.asList(
			"Settler", "Mayor", "Builder", "Craftsman", "Trader", "Captain",
			"Prospector"));

	public Player(String role) {
		this.role = role;

		this.isTurn = false;
	}

	public String getRole() {
		return this.role;
	}

	public static List<String> getRoles() {

		return roles;
	}
	
	public int getPoints(){
		return points;
	}

}
