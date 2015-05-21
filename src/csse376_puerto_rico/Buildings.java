package csse376_puerto_rico;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Buildings {

	private ArrayList<Building> buildings;
	private ArrayList<String> buildingNames = new ArrayList<String>(Arrays.asList("Small Indigo Plant",
			"Small Sugar Mill", "Small Market", "Hacienda", "Construction Hut",
			"Small Warehouse", "Indigo Plant", "Sugar Mill", "Hospice", "Office",
			"Large Market", "Large Warehouse", "Tobacco Storage", "Coffee Roaster",
			"Factory", "University", "Harbor", "Wharf"));

	public Buildings() {
		buildings = new ArrayList<Building>();

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


}
