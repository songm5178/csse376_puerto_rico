package csse376_puerto_rico;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.JTextArea;

public class Player {

	private String role;
	private JTextArea hud;
	public boolean isTurn;
	public boolean isGovernor;
	private int points = 0;
	private ArrayList<String> buildings = new ArrayList<String>();

	class Good {
		public static final String COFFEE = "Coffee";
		public static final String TOBACCO = "Tobacco";
		public static final String CORN = "Corn";
		public static final String SUGAR = "Sugar";
		public static final String INDIGO = "Indigo";
	}

	private static List<String> roles = PlayerRoles.getValues();

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

	public JTextArea getHUD() {
		return this.hud;
	}

	public void setHUD(JTextArea hud) {
		this.hud = hud;
	}

	public boolean isGovernor() {
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

	public void addBuilding(String building) {
		buildings.add(building);

	}

	public Object getBuildings() {

		return buildings;
	}

}
