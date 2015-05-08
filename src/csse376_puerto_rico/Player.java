package csse376_puerto_rico;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import javax.swing.JTextArea;

import csse376_puerto_rico.Buildings.Building;

public class Player {

	private int pNum;
	private String role;
	private JTextArea hud;
	public boolean isTurn;
	public boolean isGovernor;
	private int points = 0;

	private ArrayList<Building> buildings = new ArrayList<Building>();

	public static class Good {
		public static final String COFFEE = "Coffee";
		public static final String TOBACCO = "Tobacco";
		public static final String CORN = "Corn";
		public static final String SUGAR = "Sugar";
		public static final String INDIGO = "Indigo";
	}

	public static class Plantation {
		public String good;
		public boolean hasWorker;

		public Plantation(String good, boolean hasWorker) {
			this.good = good;
			this.hasWorker = hasWorker;
		}
	}

	private ArrayList<Plantation> plantations = new ArrayList<Plantation>();
	private HashMap<String, Integer> goods = new HashMap<String, Integer>();
	private static List<String> roles = PlayerRoles.getValues();

	// For Testing purposes, null player
	public Player() {
		this.pNum = 0;
		this.role = "";
		this.isGovernor = false;
		this.hud = new JTextArea();
		for (String s : this.getAllGoods()) {
			this.goods.put(s, 0);
		}
	}

	public Player(String role) {
		this.role = role;
		this.isGovernor = false;
		this.isTurn = false;
		this.hud = null;
		for (String s : this.getAllGoods()) {
			this.goods.put(s, 0);
		}
	}

	public void setPlayerNum(int i) {
		this.pNum = i;

	}

	public int getPlayerNum() {
		return this.pNum;
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


	public void addPoints(int addition) {
		this.points = this.points + 3;
	}
	
	// Test method
	public void setPoints(int points) {
		// This method is strictly for setting points
		this.points = points;
	}

	public void setRole(String string) {
		this.role = string;
	}

	public void addBuilding(Building building) {
		buildings.add(building);
	}

	public ArrayList<String> getBuildingsStringList() {
		ArrayList<String> rtn = new ArrayList<String>();
		for (Building b : this.buildings) {
			rtn.add(b.name);
		}
		return rtn;
	}

	public ArrayList<Building> getBuildings() {
		return this.buildings;
	}

	public List<String> getGoods() {
		//
		List<String> rtn = new ArrayList<String>();
		String coffee = "Coffee: "
				+ Integer.toString((getNumberOfGood("Coffee")));
		String tobacco = "Tobacco: "
				+ Integer.toString((getNumberOfGood("Tobacco")));
		String corn = "Corn: " + Integer.toString((getNumberOfGood("Corn")));
		String sugar = "Sugar: " + Integer.toString((getNumberOfGood("Sugar")));
		String indigo = "Indigo: "
				+ Integer.toString((getNumberOfGood("Indigo")));
		rtn.addAll(Arrays.asList(coffee, corn, tobacco, sugar, indigo));
		return rtn;
	}

	public int getNumberOfGood(String good) {
		// added case where there were no goods
		if (this.goods.get(good) == null) {
			return 0;
		}
		return this.goods.get(good);

	}

	public List<String> getAllGoods() {
		List<String> rtn = new ArrayList<String>();
		rtn.addAll(Arrays.asList(Good.COFFEE, Good.CORN, Good.INDIGO,
				Good.SUGAR, Good.TOBACCO));
		return rtn;
	}

	public void addGood(String good, int number) {
		// adds the number to the original
		this.goods.put(good, this.goods.get(good) + number);
	}

	@Override
	public String toString() {
		String rtn = "";
		String buildingList = "";
		String goodsList = this.getGoods().toString();
		String plantationList = "";
		for (int i = 0; i < this.buildings.size(); i++) {
			buildingList = buildingList + " " + this.buildings.get(i).name;
		}
		for (int i = 0; i < this.plantations.size(); i++) {
			plantationList += this.plantations.get(i).good;
		}
		if (isGovernor) {
			rtn = String
					.format("Player %d \nRole: %s \nScore: %d \nBuilding: %s \nPlantation: %s \nGovernor",
							pNum, role, points, buildingList, plantationList,
							goodsList);
		} else {
			rtn = String
					.format("Player %d \nRole: %s \nScore: %d \nBuilding: %s \nPlantation: %s",
							pNum, role, points, buildingList, plantationList,
							goodsList);
		}
		return rtn;
	}

	public void updatePlayerInfo() {
		this.hud.setText(this.toString());
	}

	public ArrayList<Plantation> getPlantations() {
		return this.plantations;
	}

	public ArrayList<String> getPlantationsStringList() {
		ArrayList<String> rtn = new ArrayList<String>();
		for (Plantation p : this.plantations) {
			rtn.add(p.good);
		}
		return rtn;
	}

}
