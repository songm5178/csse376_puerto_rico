package csse376_puerto_rico;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Player {

	private String role;
	private boolean isTurn;
	private boolean isMayor;
	private static List<String> roles = new ArrayList<String>(Arrays.asList("Settler",
			"Mayor", "Builder", "Craftsman", "Trader", "Captain", "Prospector"));

	public Player(String role) {
		this.role = role;
		this.isMayor = false;
		this.isTurn = false;
	}

	public String getRole() {
		return this.role;
	}

	/**
	 * TODO Put here a description of what this method does.
	 *
	 * @return
	 */
	public static List<String> getRoles() {

		return roles;
	}

}
