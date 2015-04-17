package csse376_puerto_rico;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.JTextArea;

public class Player {

	private String role;
	private JTextArea hud;
	public boolean isTurn;
	public boolean isGovernor;
	private int points = 0;
	

	private static List<String> roles = new ArrayList<String>(Arrays.asList(
			"Settler", "Builder", "Craftsman", "Trader", "Captain",
			"Prospector", "Mayor"));

	// For Testing purposes, null player
	public Player() {
		this.role = "";
		this.isGovernor = false;
		this.hud = new JTextArea();
	}

	public Player(String role) {
		this.role = role;
		this.isGovernor = false;
		this.isTurn = false;
		this.hud = null;
	}

	public String getRole() {
		return this.role;
	}

	public static List<String> getRoles() {

		return roles;
	}

	public int getPoints() {
		return points;
	}
	
	public JTextArea getHUD(){
		return new JTextArea();
	}
	
	public void setHUD(JTextArea hud){
		this.hud = hud;
	}
	
	public boolean isGovernor(){
		return isGovernor;
	}

	// Test method
	public void setPoints(int points) {
		// This method is strictly for setting points
		this.points = points;
	}

	public void setRole(String string) {
		this.role = string;

	}
	
}
