package csse376_puerto_rico;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import jdk.nashorn.internal.objects.annotations.Getter;

public class Buildings {

	private ArrayList<Building> buildings;

	public Buildings() {
		buildings = new ArrayList<Building>();

		
		List<String> buildingNames = Arrays.asList("Small Indigo Plant",
				"Small Sugar Mill", "Small Market", "Hacienda",
				"ConstructionHut", "Small Warehouse", "Indigo Plant",
				"Surgar Mill", "Hospice"); //TODO: add more
		
		for(String name: buildingNames){
			buildings.add(new Building(name));
		}

	}

	public ArrayList<Building> getBuildings() {

		return buildings;
	}

	public class Building {

		public String name;

		public Building(String name) {

		}
	}
}
