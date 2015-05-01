package csse376_puerto_rico;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Buildings {

	private ArrayList<Building> buildings;
	private ArrayList<String> buildingNames = new ArrayList<String>(Arrays.asList("Small Indigo Plant",
			"Small Sugar Mill", "Small Market", "Hacienda", "ConstructionHut",
			"Small Warehouse", "Indigo Plant", "Surgar Mill", "Hospice"));

	public Buildings() {
		buildings = new ArrayList<Building>();
		// TODO:
		// add
		// more

		for (String name : buildingNames) {
			buildings.add(new Building(name));
		}

	}

	public ArrayList<Building> getBuildings() {

		return buildings;
	}

	public ArrayList<String> getBuildingNames() {
		return buildingNames;
	}

	public static class Building {

		public String name;
		public int cost;
		public int points;
		public int numberOfJobs;
		public int numberOfWorkers;

		public Building(String name) {
			this.name = name;
			switch (name) {
			case "Small Indigo Plant":
				cost = 1;
				points = 1;
				numberOfJobs = 1;
				numberOfWorkers = 0;
				break;

			// TODO: Add all cases for all buildings
			default:
				cost = 0;
				points = 0;
				numberOfJobs = 0;
				numberOfWorkers = 0;
			}
		}
	}
}
