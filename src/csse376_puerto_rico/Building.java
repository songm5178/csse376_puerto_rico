package csse376_puerto_rico;


public class Building {

	public String name;
	public int cost;
	public int points;
	public int numberOfJobs;
	public int numberOfWorkers;

	public String storedGood;
	public int amountOfStoredGood;

	public Building(String name) {
		this.name = name;
		switch (name) {
		case "Small Indigo Plant":
			cost = 1;
			points = 1;
			numberOfJobs = 1;
			numberOfWorkers = 0;
			break;

		case "Small Sugar Mill":
			cost = 2;
			points = 1;
			numberOfJobs = 1;
			numberOfWorkers = 0;
			break;

		case "Small Market":
			// plus doubloon with sale in trader phase
			cost = 1;
			points = 1;
			numberOfJobs = 1;
			numberOfWorkers = 0;
			break;

		case "Hacienda":
			// plus plantation from supply in settler phase
			cost = 2;
			points = 1;
			numberOfJobs = 1;
			numberOfWorkers = 0;
			break;

		case "Construction Hut":
			// quarry instead of plantation in settler phase
			cost = 2;
			points = 1;
			numberOfJobs = 1;
			numberOfWorkers = 0;
			break;

		case "Small Warehouse":
			// store 1 kind of good in captain phase
			cost = 3;
			points = 1;
			numberOfJobs = 1;
			numberOfWorkers = 0;
			storedGood = "";
			amountOfStoredGood = 0;
			break;

		case "Indigo Plant":
			cost = 3;
			points = 2;
			numberOfJobs = 3;
			numberOfWorkers = 0;
			break;

		case "Sugar Mill":
			cost = 4;
			points = 2;
			numberOfJobs = 3;
			numberOfWorkers = 0;
			break;

		case "Hospice":
			// plus colonist for settling in settler phase
			cost = 4;
			points = 2;
			numberOfJobs = 1;
			numberOfWorkers = 0;
			break;

		case "Office":
			// sell same kind of goods in trader phase
			cost = 5;
			points = 2;
			numberOfJobs = 1;
			numberOfWorkers = 0;
			break;

		case "Large Market":
			// plus 2 doubloons with sale in trader phase
			cost = 5;
			points = 2;
			numberOfJobs = 1;
			numberOfWorkers = 0;
			break;

		case "Large Warehouse":
			// stores 2 kinds of goods in captain phase
			cost = 6;
			points = 2;
			numberOfJobs = 1;
			numberOfWorkers = 0;
			storedGood = "";
			amountOfStoredGood = 0;
			break;

		case "Tobacco Storage":
			cost = 5;
			points = 3;
			numberOfJobs = 3;
			numberOfWorkers = 0;
			break;

		case "Coffee Roaster":
			cost = 6;
			points = 3;
			numberOfJobs = 2;
			numberOfWorkers = 0;
			break;

		case "Factory":
			// plus 0/1/2/3/5 doubloons with production in craftsman phase
			cost = 7;
			points = 3;
			numberOfJobs = 1;
			numberOfWorkers = 0;
			break;

		case "University":
			// plus colonist for building in builder phase
			cost = 8;
			points = 3;
			numberOfJobs = 1;
			numberOfWorkers = 0;
			break;

		case "Harbor":
			// plus victory point per delivery in captain phase
			cost = 8;
			points = 3;
			numberOfJobs = 1;
			numberOfWorkers = 0;
			break;

		case "Wharf":
			// your own ship in captain phase
			cost = 9;
			points = 3;
			numberOfJobs = 1;
			numberOfWorkers = 0;
			break;

		default:
			cost = 0;
			points = 0;
			numberOfJobs = 0;
			numberOfWorkers = 0;
		}

	}

	public boolean isOccupied() {
		return ((this.numberOfJobs - this.numberOfWorkers) == 0);
	}
}