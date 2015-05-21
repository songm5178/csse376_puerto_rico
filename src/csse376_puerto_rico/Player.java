package csse376_puerto_rico;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import javax.swing.JTextArea;

public class Player {

	private int pNum;
	private int doubloons;
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
		this.doubloons = 0;
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
		this.doubloons = 0;
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
		this.points = this.points + addition;
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

	public boolean ownsBuilding(String building) {
		return getBuildingsStringList().contains(building);
	}

	public boolean ownsOccupiedBuilding(String building) {
		return getOccupiedBuildingsStringList().contains(building);
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

	public Building getBuilding(String building) {
		if (this.getBuildingsStringList().contains(building)) {
			for (Building b : this.buildings) {
				if (b.name == building) {
					return b;
				}
			}
		}
		return null;
	}

	public ArrayList<Building> getOccupiedBuildings() {
		ArrayList<Building> occupiedList = new ArrayList<Building>();
		for (Building b : this.buildings) {
			if ((b.numberOfJobs - b.numberOfWorkers) == 0) {
				occupiedList.add(b);
			}
		}
		return occupiedList;
	}

	public ArrayList<String> getOccupiedBuildingsStringList() {
		ArrayList<String> rtn = new ArrayList<String>();
		for (Building b : this.getOccupiedBuildings()) {
			rtn.add(b.name);
		}
		return rtn;
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
			plantationList = plantationList + " "
					+ this.plantations.get(i).good;
		}
		if (isGovernor) {
			rtn = String
					.format("Player %d \nRole: %s \nScore: %d \nDoubloons: %d \nBuilding: %s \nPlantation: %s \nGoods: %s \nGovernor",
							pNum, role, points, doubloons, buildingList,
							plantationList, goodsList);
		} else {
			rtn = String
					.format("Player %d \nRole: %s \nScore: %d \nDoubloons: %d \nBuilding: %s \nPlantation: %s \nGoods: %s",
							pNum, role, points, doubloons, buildingList,
							plantationList, goodsList);
		}
		return rtn;
	}

	public void updatePlayerInfo() {
		this.hud.setText(this.toString());
	}

	public ArrayList<Plantation> getPlantations() {
		return this.plantations;
	}

	public void addPlantations(Plantation add) {
		this.plantations.add(add);
	}

	public ArrayList<String> getPlantationsStringList() {
		ArrayList<String> rtn = new ArrayList<String>();
		for (Plantation p : this.plantations) {
			rtn.add(p.good);
		}
		return rtn;
	}

	// Only used by the Craftsman: checks if the plantation has a worker and
	// adds one
	// to the respective good count
	public void checkPlantation() {
		for (Plantation p : this.plantations) {
			if (p.hasWorker) {
				// Building condition here
				this.addGood(p.good, 1);
			}
		}
	}

	public int getDoubloons() {
		return this.doubloons;
	}

	public void setDoubloons(int add) {
		this.doubloons = add;
	}

	public void sellGood(String s, int i) {
		this.goods.put(s, this.goods.get(s) - i);

	}

}
