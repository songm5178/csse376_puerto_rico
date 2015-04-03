package csse376_puerto_rico;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.JTextArea;

public class Player extends JTextArea {

	private String role;
	public boolean isTurn;
	public boolean mayor;
	private int points = 0;
	

	private static List<String> roles = new ArrayList<String>(Arrays.asList(
			"Settler", "Builder", "Craftsman", "Trader", "Captain",
			"Prospector"));

	// For Testing purposes, null player
	public Player() {
		this.role = "";
		this.mayor = false;
	}

	public Player(String role) {
		this.role = role;
		this.mayor = false;
		this.isTurn = false;
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
	
	public boolean isMayor(){
		return mayor;
	}

	// Test method
	public void setPoints(int points) {
		// This method is strictly for setting points
		this.points = points;
	}

	public void setRole(String string) {
		this.role = string;

	}

	/**
	 * Draws the parts of the HUD.
	 *
	 * @param g2
	 */
	public void drawOn(Graphics2D g2){
		g2.setFont(new Font( "SansSerif", Font.BOLD, 20 ));
		g2.setColor(Color.BLACK);
		
		String score = "Score: " + this.points;
		g2.drawString(score, 10, 30);
		String role = "Role: " + this.role;
		g2.drawString(role, 890, 30);
	}
	
}
